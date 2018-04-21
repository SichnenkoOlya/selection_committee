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

<body>
<c:set var="lastPage" value="/pages/enrollee_fill.jsp" scope="session"/>

<h1>
    <label>
        <c:out value="${fillProfileTxt}"/>
    </label>
</h1>
<c:if test="${requestScope.containsKey('wrongData')}">
    <%--${wrongPassOrLoginTxt}--%>
</c:if>
<br/>
<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="FILL_ENROLLEE"/>
    <label for="surnameInput">
        ${surnameTxt}
    </label>
    <br/>
    <input id="surnameInput" type="text" name="surname" value=""/>
    <br/>
    <label for="nameInput">
        ${nameTxt}
    </label>
    <br/>
    <input id="nameInput" type="text" name="name" value=""/>
    <br/>
    <label for="patronymicInput">
        ${patronymicTxt}
    </label>
    <br/>
    <input id="patronymicInput" type="text" name="patronymic" value=""/>
    <br/>
    <br/>
    <label for="phoneInput">
        ${phoneNumberTxt}
    </label>
    <br/>
    <input id="phoneInput" type="text" name="phoneNumber" value=""/>
    <br/>
    <br/>
    <label for="passportInput">
        ${passportTxt}
    </label>
    <br/>
    <input id="passportInput" type="text" name="passport" value=""/>
    <br/>
    <br/>
    <label for="faculties">
        ${facultyTxt}
    </label>
    <select id="faculties" name="faculty">
        <c:forEach var="faculty" items="${faculties}">
            <option value="${faculty.facultyId}">${faculty.name}</option>
        </c:forEach>
    </select>
    <br/>
    <br/>
    <label for="countries">
        ${countryTxt}
    </label>

    <select id="countries" name="country" required>
        <option></option>
        <c:forEach var="country" items="${countries}">
            <option value="${country.countryId}">${country.name}</option>
        </c:forEach>
    </select>
    <br/>
    <script>

        $('#countries').change(function() {
            $(this).val();

            var data = {command: "FIND_CITIES_BY_COUNTRY_ID", countryId: $(this).val()};
            if(data !== '') {
                $.ajax({
                    type: "POST",
                    url: "/mainController",
                    data: data,
                    dataType: "json",
                    success: function (data, textStatus, jqXHR) {
                        $('#cities').html(createHtml(data));
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log("Something really bad happened " + textStatus);

                    },
                    beforeSend: function (jqXHR) {
                        $('#cities').html('');
                    }
                });
            }
        });

        function createHtml(data) {
            var html = "";
            data.forEach(function (value) {
                html += "<option value='" + value["cityId"] + "'>" + value["name"] + "</option>"
            });
            return html;
        }
    </script>
    <br/>
    <select id="cities" name="city">
        <%--<c:forEach var="city" items="${cities}">--%>
            <%--<option value="${city.cityId}">${city.name}</option>--%>
        <%--</c:forEach>--%>
    </select>
    <br/>
    <br/>
    <c:forEach var="subject" items="${subjects}">
        <label for="subjects">
            <input id="subjects" type="checkbox" name="idSubject" value="${subject.subjectId}">${subject.name}<BR>
        </label>
    </c:forEach>
    <br/>
    <br/>
    <label for="sertificateInput">
        ${sertificateScoreTxt}
    </label>
    <br/>
    <input id="sertificateInput" type="number" name="sertificateScore" value=""/>
    <br/>
    <br/>
    <br/>
    <label for="ctScoreInput">
        ${ctScoreTxt}
    </label>
    <br/>
    <input id="ctScoreInput" type="number" name="ctScore" value=""/>
    <br/>
    <br/>
    <c:forEach var="privilege" items="${privileges}">
        <label for="privileges">
            <input id="privileges" type="checkbox" name="idPrivilege" value="${privilege.privilegeId}">${privilege.name}<BR>
        </label>
    </c:forEach>

    <br/>

    <input type="submit" name="commit" value="${fillTxt}">
    <br/>


</form>
</body>
<%@include file="/pages/partial/footer.jsp" %>
