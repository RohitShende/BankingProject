/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';
	angular.module(
			'myapp',
			[ 'ui.router', 'ngAnimate', 'common-elements', 'loginAdmin',
					'basicModule' ])

	// UI Routing
	.config(function($urlRouterProvider, $stateProvider) {

		$urlRouterProvider.otherwise('/home');

		$stateProvider.state('home', {
			url : '/home',
			templateUrl : 'Home.html',
		}).state('AdminLogin', {
			url : '/AdminLogin',
			templateUrl : 'Views/AdminLogin.html',
			controller : 'AdminController'
		}).state('AdminHome', {
			url : '/AdminHome',
			templateUrl : 'Views/AdminHome.html',
			controller : 'AdminHome'
		}).state('NewBranchManager', {
			url : '/NewBranchManager',
			templateUrl : 'Views/NewBranchManager.html',
			controller : 'createBranchManagerController'
		}).state('error', {
			url : '/error',
			templateUrl : 'Views/AdminHome.html',
			controller : 'AdminHome'
		}).state('logout', {
			url : '/logout',
			templateUrl : 'Home.html',
			controller : 'logout'
		});
	}).controller("appcontroller", function($scope, $rootScope) {
		$rootScope.role = "Common";
		$rootScope.baseURI = "http://localhost:8080/";
		$rootScope.$watch($rootScope.role, function() {
			$scope.role = $rootScope.role;
		});
	});
})();