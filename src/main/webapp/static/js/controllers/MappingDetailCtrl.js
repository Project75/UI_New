(function(){	
	function MappingDetailCtrl($scope, $route, $routeParams, $location, MappingService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.pageLoadComplete = false;
		vm.mapping = {};
		vm.fieldList = []; 
		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};
				
		
		
		
		vm.getMappingById = function() {
			
			MappingService.getById($routeParams.mappingId)
		    .then(function (response) {
		    	vm.mapping  = response.data;
		    	vm.fieldList = vm.mapping.mappingDetail;
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details.");
		    });	
		}
		
		
		//Call On Load
		vm.getMappingById();		
		
		vm.go = function(path) {
			$location.path(path);
		}
		
	}
	
	angular.module('fhirApp').controller('MappingDetailCtrl', MappingDetailCtrl);	
})();
