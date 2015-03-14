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

    .controller('StudentsCtrl', function($scope, $http,$mdDialog) {
    	$http.get('http://localhost:8080/rest/faculty/all').success(function(data,status,headers,config){
    		$scope.faculties = data;
    	});
    	$http.get('http://localhost:8080/rest/speciality/all').success(function(data,status,headers,config){
    		$scope.specialities = data;
    	});
    	$http.get('http://localhost:8080/rest/student/all').success(function(data,status,headers,config){
    		$scope.students = data;
    	});
    	$http.get('http://localhost:8080/rest/country/all').success(function(data,status,headers,config){
    		$scope.countries = data;
    	});

        $scope.showAdvanced = function(ev) {
    $mdDialog.show({
      controller: DialogController,
      templateUrl: 'views/students/editDialog.html',
      targetEvent: ev,
    })
    .then(function(answer) {
      $scope.alert = 'Вы сказали"' + answer + '".';
    }, function() {
      $scope.alert = 'Вы закрыли диолог.';
    });
  };


    });    

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