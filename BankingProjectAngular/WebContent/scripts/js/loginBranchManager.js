/***	Common Elements - Header / Footer	***/
/** * Directives ** */

var app = angular.module('loginBranchManager', []);

app.controller("BranchManagerController", function($scope, $log, $stateParams,
		$location, $state, $rootScope, $http) {
	$scope.loginBranchManager = function() {
		$http({
			method : 'post',
			url : 'http://localhost:8080/loginBranchManager',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : {
				username : $scope.username,
				password : $scope.password
			}
		}).then(function successCallback(response) {
			var data = response.data;
			if (response.data.id != null) {
				$rootScope.role = "BranchManager";
				$rootScope.id = response.data.id;
				$rootScope.$apply();
				$location.path("/BranchManagerHome");
			} else {
				$scope.errormsg = "Invalid Creditnals";
				$location.path("/BranchManagerLogin");
			}
		}, function errorCallback(response) {
			console.log("error : " + response.data.error);

		});
	}

});
app.controller("BranchManagerHome", function($scope, $rootScope) {
	$scope.id = $rootScope.id;
});
