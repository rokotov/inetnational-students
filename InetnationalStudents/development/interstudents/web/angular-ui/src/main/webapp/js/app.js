angular.module('myApp', ['ngRoute', 'ngCookies', 'ngMaterial', 'myApp.services', 'solo.table'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider, $mdThemingProvider) {

			/*$mdThemingProvider.theme('indigo')
				.dark();*/

			$routeProvider.when('/create', {
				templateUrl: 'partials/create.html',
				controller: CreateController
			});

			$routeProvider.when('/edit/:id', {
				templateUrl: 'partials/edit.html',
				controller: EditController
			});

			$routeProvider.when('/statistic', {
				templateUrl: 'partials/statistic.html',
				controller: StatisticController
			});
			$routeProvider.when('/administration', {
				templateUrl: 'partials/administration.html',
				controller: AdministrationController
			});

			$routeProvider.when('/student', {
				templateUrl: 'partials/student.html',
				controller: StudentController
			});

			$routeProvider.when('/login', {
				templateUrl: 'partials/login.html',
				controller: LoginController
			});

			$routeProvider.when('/home', {
				templateUrl: 'partials/home.html',
				controller: HomeController
			});

			$routeProvider.otherwise({
				templateUrl: 'partials/index.html',
				controller: IndexController
			});




			$locationProvider.hashPrefix('!');

			/* Register error provider that shows message on failed requests or redirects to login page on
			 * unauthenticated requests */
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'responseError': function(rejection) {
			        		var status = rejection.status;
			        		var config = rejection.config;
			        		var method = config.method;
			        		var url = config.url;

			        		if (status == 401) {
			        			$location.path( "/login" );
			        		} else {
			        			$rootScope.error = method + " on " + url + " failed with status " + status;
			        		}
			        		return $q.reject(rejection);
			        	}
			        };
			    }
		    );

		    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
		     * as soon as there is an authenticated user */
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
		        return {
		        	'request': function(config) {
		        		var isRestCall = config.url.indexOf('rest') == 0;
		        		if (isRestCall && angular.isDefined($rootScope.authToken)) {
		        			var authToken = $rootScope.authToken;
		        			if (exampleAppConfig.useAuthTokenHeader) {
		        				config.headers['X-Auth-Token'] = authToken;
		        			} else {
		        				config.url = config.url + "?token=" + authToken;
		        			}
		        		}
		        		return config || $q.when(config);
		        	}
		        };
		    }
	    );

		} ]

	)
	.controller('MainCtrl', MainCtrl)
	.controller('LeftCtrl', LeftCtrl)
	.run(function($rootScope, $location, $cookieStore, UserService) {

		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});

		$rootScope.hasRole = function(role) {

			if ($rootScope.user === undefined) {
				return false;
			}

			if ($rootScope.user.roles[role] === undefined) {
				return false;
			}

			return $rootScope.user.roles[role];
		};

		$rootScope.logout = function() {
			delete $rootScope.user;
			delete $rootScope.authToken;
			$cookieStore.remove('authToken');
			$location.path("/login");
		};

		 /* Try getting valid user from cookie or go to login page */
		var originalPath = $location.path();
		$location.path("/login");
		var authToken = $cookieStore.get('authToken');
		if (authToken !== undefined) {
			$rootScope.authToken = authToken;
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path(originalPath);
			});
		}

		$rootScope.initialized = true;
	});


function IndexController($scope, HostelService) {

	$scope.hostels = HostelService.query();

	$scope.deleteEntry = function(newsEntry) {
		newsEntry.$remove(function() {
			$scope.hostels = HostelService.query();
		});
	};
}


function EditController($scope, $routeParams, $location, StudentService, CountryService,
						FacultyService, SpecialityService, CourseService, GroupService, HostelService) {


	$scope.student = StudentService.get({id: $routeParams.id});


	$scope.countries = CountryService.query();
	$scope.hostels = HostelService.query();
	$scope.faculties = FacultyService.query();
	$scope.specialities = SpecialityService.query();
	$scope.groups = GroupService.query();
	$scope.courses = CourseService.query();

	$scope.save = function() {
		$scope.student.$save(function() {
			$location.path('/administration');
		});
	};
}


function CreateController($scope, $location, StudentService, CountryService,
						  FacultyService, SpecialityService, CourseService, GroupService, HostelService) {

	$scope.student = new StudentService();

	$scope.countries = CountryService.query();
	$scope.hostels = HostelService.query();
	$scope.faculties = FacultyService.query();
	$scope.specialities = SpecialityService.query();
	$scope.groups = GroupService.query();
	$scope.courses = CourseService.query();

	$scope.save = function() {
		$scope.student.$save(function() {
			$location.path('/administration');
		});

	};
}
function AdministrationController($scope, $location, StudentService, FacultyService, SpecialityService, CourseService, GroupService) {
	$scope.student = new StudentService();

	$scope.save = function() {
		$scope.student.$save(function() {
			$location.path('/administration');
		});
	};

	$scope.original = StudentService.query();

	$scope.faculties = FacultyService.query();
	$scope.specialities = SpecialityService.query();
	$scope.groups = GroupService.query();
	$scope.courses = CourseService.query();//[{ name:'0'}, {name:'1'}, {name:'2'}, {name:'3'}, {name:'4'}, {name:'5'}, {name:'II'}, {name:'III'}, {name:'K'}, {name:'A'} ];

}

function LoginController($scope, $rootScope, $location, $cookieStore, UserService) {

	$scope.rememberMe = false;

	$scope.login = function() {
		UserService.authenticate($.param({username: $scope.username, password: $scope.password}), function(authenticationResult) {
			var authToken = authenticationResult.token;
			$rootScope.authToken = authToken;
			if ($scope.rememberMe) {
				$cookieStore.put('authToken', authToken);
			}
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path("/home");
			});
		});
	};
}

function StudentController ($scope, $mdDialog, StudentService, FacultyService, SpecialityService, CountryService/*, Group*/) {
	$scope.original = StudentService.query();

	$scope.faculties = FacultyService.query();
	$scope.specialities = SpecialityService.query();
	$scope.countries = CountryService.query();

	$scope.showAdvanced = function(ev) {
		/*$scope.student = StudentService.get({id:  $routeParams.id});*/
		$mdDialog.show({
			controller: DialogController,
			templateUrl: 'partials/editDialog.html',
			targetEvent: ev
		})
			.then(function(answer) {
				$scope.alert = 'Вы сказали"' + answer + '".';
			}, function() {
				$scope.alert = 'Вы закрыли диолог.';
			});
	};
}

function StatisticController ($scope, StatisticSpecialityService, StatisticCountryService) {

	$scope.statisticBySpeciality = StatisticSpecialityService.query();
	$scope.statisticByCountry = StatisticCountryService.query();
}

function DialogController($scope,$routeParams, $location, StudentService, $mdDialog) {
	$scope.student = StudentService.get({id: $routeParams.id});
	$scope.save = function() {
		$scope.student.$save(function() {
			$location.path('/');
		});
	};

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

function HomeController($scope){

}

function MainCtrl($scope, $mdSidenav) {
	$scope.toggleRight = function () {
		$mdSidenav('left').toggle();
	};

	$scope.menu = {};
	$scope.menu.pages = [
		{"url": "!/home", "discription": "Главная"},
		{"url": "!/student", "discription": "Список студентов"},
		{"url": "!/statistic", "discription": "Статистика"},
		{"url": "!/", "discription": "Общаги"}

	];

	$scope.menu.isPageSelected = function (page) {
		return ($scope.menu.currentPage === page);
	};

	$scope.menu.toggleSelectPage = function (page) {
		$scope.menu.currentPage = page;
	};
}

function LeftCtrl($scope, $mdSidenav) {
	$scope.close = function() {
		$mdSidenav('left').close();
	};
}

var services = angular.module('myApp.services', ['ngResource']);

services.factory('UserService', function($resource) {

	return $resource('rest/user/:action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/x-www-form-urlencoded'}
				}
			}
		);
});

services.factory('HostelService', function($resource) {
	return $resource('rest/hostel/:id', {id: '@id'});
});

services.factory('StudentService', function($resource) {
	return $resource('rest/student/:id', {id: '@id'});
});

services.factory('PersonalInfoService', function($resource) {
	return $resource('rest/personal-info/:id', {id: '@id'});
});

services.factory('EducationInfoService', function($resource) {
	return $resource('rest/education-info/:id', {id: '@id'});
});

services.factory('FacultyService', function($resource) {
	return $resource('rest/faculty/:id', {id: '@id'});
});

services.factory('SpecialityService', function($resource) {
	return $resource('rest/speciality/:id', {id: '@id'});
});

services.factory('CountryService', function($resource) {
	return $resource('rest/country/:id', {id: '@id'});
});

services.factory('GroupService', function($resource) {
	return $resource('rest/group/:id', {id: '@id'});
});

services.factory('CourseService', function($resource) {
	return $resource('rest/course/:id', {id: '@id'});
});

services.factory('EducationInfoService', function($resource) {
	return $resource('rest/education-info/:id', {id: '@id'});
});

services.factory('PersonalInfoService', function($resource) {
	return $resource('rest/personal-info/:id', {id: '@id'});
});

services.factory('StatisticSpecialityService', function($resource) {
	return $resource('rest/student/statisticBySpeciality/:id', {id: '@id'});
});

services.factory('StatisticCountryService', function($resource) {
	return $resource('rest/student/statisticByCountry/:id', {id: '@id'});
});
