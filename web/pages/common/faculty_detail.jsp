<%@include file="/pages/partial/header.jsp" %>

<fmt:message key="label.facultyName" var="facultyNameTxt"/>
<fmt:message key="label.description" var="descriptionTxt"/>
<fmt:message key="label.budjet_count" var="budjetTxt"/>
<fmt:message key="label.paid_count" var="paidTxt"/>
<fmt:message key="label.paid_score" var="scorePaidTxt"/>
<fmt:message key="label.budjet_score" var="scoreBudjetTxt"/>
<fmt:message key="label.subjects" var="subjectsTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.change_faculty_photo" var="changePhotoTxt"/>
<fmt:message key="label.choose_photo" var="choosePhotoTxt"/>
<fmt:message key="label.file_not_selected" var="fileNotSelectedTxt"/>
<fmt:message key="label.ok" var="okTxt"/>
<fmt:message key="label.end_committee" var="enrollTxt"/>
<fmt:message key="label.finish_date" var="finishDateTxt"/>
<fmt:message key="error.image_not_loaded" var="imageNotLoadedTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>

<body>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${faculty.name}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${faculty.name}</li>
            </ol>
        </div>
    </div>
</div>

<main id="our_staff_page">
    <div class="container">

        <div class="row">

            <div class="col-md-6">
                <c:if test="${requestScope.containsKey('imageNotLoaded')}">
                    ${imageNotLoadedTxt}
                    ${makeSureTxt}
                </c:if>

                <c:if test="${requestScope.containsKey('incorrectData')}">
                    ${incorrectDataTxt}
                    ${makeSureTxt}
                </c:if>

                <h2 class="c_title">${faculty.name}</h2>
                <dl class="info custom-info">
                    <dt>${facultyNameTxt}</dt>
                    <dd>${faculty.name}</dd>

                    <dt>${budjetTxt}</dt>
                    <dd>${faculty.budjetPlaceCount}</dd>

                    <dt>${paidTxt}</dt>
                    <dd>${faculty.paidPlaceCount}</dd>

                    <dt>${scoreBudjetTxt}</dt>
                    <dd>${faculty.passingScoreBudjet}</dd>

                    <dt>${scorePaidTxt}</dt>
                    <dd>${faculty.passingScorePaid}</dd>

                    <dt>${finishDateTxt}</dt>
                    <dd>${faculty.finishDate}</dd>

                    <dt>${subjectsTxt}</dt>

                    <dd>
                        <c:forEach var="subject" items="${faculty.subjects}">
                            ${subject.name}<br>
                        </c:forEach>
                    </dd>

                </dl>
                <br>
                <ctg:admin role="${user.role}">
                    <jsp:useBean id="currentDate" class="java.util.Date"/>
                    <c:if test="${not faculty.isFinish and faculty.finishDate lt currentDate}">

                        <a href="${pageContext.request.contextPath}/mainController?command=ENROLL_TO_FACULTY&facultyId=${faculty.facultyId}"
                           class="button btn_lg btn_yellow">
                            ${enrollTxt}
                        </a>

                    </c:if>
                </ctg:admin>
                <br>
                <h2 class="c_title">${descriptionTxt}</h2>
                <p>${faculty.description}</p>
                <br/>
                <ctg:admin role="${user.role}">
                    <form action="${pageContext.request.contextPath}/uploadController" method="post"
                          enctype="multipart/form-data">
                        <input type="hidden" name="command" value="LOAD_FACULTY_IMAGE"/>
                        <input type="hidden" name="facultyId" value="${faculty.facultyId}"/>

                        <h3>${changePhotoTxt}</h3>
                        <br/>
                        <div class="fl_upld">
                            <label for="fl_inp" class="custom-file-upload button btn_sm btn_yellow">
                                <i class="fa fa-cloud-upload"></i>${choosePhotoTxt}
                            </label>
                            <p id="input-file" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validateEmpty"
                                   data-error-area-id="input-file"
                                   data-error-message="${fileNotSelectedTxt}"
                                   id="fl_inp"
                                   type="file"
                                   name="image"/>
                            <br/>
                            <div id="fl_nm" class="file-not-selected">${fileNotSelectedTxt}</div>
                            <button type="submit" class="button btn_sm btn_yellow button-one-width"><i class="fa fa-check"></i>${okTxt}</button>
                        </div>
                    </form>
                </ctg:admin>
            </div>
            <div class="col-md-6">
                <a class="hover_effect h_lightbox h_blue">
                    <img class="img-responsive img-full"
                         src="${pageContext.request.contextPath}${faculty.imagePath}"
                         alt="${faculty.name}">
                </a>
            </div>
        </div>
    </div>
</main>

<%@include file="/pages/partial/footer.jsp" %>