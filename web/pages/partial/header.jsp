<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'en'}" scope="session"/>
<fmt:setLocale value="${locale}"/>

<fmt:setBundle basename="text" scope="session"/>
<fmt:message key="label.Russian" var="russianTxt"/>
<fmt:message key="label.English" var="englishTxt"/>
<fmt:message key="label.university" var="universityTxt"/>
<fmt:message key="label.welcome" var="welcomeTxt"/>
<fmt:message key="label.sign_in" var="signInTxt"/>
<fmt:message key="label.sign_out" var="signOutTxt"/>
<fmt:message key="label.sign_up" var="signUpTxt"/>
<fmt:message key="label.hello" var="helloTxt"/>
<fmt:message key="label.change_password" var="changePasswordTxt"/>
<fmt:message key="label.edit_user_profile" var="editUserProfileTxt"/>
<fmt:message key="label.my_profile" var="myProfileTxt"/>
<fmt:message key="label.submitDocuments" var="submitDocumentsTxt"/>
<fmt:message key="label.add_faculty" var="addFacultyTxt"/>
<fmt:message key="label.add_country" var="addCountryTxt"/>
<fmt:message key="label.add_city" var="addCityTxt"/>
<fmt:message key="label.users" var="usersTxt"/>
<fmt:message key="label.add" var="addTxt"/>

<html>
<head>
    <title>${universityTxt}</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">

    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.png">

    <!-- ========== STYLESHEETS ========== -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/revolution/css/layers.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/revolution/css/settings.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/revolution/css/navigation.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/famfamfam-flags.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/magnific-popup.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/owl.carousel.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet" type="text/css">

    <!-- ========== ICON FONTS ========== -->
    <link href="${pageContext.request.contextPath}/fonts/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon.css" rel="stylesheet">

    <!-- ========== GOOGLE FONTS ========== -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900%7cRaleway:400,500,600,700"
          rel="stylesheet">

</head>

<div class="wrapper">

    <!-- ========== TOP MENU ========== -->
    <div class="top_menu">
        <div class="container">
            <div class="welcome_mssg hidden-xs">
                ${welcomeTxt}
            </div>
            <ul class="top_menu_right">
                <c:if test="${empty sessionScope.user}">
                    <li>
                        <a href="${pageContext.request.contextPath}/mainController?command=SHOW_SIGN_IN_PAGE">
                                ${signInTxt}
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/mainController?command=SHOW_SIGN_UP_PAGE">
                                ${signUpTxt}
                        </a>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <li>
                            ${helloTxt} ${sessionScope.user.login}!
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/mainController?command=SIGN_OUT">
                                ${signOutTxt}
                        </a>
                    </li>
                </c:if>
                <li class="language-switcher">
                    <nav class="dropdown">
                        <a class="dropdown-toggle select" data-hover="dropdown" data-toggle="dropdown">
                            <c:choose>
                                <c:when test="${locale eq 'ru'}">
                                    <i class="famfamfam-flag-ru "></i>${russianTxt}
                                </c:when>
                                <c:when test="${locale eq 'en'}">
                                    <i class="famfamfam-flag-gb "></i>${englishTxt}
                                </c:when>
                            </c:choose>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <c:choose>
                                    <c:when test="${locale eq 'en'}">
                                        <a href="${pageContext.request.contextPath}/mainController?command=CHANGE_LOCALE&locale=ru">
                                            <i class="famfamfam-flag-ru"></i>
                                                ${russianTxt}
                                        </a>
                                    </c:when>
                                    <c:when test="${locale eq 'ru'}">
                                        <a href="${pageContext.request.contextPath}/mainController?command=CHANGE_LOCALE&locale=en">
                                            <i class="famfamfam-flag-gb"></i>
                                                ${englishTxt}
                                        </a>
                                    </c:when>
                                </c:choose>
                            </li>
                        </ul>
                    </nav>
                </li>
            </ul>
        </div>
    </div>

    <!-- ========== HEADER ========== -->
    <header class="fixed">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle mobile_menu_btn" data-toggle="collapse"
                        data-target=".mobile_menu" aria-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/mainController">
                    <img src="${pageContext.request.contextPath}/images/logo.png" height="32" alt="Logo">
                </a>
            </div>
            <nav id="main_menu" class="mobile_menu navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="mobile_menu_title" style="display:none;"></li>

                    <c:if test="${empty sessionScope.user}">
                        <li>
                            <a href="${pageContext.request.contextPath}/mainController?command=SHOW_SIGN_IN_PAGE">
                                    ${signInTxt}
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/mainController?command=SHOW_SIGN_UP_PAGE">
                                    ${signUpTxt}
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.user}">
                        <li class="dropdown simple_menu">
                            <a class="dropdown-toggle" data-toggle="dropdown"> ${myProfileTxt}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/mainController?command=SHOW_MY_PROFILE_PAGE">
                                            ${myProfileTxt}
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/mainController?command=SHOW_CHANGE_PASSWORD_PAGE">
                                            ${changePasswordTxt}
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/mainController?command=SHOW_EDIT_PROFILE_PAGE">
                                            ${editUserProfileTxt}
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.user}">
                        <c:if test="${empty sessionScope.enrollee}">
                            <li>
                                <a href="${pageContext.request.contextPath}/mainController?command=SHOW_ENROLLEE_FILL_PAGE">
                                        ${submitDocumentsTxt}
                                </a>
                            </li>
                        </c:if>
                    </c:if>
                    <ctg:admin role="${sessionScope.role}">
                        <li class="dropdown simple_menu">
                            <a class="dropdown-toggle" data-toggle="dropdown"> ${addTxt}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/mainController?command=SHOW_ADD_CITY_PAGE">
                                            ${addCityTxt}
                                    </a>
                                </li>

                                <li>
                                    <a href="${pageContext.request.contextPath}/mainController?command=SHOW_ADD_COUNTRY_PAGE">
                                            ${addCountryTxt}
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/mainController?command=SHOW_ADD_FACULTY_PAGE">
                                            ${addFacultyTxt}
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/mainController?command=SHOW_ALL_USERS">
                                    ${usersTxt}
                            </a>
                        </li>
                    </ctg:admin>
                </ul>
            </nav>
        </div>
    </header>
