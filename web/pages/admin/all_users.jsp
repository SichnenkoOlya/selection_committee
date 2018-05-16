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

<%--
<main id="our_staff_page">
    <div class="container">
        <div class="row">
            <div class="form-group col-md-3">
                <a class="button btn_yellow"
                   href="${pageContext.request.contextPath}/mainController?command=SHOW_ALL_USERS">
                    ${allUsersTxt}
                </a>
            </div>

            <div class="form-group col-md-3">
                <form action="${pageContext.request.contextPath}/mainController" method="get">
                    <input type="hidden" name="command" value="SHOW_USERS_BY_STATUS"/>
                    <input type="hidden" name="statusId" value="${notAdmittedStatus}"/>
                    <input type="submit" class="button btn_yellow" name="commit" value="${notAdmittedUsersTxt}">
                </form>
            </div>

            <div class="form-group col-md-3">
                <form action="${pageContext.request.contextPath}/mainController" method="get">
                    <input type="hidden" name="command" value="SHOW_USERS_BY_STATUS"/>
                    <input type="hidden" name="statusId" value="${documentFillStatus}"/>
                    <input type="submit" class="button btn_yellow" name="commit" value="${needConfirmUsersTxt}">
                </form>
            </div>

            <div class="form-group col-md-3">
                <form action="${pageContext.request.contextPath}/mainController" method="get">
                    <input type="hidden" name="command" value="SHOW_USERS_BY_STATUS"/>
                    <input type="hidden" name="statusId" value="${documentRejectedStatus}"/>
                    <input type="submit" class="button btn_yellow" name="commit" value="${rejectedUsersTxt}">
                </form>
            </div>
            <ctg:emptyList items="${users}">
                <h2>${emptyUsersTxt}</h2>
            </ctg:emptyList>


            <c:forEach var="user" items="${users}">
                <div class="col-md-3 col-sm-6">
                    <div class="item">
                        <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${user.login}"
                           class="hover_effect h_blue h_link">
                            <img src="${pageContext.request.contextPath}${user.imagePath}" class="img-responsive"
                                 alt="${user.login}">
                        </a>
                        <h5>
                            <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${user.login}">
                                    ${user.login}
                            </a>
                            <small>${user.role}</small>
                        </h5>
                    </div>
                </div>

            </c:forEach>
        </div>
    </div>
</main>
--%>

<%@include file="/pages/partial/footer.jsp" %>
