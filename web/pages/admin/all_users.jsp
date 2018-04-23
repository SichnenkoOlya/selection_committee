<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.users" var="usersTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.role" var="roleTxt"/>

<div class="page_title gradient_overlay" style="background: url(images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>Our Users</h1>
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Our Users</li>
            </ol>
        </div>
    </div>
</div>


<!-- =========== MAIN ========== -->
<main id="our_staff_page">
    <div class="container">

        <form action="${pageContext.request.contextPath}/mainController" method="post">
            <input type="hidden" name="command" value="SHOW_USERS_BY_STATUS"/>
            <input type="hidden" name="statusId" value="4"/>
            <input type="submit" name="commit" value="Users with documents">
        </form>

        <div class="row">

            <c:forEach var="user" items="${users}">
                <div class="col-md-3 col-sm-6">
                    <div class="item">
                        <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${user.login}" class="hover_effect h_blue h_link">
                            <img src="${pageContext.request.contextPath}${user.imagePath}" class="img-responsive" alt="${user.login}">
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

<%@include file="/pages/partial/footer.jsp" %>
