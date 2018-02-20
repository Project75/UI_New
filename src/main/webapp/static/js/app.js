//'use strict';
var fhirApp = angular.module('fhirApp', ['ngRoute', 'trNgGrid', 'isteven-multi-select', 'ui.bootstrap', 'ui.bootstrap.showErrors', 'ui.utils', 'xeditable','ngSanitize']);
fhirApp.config(function($routeProvider) {
	$routeProvider
			.when(
					'/',
					{
						templateUrl : 'angularjs/templates/Home',
						controller : 'HomeCtrl',
					    controllerAs: 'ctrl'
					})
			.when(
					'/mappings/mappingList',
					{
						templateUrl : 'angularjs/templates/MappingList',
						controller : 'MappingListCtrl',
					    controllerAs: 'ctrl'
					})
			.when(
					'/mappings/mappingDetail/:mappingId',
					{
						templateUrl : 'angularjs/templates/MappingDetail',
						controller : 'MappingDetailCtrl',
					    controllerAs: 'ctrl'
					})		
			.when(
					'/mappings/addMapping/:mappingId',
					{
						templateUrl : 'angularjs/templates/AddMapping',
						controller : 'AddMappingCtrl',
					    controllerAs: 'ctrl'
					})
			.when(
					'/profiles/profileList',
					{
						templateUrl : 'angularjs/templates/ProfileList',
						controller : 'ProfileListCtrl',
					    controllerAs: 'ctrl'
					})
			.when(
					'/profiles/profileDetail/:profileId',
					{
						templateUrl : 'angularjs/templates/ProfileDetail',
						controller : 'ProfileDetailCtrl',
					    controllerAs: 'ctrl'
					})
					
			.otherwise({
				redirectTo : '/'
			});
});


