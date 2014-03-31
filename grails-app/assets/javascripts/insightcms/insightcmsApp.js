var angrailsApp = angular.module('insightcmsApp', []);
angrailsApp.controller('MainCtrl', ['$scope',
	function ($scope) {
		$scope.helloText = 'Welcome to InsightCMS!';
	}
])