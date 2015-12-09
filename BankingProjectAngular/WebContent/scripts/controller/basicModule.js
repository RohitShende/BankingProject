/***	Common Elements - Header / Footer	***/
/***	Directives		***/
(function() {
	var app = angular.module('basicModule', []);

	app.controller("logout", function($scope, $rootScope) {
		$rootScope.id = "";
		$rootScope.role = "Common";
	});
})();
