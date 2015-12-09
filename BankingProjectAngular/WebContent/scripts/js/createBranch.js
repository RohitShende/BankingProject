/***	Common Elements - Header / Footer	***/
/** * Directives ** */

var app = angular.module('createBranch', []);
app.controller("createBranchController", function($scope, $log, $stateParams,
		$location, $state, $rootScope, $http) {
	$scope.createBranch = function() {
		$http({
			method : 'post',
			url : 'http://localhost:8080/createBranch',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : {
				ifscCode : $scope.ifscCode,
				branchName : $scope.branchName,
				contact : $scope.contact,
				address : $scope.address
			}
		}).then(function successCallback(response) {
			var data = response.data;
			console.log("Created New Branch"+ response.data);
			$location.path("/AdminHome");
		}, function errorCallback(response) {
			console.log("error : " + response.data.error);
			$scope.errormsg = "Invalid Data Entered";
			$location.path("/AdminLogin");
		});
	}

});

