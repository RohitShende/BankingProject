/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';
	angular.module(
			'myapp',
			[ 'ui.router', 'ngAnimate', 'common-elements', 'admin',
					'basicModule','createBranchManager','loginBranchManager', 'createBranch' ])

	// UI Routing
	.config(function($urlRouterProvider, $stateProvider) {

		$urlRouterProvider.otherwise('/home');

		$stateProvider.state('home', {
			url : '/home',
			templateUrl : 'home.html',
		}).state('adminLogin', {
			url : '/adminLogin',
			templateUrl : 'htmlpages/adminLogin.html',
			controller : 'adminLoginController'
		}).state('branchManagerLogin', {
			url : '/branchManagerLogin',
			templateUrl : 'htmlpages/branchManagerLogin.html',
			controller : 'branchManagerController'
		}).state('adminHome', {
			url : '/adminHome',
			templateUrl : 'htmlpages/adminHome.html',
			controller : 'adminHome'
		}).state('branchManagerHome', {
			url : '/branchManagerHome',
			templateUrl : 'htmlpages/branchManagerHome.html',
			controller : 'branchManagerHome'
		}).state('createNewBranch', {
			url : '/createNewBranch',
			templateUrl : 'htmlpages/createNewBranch.html',
			controller : 'createBranchController'
		}).state('error', {
			url : '/error',
			templateUrl : 'htmlpages/adminHome.html',
			controller : 'adminHome'
		}).state('logout', {
			url : '/logout',
			templateUrl : 'home.html',
			controller : 'logout'
		});
	}).controller("appcontroller", function($scope, $rootScope) {
		$rootScope.role = "Common";
		
		//$rootScope.baseURI = "http://localhost:8080/";
		$rootScope.$watch($rootScope.role, function() {
			$scope.role = $rootScope.role;
		});
	});
})();