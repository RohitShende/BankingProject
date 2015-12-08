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
			if (response.data.id != null) {
				$rootScope.role = "Admin";
				$rootScope.id = response.data.id;
				$rootScope.$apply();
				console.log("-->"+$rootScope.role);
				$location.path("/AdminHome");
			} else {
				$scope.errormsg = "Invalid Creditnals";
				$location.path("/AdminLogin");
			}
		}, function errorCallback(response) {
			console.log("error : " + response.data.error);

		});
	}

});
app.controller("AdminHome", function($scope, $rootScope) {

	$scope.id = $rootScope.id;

});
