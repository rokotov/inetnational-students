/**
 * Created by vkotov on 19.01.2015.
 */
'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',

   /* 'myApp.login',
    'myApp.home',
    'myApp.students',*/
    //'myApp.version',
    'ngMaterial'
]).
    config(['$routeProvider', function($routeProvider) {
}])

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