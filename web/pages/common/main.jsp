<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 31.03.2018
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.faculties" var="facultiesTxt"/>
<fmt:message key="label.welcomeTo" var="welcomeToTxt"/>
<fmt:message key="label.newKnowledge" var="newKnowledgeTxt"/>
<fmt:message key="label.newFrieds" var="newFriedsTxt"/>
<fmt:message key="label.yourChoice" var="yourChoiceTxt"/>
<fmt:message key="label.followYourDream" var="followDreamTxt"/>
<fmt:message key="label.waiting" var="waitingTxt"/>
<fmt:message key="label.helloGuest" var="helloGuestTxt"/>
<fmt:message key="label.waySuccess" var="waySuccessTxt"/>
<fmt:message key="label.studentLife" var="studentLifeTxt"/>
<fmt:message key="label.budjet" var="budjetTxt"/>
<fmt:message key="label.paid" var="paidTxt"/>
<fmt:message key="label.show_current" var="currentTxt"/>
<fmt:message key="label.end_committee" var="endCommitteeTxt"/>
<fmt:message key="label.show_entered" var="enteredtTxt"/>


<div id="classic_slider" class="rev_slider" style="display:none">
    <ul>
        <!-- SLIDE NR. 1 -->
        <li data-transition="crossfade">
            <!-- MAIN IMAGE -->
            <img src="${pageContext.request.contextPath}/images/slider/slider-1.jpg"
                 alt="Image"
                 title="slider_bg2"
                 data-bgposition="center center"
                 data-bgfit="cover"
                 data-bgrepeat="no-repeat"
                 data-bgparallax="10"
                 class="rev-slidebg"
                 data-no-retina="">
            <!-- LAYER NR. 1 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="320"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="['60','50','40','30']"
                 data-lineheight="['60','50','40','30']"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1000,"speed":1500,"frame":"0","from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;s:inherit;e:inherit;","to":"o:1;","ease":"Power3.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 5; color: #fff; font-weight: 900;"> ${welcomeToTxt}
            </div>
            <!-- LAYER NR. 2 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="410"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="16"
                 data-lineheight="16"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1500,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 6; color: #fff;">${waitingTxt}
            </div>
            <!-- LAYER NR. 3 -->
            <div class="tp-caption tp-shape tp-shapewrapper  tp-resizeme"
                 data-x="center"
                 data-hoffset="-170"
                 data-y="414"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:500;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2000"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 4 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-170"
                 data-y="418"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:500;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2100"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);"></div>
            <!-- LAYER NR. 5 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="170"
                 data-y="414"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:500;"
                 data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2000"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 6 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="170"
                 data-y="418"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:500;"
                 data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2100"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 9 -->
            <div class="tp-caption tp_m_title tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="200"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="['18','18','16','16']"
                 data-lineheight="['18','18','16','16']"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1800,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'>
                <i class="fa fa-mortar-board"></i>
                <i class="fa fa-mortar-board"></i>
                <i class="fa fa-mortar-board"></i>
                <i class="fa fa-mortar-board"></i>
                <i class="fa fa-mortar-board"></i>
            </div>
            <!-- LAYER NR. 10 -->
            <div class="tp-caption tp_m_title tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="240"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="['25','25','18','18']"
                 data-lineheight="['25','25','18','18']"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1800,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'>
                ${helloGuestTxt}
            </div>
        </li>

        <!-- SLIDE NR. 2 -->
        <li data-transition="crossfade">
            <!-- MAIN IMAGE -->
            <img src="${pageContext.request.contextPath}/images/slider/slider-2.jpg"
                 alt="Image"
                 title="slider_bg2"
                 data-bgposition="center center"
                 data-bgfit="cover"
                 data-bgrepeat="no-repeat"
                 data-bgparallax="10"
                 class="rev-slidebg"
                 data-no-retina="">
            <!-- LAYER NR. 1 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="320"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="['60','50','40','25']"
                 data-lineheight="['60','50','40','25']"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1000,"speed":1500,"frame":"0","from":"y:[-100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;","mask":"x:0px;y:0px;s:inherit;e:inherit;","to":"o:1;","ease":"Power3.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 5; color: #fff; font-weight: 900;">${newKnowledgeTxt}
            </div>
            <!-- LAYER NR. 2 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="410"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="16"
                 data-lineheight="16"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1500,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 6; color: #fff;">${waySuccessTxt}
            </div>
            <!-- LAYER NR. 3 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-134"
                 data-y="414"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2000"
                 data-responsive_offset="on"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 4 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-134"
                 data-y="418"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2100"
                 data-responsive_offset="on"
                 style="z-index: 8;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 5 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="134"
                 data-y="414"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2000"
                 style="z-index: 9;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 6 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="134"
                 data-y="418"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1500;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2100"
                 data-responsive_offset="on"
                 style="z-index: 10;background: url(/images/icons/wave_white.svg);">
            </div>
        </li>

        <!-- SLIDE NR. 3 -->
        <li data-transition="crossfade">
            <!-- MAIN IMAGE -->
            <img src="${pageContext.request.contextPath}/images/slider/slider-3.jpg"
                 alt="Image"
                 title="slider_bg3"
                 data-bgposition="center center"
                 data-bgfit="cover"
                 data-bgrepeat="no-repeat"
                 data-bgparallax="10"
                 class="rev-slidebg"
                 data-no-retina="">
            <!-- LAYER NR. 1 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="305"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="['80','70','60','40']"
                 data-lineheight="['80','70','60','40']"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1000,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 5; color: #fff; font-weight: 900;">${newFriedsTxt}
            </div>
            <!-- LAYER NR. 2 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="410"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="16"
                 data-lineheight="16"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1500,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 6; color: #fff;">${studentLifeTxt}
            </div>
            <!-- LAYER NR. 3 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-180"
                 data-y="414"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2300"
                 data-responsive_offset="on"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 4 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-180"
                 data-y="418"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2400"
                 data-responsive_offset="on"
                 style="z-index: 8;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 5 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="180"
                 data-y="414"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;" data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2300"
                 data-responsive_offset="on"
                 style="z-index: 9;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 6 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="180"
                 data-y="418"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2400"
                 data-responsive_offset="on"
                 style="z-index: 10;background: url(/images/icons/wave_white.svg);">
            </div>
        </li>
        <!-- SLIDE NR. 4 -->
        <li data-transition="crossfade">
            <!-- MAIN IMAGE -->
            <img src="${pageContext.request.contextPath}/images/slider/slider-4.jpg"
                 alt="Image"
                 title="slider_bg3"
                 data-bgposition="center center"
                 data-bgfit="cover"
                 data-bgrepeat="no-repeat"
                 data-bgparallax="10"
                 class="rev-slidebg"
                 data-no-retina="">
            <!-- LAYER NR. 1 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="305"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="['80','70','60','40']"
                 data-lineheight="['80','70','60','40']"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1000,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 5; color: #fff; font-weight: 900;">${yourChoiceTxt}
            </div>
            <!-- LAYER NR. 2 -->
            <div class="tp-caption tp-resizeme"
                 data-x="center"
                 data-hoffset=""
                 data-y="410"
                 data-voffset=""
                 data-responsive_offset="on"
                 data-fontsize="16"
                 data-lineheight="16"
                 data-whitespace="nowrap"
                 data-frames='[{"delay":1500,"speed":1500,"frame":"0","from":"y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;","mask":"x:0px;y:[100%];s:inherit;e:inherit;","to":"o:1;","ease":"Power2.easeInOut"},{"delay":"wait","speed":500,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
                 style="z-index: 6; color: #fff;">${followDreamTxt}
            </div>
            <!-- LAYER NR. 3 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-180"
                 data-y="414"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2300"
                 data-responsive_offset="on"
                 style="z-index: 7;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 4 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="-180"
                 data-y="418"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[-100%];y:0;s:inherit;e:inherit;"
                 data-start="2400"
                 data-responsive_offset="on"
                 style="z-index: 8;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 5 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="180"
                 data-y="414"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;" data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2300"
                 data-responsive_offset="on"
                 style="z-index: 9;background: url(/images/icons/wave_white.svg);">
            </div>
            <!-- LAYER NR. 6 -->
            <div class="tp-caption tp-shape tp-shapewrapper tp-resizeme"
                 data-x="center"
                 data-hoffset="180"
                 data-y="418"
                 data-voffset=""
                 data-width="['100']"
                 data-height="['4']"
                 data-transform_idle="o:1;"
                 data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:1;s:1000;e:Power3.easeOut;"
                 data-transform_out="opacity:0;s:300;"
                 data-mask_in="x:[100%];y:0;s:inherit;e:inherit;"
                 data-start="2400"
                 data-responsive_offset="on"
                 style="z-index: 10;background: url(/images/icons/wave_white.svg);">
            </div>
        </li>

    </ul>
</div>

<!-- ========== BLOG ========== -->
<section id="blog">
    <div class="container">
        <div class="main_title mt_wave a_center">
            <h1>${facultiesTxt}</h1>
        </div>
        <div class="row">

            <c:forEach var="faculty" items="${faculties}">
                <div class="col-md-12 col-sm-12">
                    <article class="blog_item">
                        <div class="row">
                            <div class="col-lg-3 col-md-12">
                                <figure>
                                    <a class="hover_effect h_blue"
                                       href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_FACULTY&facultyId=${faculty.facultyId}">
                                        <img src="${pageContext.request.contextPath}/${faculty.imagePath}"
                                             class="img-responsive" alt="Image">
                                    </a>
                                </figure>
                            </div>
                            <div class="col-lg-9 col-md-12">
                                <div class="main">
                                    <h2>
                                        <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_FACULTY&facultyId=${faculty.facultyId}">
                                                ${faculty.name}
                                        </a>
                                    </h2>
                                    <p>${faculty.description}</p>
                                    <br/>
                                    <br/>
                                    <c:if test="${faculty.isFinish}">
                                        <h3>${enteredtTxt}</h3>
                                    </c:if>

                                    <c:if test="${not faculty.isFinish}">
                                        <h3>${currentTxt}</h3>
                                    </c:if>

                                    <br/>

                                    <a class="button btn_lg btn_yellow button-one-width main-link"
                                       href="${pageContext.request.contextPath}/mainController?command=SHOW_ENROLLEES_BUDJET&facultyId=${faculty.facultyId}">${budjetTxt}</a>

                                    <a class="button btn_lg btn_yellow button-one-width main-link"
                                       href="${pageContext.request.contextPath}/mainController?command=SHOW_ENROLLEES_PAID&facultyId=${faculty.facultyId}">${paidTxt}</a>

                                </div>
                            </div>
                        </div>
                    </article>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<%@include file="/pages/partial/footer.jsp" %>