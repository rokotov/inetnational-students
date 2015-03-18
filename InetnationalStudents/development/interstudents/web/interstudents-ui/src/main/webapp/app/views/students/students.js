/**
 * Created by vkotov on 21.01.2015.
 */
'use strict';

angular.module('myApp.students', ['ngRoute','ngMaterial','ngResource','infinite-scroll','solo.table'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/students', {
            templateUrl: 'views/students/students.html',
            controller: 'StudentsCtrl'
        });
    }])

    .controller('StudentsCtrl', StudentsCtrl)
    .factory("Student", StudentFtr);

function StudentsCtrl ($scope, $http,$mdDialog,Student) {
   /* $http.get('http://localhost:8080/rest/faculty/all').success(function (data, status, headers, config) {
        $scope.faculties = data;
    });
    $http.get('http://localhost:8080/rest/speciality/all').success(function (data, status, headers, config) {
        $scope.specialities = data;
    });

    $http.get('http://localhost:8080/rest/country/all').success(function (data, status, headers, config) {
        $scope.countries = data;
    });*/



    Student.query(function(data) {
        //$scope.students = data;
    });


    $scope.images = [1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,13,14,15,16,17,18];

    $scope.loadMore = function() {
        var last = $scope.images[$scope.images.length - 1];
        for(var i = 1; i <= 18; i++) {
            $scope.images.push(last + i);
        }
    };

    $scope.showAdvanced = function(ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: 'views/students/editDialog.html',
            targetEvent: ev
        })
            .then(function(answer) {
                $scope.alert = 'Вы сказали"' + answer + '".';
            }, function() {
                $scope.alert = 'Вы закрыли диолог.';
            });
    };
}

function DialogController($scope, $mdDialog) {
    $scope.hide = function() {
        $mdDialog.hide();
    };
    $scope.cancel = function() {
        $mdDialog.cancel();
    };
    $scope.answer = function(answer) {
        $mdDialog.hide(answer);
    };
}

function StudentFtr($resource){
    return $resource("http://localhost:8080/rest/student/:id");
}
