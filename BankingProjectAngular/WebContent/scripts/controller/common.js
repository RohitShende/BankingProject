/***	Common Elements - Header / Footer	***/
/***	Directives		***/
(function() {
	var app = angular.module('common-elements', []);
	app
		//	Header directive
		.directive('appHeader', function(){
			return {
				restrict: 'E',
				templateUrl: 'includes/app-header.html'
			};
		})
		//	Footer directive
		.directive('appFooter', function(){
			return {
				restrict: 'E',
				templateUrl: 'includes/app-footer.html'
			};
		})
		.directive('rightnav', function(){
			return {
				restrict: 'E',
				templateUrl: 'includes/rightnav.html'
			};
		})

})();
