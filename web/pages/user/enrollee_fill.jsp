<%@include file="/pages/partial/header.jsp" %>

<fmt:message key="label.fill_enrollee_profile" var="fillProfileTxt"/>
<fmt:message key="label.phoneNumber" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.name" var="nameTxt"/>
<fmt:message key="label.fill" var="fillTxt"/>
<fmt:message key="label.enrollee.surname" var="surnameTxt"/>
<fmt:message key="label.enrollee.patronymic" var="patronymicTxt"/>
<fmt:message key="label.enrollee.phone_number" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.faculty" var="facultyTxt"/>
<fmt:message key="label.city" var="cityTxt"/>
<fmt:message key="label.country" var="countryTxt"/>
<fmt:message key="label.passport" var="passportTxt"/>
<fmt:message key="label.sertificateScore" var="sertificateScoreTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.privilege" var="privilegeTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${fillProfileTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${fillProfileTxt}</li>
            </ol>
        </div>
    </div>
</div>

<main>
    <div class="container">

        <div class="row">
            <div class="col-md-6">

                <div class="main_title a_left">
                    <h2><c:out value="${fillProfileTxt}"/></h2>
                </div>

                <c:if test="${requestScope.containsKey('incorrectData')}">
                    ${incorrectDataTxt}
                    ${makeSureTxt}
                </c:if>

                <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController" method="post"
                      name="enrollee-fill">
                    <c:if test="${empty enrollee}">
                        <input type="hidden" name="command" value="FILL_ENROLLEE"/>
                    </c:if>
                    <c:if test="${not empty  enrollee}">
                        <input type="hidden" name="command" value="EDIT_ENROLLEE"/>
                        <input type="hidden" name="enrolleeId" value="${enrollee.enrolleeId}"/>
                    </c:if>

                    <div class="row">
                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${surnameTxt}</label>
                            <p id="input-surname" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validateName"
                                   data-error-area-id="input-surname"
                                   data-error-message="${incorrectDataTxt}"
                                   type="text"
                                   class="form-control"
                                   name="surname"
                                   placeholder="${surnameTxt}"
                                   value="${enrollee.surname}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${nameTxt}</label>
                            <p id="input-name" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validateName"
                                   data-error-area-id="input-name"
                                   data-error-message="${incorrectDataTxt}"
                                   type="text"
                                   class="form-control"
                                   name="name"
                                   placeholder="${nameTxt}"
                                   value="${enrollee.name}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${patronymicTxt}</label>
                            <p id="input-patronymic" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validateName"
                                   data-error-area-id="input-patronymic"
                                   data-error-message="${incorrectDataTxt}"
                                   type="text"
                                   class="form-control"
                                   name="patronymic"
                                   placeholder="${patronymicTxt}"
                                   value="${enrollee.patronymic}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${phoneNumberTxt}</label>
                            <p id="input-phoneNumber" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validatePhoneNumber"
                                   data-error-area-id="input-phoneNumber"
                                   data-error-message="${incorrectDataTxt}"
                                   type="tel"
                                   class="form-control"
                                   name="phoneNumber"
                                   placeholder="${phoneNumberTxt}"
                                   value="${enrollee.phoneNumber}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${passportTxt}</label>
                            <p id="input-passport" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validatePassportNumber"
                                   data-error-area-id="input-passport"
                                   data-error-message="${incorrectDataTxt}"
                                   type="text"
                                   class="form-control"
                                   name="passport"
                                   placeholder="${passportTxt}"
                                   value="${enrollee.passport}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label for="countries" class="control-label">${countryTxt}</label>
                            <p id="input-country" class="error display-none"></p>
                            <select data-validation="true"
                                    data-type-validation="validateEmpty"
                                    data-error-area-id="input-country"
                                    data-error-message="${incorrectDataTxt}"
                                    id="countries"
                                    name="country"
                                    class="form-control">
                                <option></option>
                                <c:forEach var="country" items="${countries}">
                                    <option value="${country.countryId}">${country.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label for="cities" class="control-label">${cityTxt}</label>
                            <p id="input-city" class="error display-none"></p>
                            <select data-validation="true"
                                    data-type-validation="validateEmpty"
                                    data-error-area-id="input-city"
                                    data-error-message="${incorrectDataTxt}"
                                    id="cities"
                                    name="city"
                                    class="form-control"></select>
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label for="faculties" class="control-label">${facultyTxt}</label>
                            <p id="input-faculty" class="error display-none"></p>
                            <select data-validation="true"
                                    data-type-validation="validateEmpty"
                                    data-error-area-id="input-faculty"
                                    data-error-message="${incorrectDataTxt}"
                                    id="faculties"
                                    name="faculty"
                                    class="form-control">
                                <option></option>
                                <c:forEach var="faculty" items="${faculties}">
                                    <option value="${faculty.facultyId}">${faculty.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div id="ajax-subjects">

                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${sertificateScoreTxt}</label>
                            <p id="input-sertificateScore" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validateEmpty"
                                   data-error-area-id="input-sertificateScore"
                                   data-error-message="${incorrectDataTxt}"
                                   type="number"
                                   class="form-control"
                                   name="sertificateScore"
                                   placeholder="${sertificateScoreTxt}"
                                   value="${enrollee.avarageCertificateScore}">
                        </div>


                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${privilegeTxt}</label>
                            <c:forEach var="privilege" items="${privileges}">
                                <br/>
                                <label for="privileges">
                                    <input id="privileges" type="checkbox" name="idPrivilege"
                                           value="${privilege.privilegeId}">
                                        ${privilege.name}
                                </label>
                            </c:forEach>
                        </div>

                        <div class="form-group col-md-12">
                            <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                <i class="fa fa-check" aria-hidden="true"></i>${fillTxt}
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</main>
<%@include file="/pages/partial/footer.jsp" %>
