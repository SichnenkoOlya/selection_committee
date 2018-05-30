(function ($) {
    "use strict";

    $(document).ready(function () {

        $('#countries').change(function () {

            var data = {command: "FIND_CITIES_BY_COUNTRY_ID", countryId: $(this).val()};
            $.ajax({
                type: "POST",
                url: "/mainController",
                data: data,
                dataType: "json",
                success: function (data, textStatus, jqXHR) {
                    if(data[0] !== null) {
                        $('#cities').html(generateCitiesOption(data));
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Something really bad happened " + textStatus);

                },
                beforeSend: function (jqXHR) {
                    $('#cities').html('');
                }
            });
        });

        $("#faculties").change(function () {
            var data = {command: "FIND_SUBJECTS_BY_FACULTY", facultyId: $(this).val()};
            $.ajax({
                type: "POST",
                url: "/mainController",
                data: data,
                dataType: "json",
                success: function (data, textStatus, jqXHR) {
                    if(data[0] !== null) {
                        $('#ajax-subjects').html(generateSubjects(data));
                        disableInputs();
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Something really bad happened " + textStatus);

                },
                beforeSend: function (jqXHR) {
                    $('#ajax-subjects').html('');
                }
            });
        });

        function generateCitiesOption(data) {
            var html = "";
            data.forEach(function (value) {
                html += "<option value='" + value["cityId"] + "'>" + value["name"] + "</option>"
            });
            return html;
        }

        function generateSubjects(data) {
            var html = '';
            data.forEach(function (value, i) {

                var rand = (Math.random() * 100001);
                html += '<div class="form-group col-md-12 col-sm-12" id="group-' + value["groupNumber"] + '">' +
                    '<label class="control-label">' + value["name"] + '</label>' +
                    '<input type="hidden" name="idSubject" value="' + value["subjectId"] + '"/>' +
                    '<p id="input-countScore-' + rand + '" class="error display-none"></p>' +
                    '<input data-validation="true" ' +
                    'data-type-validation="validateCertificateScore" ' +
                    'data-error-area-id="input-countScore-' + rand + '" ' +
                    'data-error-message="${incorrectDataTxt}" ' +
                    'type="number" class="form-control" data-group="group-' + value["groupNumber"] + '" name="countScore"/>' +
                    '</div>';
            });
            return html;
        }

        function disableInputs() {
            $("input[name=countScore]").change(function (e) {

                var inputValue = $(this).val();
                var groupId = $(this).data('group');

                $('div#' + groupId).each(function (index, value) {

                    var parent = $(value);

                    if ($.trim(inputValue) !== '') {
                        if (parent.find($(e.target)).length === 0) {
                            parent.find("input").prop("disabled", true);
                        }
                    }
                    else {
                        parent.find("input").prop("disabled", false);
                    }
                });
            })
        }


        $("form[name=enrollee-fill]").submit(
            function (e) {
                var error = [];

                var countScoreInput = $(this).find('input[name=countScore]:enabled');
                var countValue = 0;

                countScoreInput.each(function (item, value) {
                    var inputValue = $(value).val();

                    if ((inputValue < 0) || (inputValue > 100)) {
                        error.push('Fill number from 0 to 100.');
                    }
                    else if((inputValue >= 0) && (inputValue <= 100)){
                        countValue += 1;
                    }
                });
                
                if (countValue !== 3){
                    error.push('3 items not fill.');
                }

                console.log(error);

            }
        );

        var formsOnPage = $('form');

        formsOnPage.submit(function (e) {

            var form = $(this);
            var elements = form.find('*[data-validation="true"]');

            var result = true;
            elements.each(function (index, element) {

                if (!validateInput(element)) {

                    result = false;

                }

            });

            if (!result) {
                e.preventDefault();
            }

        });

        formsOnPage.find('*[data-validation="true"]').on("change keyup", function (e) {
            validateInput(this);
        });

        function validateInput(el) {
            var error = [];

            var element = $(el);
            var arrayTypeValidation = element.data("typeValidation").split('|');
            var errorArea = $('#' + element.data("errorAreaId"));
            var errorMessage = element.data("errorMessage");
            var value = element.val();
            var name = element.attr("name");

            var validatePhoneNumber = new RegExp('^(?:\\+|\\d)[\\d\\- ]{9,}\\d$');
            var validateName = new RegExp('^([A-Z][a-z]{1,25})|([А-Я][а-я]{1,25})$');
            var validatePassportNumber = new RegExp('^[A-Z]{2}\\d{7,8}$');
            var MAX_VALUE = 0;
            var MIN_VALUE = 100;

            var validateEmail = new RegExp('^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$');
            var validateLogin = new RegExp('^(?:[a-zA-Z][a-zA-Z0-9\\_]{1,22}[a-zA-Z])$');
            var validatePassword = new RegExp('^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}$');

            function validate(Regexp) {
                if (!Regexp.test(value)) {
                    error.push(errorMessage);
                }
            }

            arrayTypeValidation.forEach(function (typeValidation) {
                switch (typeValidation) {
                    case "validatePhoneNumber":

                        validate(validatePhoneNumber);

                        break;
                    case "validateName":

                        validate(validateName);

                        break;
                    case "validatePassportNumber":

                        validate(validatePassportNumber);

                        break;
                    case "validateCertificateScore":

                        if (!(value >= MIN_VALUE && value <= MAX_VALUE)) {
                            error.push(errorMessage);
                        }

                        break;
                    case "validateEmail":

                        validate(validateEmail);

                        break;
                    case "validateLogin":

                        validate(validateLogin);

                        break;
                    case "validatePassword":

                        validate(validatePassword);

                        break;
                    case "validateEmpty":

                        if ((value === null) || (value.length === 0)) {
                            error.push(errorMessage);
                        }

                        break;
                    case "validateUnsignedNotZero":

                        if ((value.length === 0) || (value < 1)) {
                            error.push(errorMessage);
                        }

                        break;
                    case "validateDate":

                        if((value.length === 0) || (new Date(value) < new Date())) {
                            error.push(errorMessage);
                        }

                        break;
                    case "validateCount":

                        if($('input[name="' + name + '"]:checked').length < 1){
                            error.push(errorMessage);
                        }

                        break;
                    default:
                        break;
                }
            });

            var errorString = error.join('<br/>');

            if(error.length === 0){

                errorArea.slideUp();
                errorArea.html(errorString);

                return true;
            }
            else{

                errorArea.html(errorString);
                errorArea.slideDown();

                return false;
            }
        }


        $('.one-height').matchHeight();

        $('#reject-document').submit(function (e) {
            var form = $(this);
            var submit = form.find('input[type="submit"]');
            var textarea = form.find('#reject-textarea');

            if(submit.data('showTextarea') === true){

                submit.data('showTextarea', false);
                textarea.slideDown();
                e.preventDefault();
            }

        });
    });
})(jQuery);