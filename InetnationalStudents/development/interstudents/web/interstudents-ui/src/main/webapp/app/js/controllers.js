'use strict';

/* Controllers */
/**
 * @constructor
 */
angular.module('myApp.controllers', [])

.controller('MainCtrl', function($scope, $timeout, $mdSidenav) {
    $scope.toggleRight = function() {
        $mdSidenav('left').toggle();
    };

    $scope.menu = {};
    $scope.menu.pages = [
        {"url": "/home", "discription":"Главная"},
        {"url": "/students", "discription":"Список студентов"}

    ];

    $scope.menu.isPageSelected = function(page) {
        return ($scope.menu.currentPage === page);
    };

    $scope.menu.toggleSelectPage = function(page) {
        $scope.menu.currentPage = page;
    };
})

    .controller('LeftCtrl', function($scope, $timeout, $mdSidenav) {
        $scope.close = function() {
            $mdSidenav('left').close();
        };
    });