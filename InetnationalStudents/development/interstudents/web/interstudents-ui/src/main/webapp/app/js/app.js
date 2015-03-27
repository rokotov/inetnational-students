/**
 * Created by vkotov on 19.01.2015.
 */
'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'myApp.view1',
    'myApp.login',
    'myApp.home',
    'myApp.students',
    'myApp.statistic',
    'myApp.version',
/*    'myApp.filters',*/
/*    'myApp.services',*/
/*    'myApp.directives',*/
    'ngMaterial'
])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/login'});
    }])

    .controller('MainCtrl', MainCtrl)

    .controller('LeftCtrl', LeftCtrl);


function MainCtrl($scope, $mdSidenav) {
    $scope.toggleRight = function() {
        $mdSidenav('left').toggle();
    };

    $scope.menu = {};
    $scope.menu.pages = [
        {"url": "/home", "discription":"Главная"},
        {"url": "/students", "discription":"Список студентов"},
        {"url": "/statistic", "discription":"Статистика"}

    ];

    $scope.menu.isPageSelected = function(page) {
        return ($scope.menu.currentPage === page);
    };

    $scope.menu.toggleSelectPage = function(page) {
        $scope.menu.currentPage = page;
    };
};

function LeftCtrl($scope, $mdSidenav) {
    $scope.close = function() {
        $mdSidenav('left').close();
    };
};
