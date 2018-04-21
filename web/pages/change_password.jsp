<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 16.04.2018
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.new_password" var="passwordTxt"/>
<fmt:message key="label.old_password" var="oldPasswordTxt"/>
<fmt:message key="label.confirm_password" var="confirmPasswordTxt"/>
<fmt:message key="label.change_password" var="changePasswordTxt"/>
<body>
${changePasswordTxt}
<br/>
<form action="${pageContext.request.contextPath}/mainController" method="post">
    <label for="oldPasswordInput">
        ${oldPasswordTxt}
    </label>
    <br/>
    <input id="oldPasswordInput" type="password" name="oldPassword" value=""/>
    <br/>
    <br/>
    <label for="newPasswordInput">
        ${passwordTxt}
    </label>
    <br/>
    <input id="newPasswordInput" type="password" name="newPassword" value=""/>
    <br/>
    <label for="passwordConfirmInput">
        ${confirmPasswordTxt}
    </label>
    <br/>
    <input id="passwordConfirmInput" type="password" name="confirmPassword" value=""/>
    <br/>

    <input type="hidden" name="command" value="CHANGE_PASSWORD"/>
    <input type="submit" name="commit" value=${changePasswordTxt}>
</form>

</body>
<%@include file="/pages/partial/footer.jsp" %>
