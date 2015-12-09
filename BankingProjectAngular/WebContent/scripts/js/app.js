/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';
	angular.module(
			'myapp',
			[ 'ui.router', 'ngAnimate', 'common-elements', 'loginAdmin',
					'basicModule','createBranchManager','loginBranchManager', 'createBranch' ])

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
		}).state('BranchManagerLogin', {
			url : '/BranchManagerLogin',
			templateUrl : 'Views/BranchManagerLogin.html',
			controller : 'BranchManagerController'
		}).state('AdminHome', {
			url : '/AdminHome',
			templateUrl : 'Views/AdminHome.html',
			controller : 'AdminHome'
		}).state('BranchManagerHome', {
			url : '/BranchManagerHome',
			templateUrl : 'Views/BranchManagerHome.html',
			controller : 'BranchManagerHome'
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
		}).state('CreateNewBranch',{
			url : '/CreateNewBranch',
			templateURL : 'Views/CreateNewBranch.html',
			controller : 'createBranchController'
		});
	}).controller("appcontroller", function($scope, $rootScope) {
		$rootScope.role = "Common";
		
		//$rootScope.baseURI = "http://localhost:8080/";
		$rootScope.$watch($rootScope.role, function() {
			$scope.role = $rootScope.role;
		});
	});
})();