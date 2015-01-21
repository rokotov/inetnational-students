/**
 * Created by vkotov on 21.01.2015.
 */
angular.module('myApp.students', ['ngRoute','ngMaterial'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/login',{
            templateUrl:'views/login/login.html',
            controller:'LoginCtrl'
        });
    }])

    .controller('LoginCtrl', function($location, $scope) {
    	 $scope.credentials = {login:'', password:''};
         $scope.login = function(){
            if($scope.credentials.login === 'admin'){
                $location.path('home');
            };
         };
    });