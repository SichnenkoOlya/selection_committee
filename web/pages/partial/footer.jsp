<!-- ========== FOOTER ========== -->

<fmt:message key="label.footer.description" var="descriptionTxt"/>
<fmt:message key="label.university" var="universityTxt"/>
<fmt:message key="label.copyRight" var="copyRightTxt"/>
<fmt:message key="label.allRightsReserved" var="allRightsReservedTxt"/>
<fmt:message key="label.today" var="todayTxt"/>

<footer class="dark">
    <div class="inner">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12 widget">
                    <div class="about">
                        <a href="${pageContext.request.contextPath}/mainController">
                            <img class="logo" src="${pageContext.request.contextPath}/images/logo_light.png" height="32"
                                 alt="Logo">
                        </a>
                        <p>${descriptionTxt}</p>
                        <p>${todayTxt} <ctg:cur-date/></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="subfooter">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="copyrights">
                        ${copyRightTxt} <a
                            href="${pageContext.request.contextPath}/mainController">${universityTxt}</a> ${allRightsReservedTxt}
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</div>

<!-- ========== BACK TO TOP ========== -->
<div id="back_to_top">
    <i class="fa fa-angle-up" aria-hidden="true"></i>
</div>

<!-- ========== NOTIFICATION ========== -->
<div id="notification"></div>

<!-- ========== JAVASCRIPT ========== -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.smoothState.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/morphext.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wow.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/owl.carousel.thumbs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jPushMenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/countUp.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/generateHtml.js"></script>

<!-- ========== REVOLUTION SLIDER ========== -->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.migration.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/jquery.matchHeight.min.js"></script>

</body>
</html>