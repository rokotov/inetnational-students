/**
 * Created by vkotov on 21.01.2015.
 */
'use strict';

angular.module('myApp.students', ['ngRoute','ngMaterial'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/students', {
            templateUrl: 'views/students/students.html',
            controller: 'StudentsCtrl'
        });
    }])

    .controller('StudentsCtrl', function($scope, $http) {
    	$http.get('http://localhost:8080/is/faculty/all').success(function(data,status,headers,config){
    		console.log('This is Data:', data,'\n\n This is Status:',status,'\n\n This is Headers:',headers);
    		$scope.faculties = data;
    	});
    	$http.get('http://localhost:8080/is/speciality/all').success(function(data,status,headers,config){
    		console.log('This is Data:', data,'\n\n This is Status:',status,'\n\n This is Headers:',headers);
    		$scope.specialities = data;
    	});
    	$http.get('http://localhost:8080/is/student/all').success(function(data,status,headers,config){
    		console.log('This is Data:', data,'\n\n This is Status:',status,'\n\n This is Headers:',headers);
    		$scope.students = data;
    	});
    	$http.get('http://localhost:8080/is/country/all').success(function(data,status,headers,config){
    		console.log('This is Data:', data,'\n\n This is Status:',status,'\n\n This is Headers:',headers);
    		$scope.countries = data;
    	});
    });    