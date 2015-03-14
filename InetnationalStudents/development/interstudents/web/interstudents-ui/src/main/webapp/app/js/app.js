/**
 * Created by vkotov on 19.01.2015.
 */
'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'myApp.controllers',
    'myApp.view1',
    'myApp.login',
    'myApp.home',
    'myApp.students',
    'myApp.version',
/*    'myApp.filters',*/
/*    'myApp.services',*/
/*    'myApp.directives',*/
    'ngMaterial'
]).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);