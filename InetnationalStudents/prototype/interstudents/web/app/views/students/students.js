/**
 * Created by vkotov on 21.01.2015.
 */
'use strict';

angular.module('myApp.login', ['ngRoute','ngMaterial'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/students', {
            templateUrl: 'views/students/students.html',
            controller: 'StudentsCtrl'
        });
    }])

    .controller('StudentsCtrl', function($scope) {

    });    