/**
 * Created by vkotov on 21.01.2015.
 */
'use strict';

/**
 * Создание нового Angular приложения с заданными настройками.
 * Позволяет разместить на одной странице несколько приложений.
 *
 * @param elementId ID DOM-элемента, к которому прикрепляется приложение
 * @param appName Имя приложения (главного модуля)
 * @param modules Список модулей, подключаемых к приложению
 * @constructor
 */
//var AppFactory = function(testApp, myApp, modules)
//{
//    if (!modules)
//        modules = [];
//    var el = document.getElementById(testApp);
//    angular.module(myApp, modules).config([
//
//    /**
//     * Т.к. используется Smarty, то символы {{ и }} нужно заменить,
//     * например, на <[ и ]>
//     */
//        "$interpolateProvider", function($interpolateProvider){
//            $interpolateProvider.startSymbol('<[');
//            $interpolateProvider.endSymbol(']>');
//        }
//    ]);
//    modules.push(myApp);
//    angular.bootstrap(el, modules);
//};

angular.module('myApp.students', ['ngRoute','ngMaterial','ngResource','infinite-scroll','solo.table'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/students', {
            templateUrl: 'views/students/students.html',
            controller: 'StudentsCtrl'
        });
    }])

    .controller('StudentsCtrl', StudentsCtrl)
    .factory("Country", CountryFact)
    .factory("Group", GroupFact)
    .factory("Student", StudentFact)
    .factory("Speciality", SpecialityFact)
    .factory("Faculty", FacultyFact);


function StudentsCtrl ($scope, $mdDialog, Student, Speciality, Faculty, Country, Group) {

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

    Student.query(function(data) {
        $scope.original = data;
    });


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

function CountryFact($resource) {
    return $resource("http://localhost:8080/rest/country/:id");
}

function FacultyFact($resource) {
    return $resource("http://localhost:8080/rest/faculty/:id");
}

function SpecialityFact($resource){
    return $resource("http://localhost:8080/rest/speciality/:id");
}

function StudentFact($resource){
    return $resource("http://localhost:8080/rest/student/:id");
}
function GroupFact($resource){
    return $resource("http://localhost:8080/rest/group/:id");
}
