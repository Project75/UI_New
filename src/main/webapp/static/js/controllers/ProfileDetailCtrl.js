(function(){	
	function ProfileDetailCtrl($scope, $route, $routeParams, $location, ProfileService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.pageLoadComplete = false;
		vm.profile = {};

		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};
		
		ProfileService.getById($routeParams.profileId)
	    .then(function (response) {
	    	vm.profile  = response.data;
	    	vm.pageLoadComplete = true;
	    })
	    .catch(function (response) {
	    	vm.pageLoadComplete = true;
	    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving profile details.");
	    });	
				
		
		vm.go = function(path) {
			$location.path(path);
		}
		
	}
	
	angular.module('fhirApp').controller('ProfileDetailCtrl', ProfileDetailCtrl);	
})();
