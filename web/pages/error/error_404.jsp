<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 31.03.2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>

<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">

    <!-- ========== SEO ========== -->
    <title>404</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <meta content="" name="author">

    <!-- ========== FAVICON ========== -->
    <link rel="apple-touch-icon-precomposed" href="images/favicon-apple.png"/>
    <link rel="icon" href="images/favicon.png">

    <!-- ========== STYLESHEETS ========== -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="revolution/css/layers.css" rel="stylesheet" type="text/css"/>
    <link href="revolution/css/settings.css" rel="stylesheet" type="text/css"/>
    <link href="revolution/css/navigation.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
    <link href="css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="css/famfamfam-flags.css" rel="stylesheet" type="text/css">
    <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
    <link href="css/owl.carousel.min.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/responsive.css" rel="stylesheet" type="text/css">

    <!-- ========== ICON FONTS ========== -->
    <link href="fonts/font-awesome.min.css" rel="stylesheet">
    <link href="fonts/flaticon.css" rel="stylesheet">

    <!-- ========== GOOGLE FONTS ========== -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900%7cRaleway:400,500,600,700"
          rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="full_screen">


<c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'en'}"/>
<fmt:setLocale value="${locale}"/>

<fmt:setBundle basename="text" scope="session"/>
<fmt:message key="label.go_back" var="goBackTxt"/>
<fmt:message key="label.page_not_found" var="pageNotFoundTxt"/>

<!-- ========== MAIN ========== -->
<main id="error404_fullscreen_page" class="gradient_overlay dotted_overlay">
    <div class="inner container">
        <h1 class="error_number"> 404 </h1>
        <div class="main_title mt_white a_center">
            <h2>${fn:toUpperCase(pageNotFoundTxt)}</h2>
        </div>
        <div class="a_center">
            <a href="${pageContext.request.contextPath}/mainController" class="button btn_sm btn_yellow"><i
                    class="fa fa-angle-left"></i>${fn:toUpperCase(goBackTxt)}</a>
        </div>
    </div>
</main>

<!-- ========== JAVASCRIPT ========== -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/jquery.smoothState.js"></script>
<script type="text/javascript" src="js/moment.min.js"></script>
<script type="text/javascript" src="js/morphext.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<script type="text/javascript" src="js/owl.carousel.thumbs.min.js"></script>
<script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="js/jPushMenu.js"></script>
<script type="text/javascript" src="js/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="js/countUp.min.js"></script>
<script type="text/javascript" src="js/jquery.countdown.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>

</body>
</html>