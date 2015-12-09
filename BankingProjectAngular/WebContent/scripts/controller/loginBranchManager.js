/***	Common Elements - Header / Footer	***/
/** * Directives ** */

var app = angular.module('loginBranchManager', []);

app.controller("branchManagerController", function($scope, $log, $stateParams,
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
				console.log("success : " );
				$rootScope.role = "BranchManager";
				console.log("root : "+$rootScope.role );
				$rootScope.id = response.data.id;
				$rootScope.$apply();
				$location.path("/branchManagerHome");
			} else {
				$scope.errormsg = "Invalid Creditnals";
				$location.path("/branchManagerLogin");
			}
		}, function errorCallback(response) {
			console.log("error : " );
			console.log("error : " + response.data.error);

		});
	}

});
app.controller("branchManagerHome", function($scope, $rootScope) {
	$scope.id = $rootScope.id;
	
});
