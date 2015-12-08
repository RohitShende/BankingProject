/**
 * ngSurveys - main application script file
 */

(function() {
	'use strict';
	angular.module(
			'myapp',
			[ 'ui.router', 'ngAnimate', 'common-elements',
					'loginAdmin' ])

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
		})
		.state('error', {
			url : '/error',
			templateUrl : 'Views/AdminHome.html',
			controller : 'AdminHome'
		});
	});
})();