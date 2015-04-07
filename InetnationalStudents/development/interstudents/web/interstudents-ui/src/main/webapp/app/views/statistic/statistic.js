angular.module('myApp.statistic', ['ngRoute','ngMaterial','ngResource','infinite-scroll','solo.table'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/statistic', {
            templateUrl: 'views/statistic/statistic.html',
            controller: 'StatisticCtrl'
        });
    }])

    .controller('StatisticCtrl', StatisticCtrl)
    .factory('StatisticBySpeciality',StatisticSpecialityFact)
    .factory('StatisticByCountry',StatisticCountryFact);


function StatisticCtrl ($scope, Speciality, Faculty, Country, Group, StatisticBySpeciality, StatisticByCountry) {

/*    Group.query(function(data) {
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
    });*/

    StatisticBySpeciality.query(function(data){
        $scope.statisticBySpeciality = data;
    });

    StatisticByCountry.query(function(data){
        $scope.statisticByCountry = data;
    });
}
function StatisticSpecialityFact($resource){
    return $resource('http://localhost:8080/rest/student/statisticBySpeciality');
}

function StatisticCountryFact($resource){
    return $resource('http://localhost:8080/rest/student/statisticByCountry');
}