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

<div class="page_title gradient_overlay" style="background: url(images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>Sign In</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">Home</a></li>
                <li>Sign In</li>
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


                <c:if test="${requestScope.containsKey('wrongData')}">
                    <%--${wrongPassOrLoginTxt}--%>
                </c:if>

                <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController" method="post" name="enrollee-fill">
                    <input type="hidden" name="command" value="FILL_ENROLLEE"/>

                    <div class="row">
                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${surnameTxt}</label>
                            <input type="text" class="form-control" name="surname" placeholder="${surnameTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${nameTxt}</label>
                            <input type="text" class="form-control" name="name" placeholder="${nameTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${patronymicTxt}</label>
                            <input type="text" class="form-control" name="patronymic" placeholder="${patronymicTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${phoneNumberTxt}</label>
                            <input type="tel" class="form-control" name="phoneNumber" placeholder="${phoneNumberTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${passportTxt}</label>
                            <input type="tel" class="form-control" name="passport" placeholder="${passportTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label for="faculties" class="control-label">${facultyTxt}</label>
                            <select id="faculties" name="faculty" class="form-control">
                                <option></option>
                                <c:forEach var="faculty" items="${faculties}">
                                    <option value="${faculty.facultyId}">${faculty.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label for="countries" class="control-label">${countryTxt}</label>
                            <select id="countries" name="country" class="form-control">
                                <option></option>
                                <c:forEach var="country" items="${countries}">
                                    <option value="${country.countryId}">${country.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label for="cities" class="control-label">${cityTxt}</label>
                            <select id="cities" name="city" class="form-control"></select>
                        </div>

                        <div id="ajax-subjects">

                        </div>

                        <%--
                        <div class="form-group col-md-12 col-sm-12">
                            <c:forEach var="subject" items="${subjects}">
                                <label for="subjects">
                                    <input id="subjects" type="checkbox" name="idSubject"
                                           value="${subject.subjectId}">${subject.name}<BR>
                                </label>
                            </c:forEach>
                        </div>
                        --%>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${sertificateScoreTxt}</label>
                            <input type="number" class="form-control" name="sertificateScore" placeholder="${sertificateScoreTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${ctScoreTxt}</label>
                            <input type="number" class="form-control" name="ctScore" placeholder="${ctScoreTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">Privelegy</label>
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
