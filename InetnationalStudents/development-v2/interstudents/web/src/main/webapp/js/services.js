/**
 * Created by vkotov on 14.08.2015.
 */
var services = angular.module('myApp.services', ['ngResource']);

services.factory('UserService', function($resource) {

    return $resource('rest/user/:action', {},
        {
            authenticate: {
                method: 'POST',
                params: {'action' : 'authenticate'},
                headers : {'Content-Type': 'application/x-www-form-urlencoded'}
            }
        }
    );
});

services.factory('HostelService', function($resource) {
    return $resource('rest/hostel/:id', {id: '@id'});
});

services.factory('StudentService', function($resource) {
    return $resource('rest/student/:id', {id: '@id'});
});

services.factory('PersonalInfoService', function($resource) {
    return $resource('rest/personal-info/:id', {id: '@id'});
});

services.factory('EducationInfoService', function($resource) {
    return $resource('rest/education-info/:id', {id: '@id'});
});

services.factory('FacultyService', function($resource) {
    return $resource('rest/faculty/:id', {id: '@id'});
});

services.factory('SpecialityService', function($resource) {
    return $resource('rest/speciality/:id', {id: '@id'});
});

services.factory('CountryService', function($resource) {
    return $resource('rest/country/:id', {id: '@id'});
});

services.factory('GroupService', function($resource) {
    return $resource('rest/group/:id', {id: '@id'});
});

services.factory('CourseService', function($resource) {
    return $resource('rest/course/:id', {id: '@id'});
});

services.factory('EducationInfoService', function($resource) {
    return $resource('rest/education-info/:id', {id: '@id'});
});

services.factory('PersonalInfoService', function($resource) {
    return $resource('rest/personal-info/:id', {id: '@id'});
});

services.factory('StatisticSpecialityService', function($resource) {
    return $resource('rest/student/statisticBySpeciality/:id', {id: '@id'});
});

services.factory('StatisticCountryService', function($resource) {
    return $resource('rest/student/statisticByCountry/:id', {id: '@id'});
});

services.factory('StatisticHostelService', function($resource) {
    return $resource('rest/student/statisticByHostel/:id', {id: '@id'});
});

services.factory('EditStudentService', function(){
    return{
        editStudent: ''
    }
});

services.factory('EditGroupService', function(){
    return{
        editGroup: ''
    }
});

services.factory('EditSpecialityService', function(){
    return{
        editSpeciality: ''
    }
});

services.factory('EditFacultyService', function(){
    return{
        editFaculty: ''
    }
});
