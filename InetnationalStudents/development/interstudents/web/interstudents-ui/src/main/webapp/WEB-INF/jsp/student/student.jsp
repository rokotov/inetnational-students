<%--
  Created by IntelliJ IDEA.
  User: vkotov
  Date: 06.03.2015
  Time: 5:45
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
  <div <%--ng-controller="StudentsCtrl" --%>class="app-context md-whiteframe-z4">
    <md-tabs role="tablist" style="overflow: hidden;" md-theme="indigo">
      <md-tab class="md-transition-left">
        <md-tab-label>
          <h3>  По специальностям</h3>
        </md-tab-label>
        <div role="tabpanel" class="tabpanel-container" md-scroll-y flex>
          <p>
            Факультет
            <select ng-model="queryFaculty">
              <option ng-repeat="faculty in faculties" >{{faculty.facultyName}}</option>
            </select>
            Специальность
            <select ng-model="querySpeciality">
              <option ng-repeat="speciality in specialities |filter:queryFaculty">{{speciality.specialityName}}</option>
            </select>
          </p>

          <table border="1"style="overflow: auto;">
            <tr>
              <th>ФИО</th>
              <th>Курс</th>
              <th>Факультет</th>
              <th>Специальность</th>
              <th>Форма обучения</th>
              <th>Номер приказа</th>
              <th>Страна</th>
              <th>Паспортные данные</th>
              <th>Адресс регистрации</th>
              <th></th>
            </tr>
            <%--<tr ng-repeat="student in students|filter:querySpeciality">--%>
              <c:forEach items="${students}" var="student">
                <tr>
                  <td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
                  <td><c:out value="${student.course}"/></td>
                  <td><c:out value="${student.group.speciality.faculty.facultyName}"/></td>
                  <td><c:out value="${student.group.speciality.specialityName}"/></td>
                  <td><c:out value="${student.educationInfo.studyForm}"/></td>
                  <td><c:out value="${student.educationInfo.orderNumber}"/></td>
                  <td><c:out value="${student.country.countryName}"/></td>
                  <td><c:out value="${student.personalInfo.pasportNumber}"/></td>
                </tr>
            </c:forEach>
          <%--  <td>{{student.lastName}} {{student.firstName}} {{student.middleName}}</td>
              <td>{{student.course.courseName}}</td>
              <td>{{student.group.speciality.faculty.facultyName}}</td>
              <td>{{student.group.speciality.specialityName}}</td>
              <td>{{student.studyForm}}</td>
              <td>{{student.orderNumber}}</td>
              <td>{{student.country.countryName}}</td>
              <td>{{student.passportNumber}}</td>
              <td>{{student.registrationAddress}}</td>
              <td><md-icon icon="img/icons/ic_border_color_24px.svg"></md-icon></td>--%>
            <%--</tr>--%>
          </table>
        </div>
      </md-tab>
      <md-tab class="md-transition-right">
        <md-tab-label>
          <h3>По странам</h3>
        </md-tab-label>
        <div role="tabpanel" class="tabpanel-container">
          <p>
            Страна
            <select ng-model="queryCountry">
              <option ng-repeat="country in countries">{{country.countryName}}</option>
            </select>
          </p>
          <table border="1">
            <tr>
              <th>ФИО</th>
              <th>Курс</th>
              <th>Специальность</th>
              <th>Номер приказа</th>
              <th>Страна</th>
              <th>Паспортные данные</th>
              <th>Адресс регистрации</th>
              <th>Место рождения</th>
            </tr>
            <tr ng-repeat="student in students|filter:queryCountry">
              <td>{{student.lastName}} {{student.firstName}} {{student.middleName}}</td>
              <td>{{student.course.courseName}}</td>
              <td>{{student.group.speciality.specialityName}}</td>
              <td>{{student.orderNumber}}</td>
              <td>{{student.country.countryName}}</td>
              <td>{{student.passportNumber}}</td>
              <td>{{student.registrationAddress}}</td>
              <td>{{student.birthPlace}}</td>
            </tr>
          </table>
        </div>
      </md-tab>
      <md-tab class="md-transition-right">
        <md-tab-label>
          <h3>По группам</h3>
        </md-tab-label>
        <div role="tabpanel" class="tabpanel-container">
          <p>
            Группа
            <select ng-model="queryCountry">
              <option ng-repeat="country in countries">{{country.countryName}}</option>
            </select>
          </p>
          <table border="1">
            <tr>
              <th>ФИО</th>
              <th>Курс</th>
              <th>Специальность</th>
              <th>Номер приказа</th>
              <th>Страна</th>
              <th>Паспортные данные</th>
              <th>Адресс регистрации</th>
              <th>Место рождения</th>
            </tr>
            <tr ng-repeat="student in students|filter:queryCountry">
              <td>{{student.lastName}} {{student.firstName}} {{student.middleName}}</td>
              <td>{{student.course.courseName}}</td>
              <td>{{student.group.speciality.specialityName}}</td>
              <td>{{student.orderNumber}}</td>
              <td>{{student.country.countryName}}</td>
              <td>{{student.passportNumber}}</td>
              <td>{{student.registrationAddress}}</td>
              <td>{{student.birthPlace}}</td>
            </tr>
          </table>
        </div>
      </md-tab>
    </md-tabs>
    </md-tabs></md-tabs>
  </div>

</t:layout>

