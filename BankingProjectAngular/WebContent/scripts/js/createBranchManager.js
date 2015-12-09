/***	Common Elements - Header / Footer	***/
/** * Directives ** */

var app = angular.module('createBranchManager', []);
app.controller("createBranchManagerController", function($scope, $log, $stateParams,
		$location, $state, $rootScope, $http) {
	$scope.addmanager = function() {
		$http({
			method : 'post',
			url : 'http://localhost:8080/addBranchManager',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : {
				firstName : $scope.firstName,
				lastName : $scope.lastName,
				email : $scope.email,
				phone : $scope.phone,
				address : $scope.address,
				dateOfBirth : $scope.dateOfBirth,
				username : $scope.username,
				password : $scope.password
			}
		}).then(function successCallback(response) {
			var data = response.data;
			console.log("Create New Manager"+ response.data);
			$location.path("/AdminHome");
		}, function errorCallback(response) {
			console.log("error : " + response.data.error);
			$scope.errormsg = "Invalid Creditnals";
			$location.path("/AdminLogin");
		});
	}

});

