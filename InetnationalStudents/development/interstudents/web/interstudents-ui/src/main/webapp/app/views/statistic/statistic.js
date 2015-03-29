angular.module('myApp.statistic', ['ngRoute','ngMaterial','ngResource','infinite-scroll','solo.table'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/statistic', {
            templateUrl: 'views/statistic/statistic.html',
            controller: 'StatisticCtrl'
        });
    }])

    .controller('StatisticCtrl', StatisticCtrl)
    .factory('Statistic',StatisticFact);


function StatisticCtrl ($scope, Student, Speciality, Faculty, Country, Group, Statistic) {

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

    Statistic.query(function(data){
        $scope.statistic = data;
    });
}
function StatisticFact($resource){
    return $resource('http://localhost:8080/rest/student/statisticbySpec');
}