angular.module('myApp.statistic', ['ngRoute','ngMaterial','ngResource','infinite-scroll','solo.table'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/statistic', {
            templateUrl: 'views/statistic/statistic.html',
            controller: 'StatisticCtrl'
        });
    }])

    .controller('StatisticCtrl', StatisticCtrl)
    .factory("StatisticSpec", StatisticSpec);
    //.factory("Country", CountryFact)
    //.factory("Group", GroupFact)
    //.factory("Student", StudentFact)
    //.factory("Speciality", SpecialityFact)
    //.factory("Faculty", FacultyFact)


function StatisticCtrl ($scope, Student, Speciality, Faculty, Country, Group) {

    Group.query(function(data) {
        $scope.groups = data;
    });

    Country.query(function(data) {
        $scope.countries = data;
    });

    Faculty.query(function(data) {
        $scope.faculties = data;
    });

    Speciality.query(function(data) {
        $scope.specialities = data;
    });

    Student.query(function(data) {
        $scope.original = data;
    });

}

function StatisticSpec($resource){
    return $resource("http://localhost:8080/rest/country/:id");
}