(function(){	
	function ProfileListCtrl($scope, $route, $routeParams, $location, ProfileService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.profileList = [];

		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};	

		vm.getList = function() {			
			ProfileService.getList()
		    .then(function (response) {
		    	vm.profileList = response.data;
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving profile list.");
		    });	
			
		};
		
		// Initial page load
		vm.getList();
		
		
		vm.goToDetail = function(id) {
			$location.path("/profiles/profileDetail/" + id);
		}
		
	}
	
	angular.module('fhirApp').controller('ProfileListCtrl', ProfileListCtrl);	
})();
