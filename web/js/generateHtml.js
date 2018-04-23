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
                    $('#cities').html(generateCitiesOption(data));
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
                    $('#ajax-subjects').html(generateSubjects(data));
                    disableInputs();

                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Something really bad happened " + textStatus);

                },
                beforeSend: function (jqXHR) {
                    $('#ajax-subjects').html('Subjects are loaded...');
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

                html += '<div class="form-group col-md-12 col-sm-12" id="group-' + value["groupNumber"] + '">' +
                    '<label class="control-label">' + value["name"] + '</label>' +
                    '<input type="hidden" name="idSubject" value="' + value["subjectId"] + '"/>' +
                    '<input type="number" class="form-control" data-group="group-' + value["groupNumber"] + '" name="countScore"/>' +
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
                e.preventDefault();
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

    });
})(jQuery);