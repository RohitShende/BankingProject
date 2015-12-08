/***	Common Elements - Header / Footer	***/
/** * Directives ** */

var app = angular.module('loginAdmin', []);
app.controller("AdminController", function($scope, $log, $stateParams,
		$location, $state, $rootScope, $http) {
	$scope.login = function() {
		$http({
			method : 'post',
			url : 'http://localhost:8080/loginAdmin',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : {
				username : $scope.username,
				password : $scope.pass
			}
		}).then(function successCallback(response) {
			var data = response.data;
			$rootScope.role = "Admin";
			$rootScope.id = response.data.id;
			console.log("AdminHome");
			$location.path("/AdminHome");
		}, function errorCallback(response) {
			console.log("error : " + response.data.error);
			$scope.errormsg = "Invalid Creditnals";
			$location.path("/AdminLogin");
		});
	}

});
app.controller("AdminHome", function($scope, $rootScope) {

	$scope.id = $rootScope.id;

});
