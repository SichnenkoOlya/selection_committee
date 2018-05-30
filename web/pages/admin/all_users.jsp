<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.users" var="usersTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.role" var="roleTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.empty_users_list" var="emptyUsersTxt"/>

<fmt:message key="label.all_users" var="allUsersTxt"/>
<fmt:message key="label.not_admitted_users" var="notAdmittedUsersTxt"/>
<fmt:message key="label.users_need_confirm_document" var="needConfirmUsersTxt"/>
<fmt:message key="label.users_with_rejected_documents" var="rejectedUsersTxt"/>

<fmt:setBundle basename="general" var="general"/>
<fmt:message key="status.not_admitted" var="notAdmittedStatus" bundle="${general}"/>
<fmt:message key="status.document_fill" var="documentFillStatus" bundle="${general}"/>
<fmt:message key="status.document_rejected" var="documentRejectedStatus" bundle="${general}"/>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${usersTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${usersTxt}</li>
            </ol>
        </div>
    </div>
</div>

<main id="gallery">
    <div class="container">
        <div class="grid_filters">
            <a href="#" data-filter="*" class="button btn_sm btn_blue active">
                ${allUsersTxt}
            </a>
            <a href="#" data-filter="*[data-type-user='5']" class="button btn_sm btn_blue">
                ${notAdmittedUsersTxt}
            </a>
            <a href="#" data-filter="*[data-type-user='6']" class="button btn_sm btn_blue">
                ${needConfirmUsersTxt}
            </a>
            <a href="#" data-filter="*[data-type-user='7']" class="button btn_sm btn_blue">
                ${rejectedUsersTxt}
            </a>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="grid gallery_items">

                <c:forEach var="entry" items="${users}">

                    <figure class="g_item col-md-3 col-sm-6" data-type-user="${entry.value}">
                        <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${entry.key.login}"
                           class="hover_effect h_blue h_link one-height">
                            <img src="${pageContext.request.contextPath}${entry.key.imagePath}" class="img-responsive"
                                 alt="${entry.key.login}">
                        </a>
                        <figcaption>
                            <h4>
                                <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${entry.key.login}">
                                    ${entry.key.login}
                                </a>
                            </h4>
                            <span>${entry.key.role}</span>
                        </figcaption>
                    </figure>

                </c:forEach>

            </div>
        </div>
    </div>
</main>
<%@include file="/pages/partial/footer.jsp" %>
