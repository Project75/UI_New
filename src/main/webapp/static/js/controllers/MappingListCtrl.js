(function(){	
	function MappingListCtrl($scope, $route, $routeParams, $location, MappingService, ModalService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.mappingList = [];

		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};	

		vm.getList = function() {			
			MappingService.getList()
		    .then(function (response) {
		    	vm.mappingList = response.data;
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping list.");
		    });	
			
		};
		
		// Initial page load
		vm.getList();
		
		vm.addNewMapping = function() {
			$location.path("/mappings/addMapping/0");
		}
		
		vm.goToDetail = function(id) {
			$location.path("/mappings/mappingDetail/" + id);
		}
		
		vm.edit = function(mappingId) {
			$location.path("/mappings/addMapping/" + mappingId);
		}
		
		vm.delete =  function(mappingId) {
			
			vm.clearNotifications();
			
			MappingService.deleteMappping(mappingId)
		    .then(function (response) {
		    	vm.messages.push("Mapping deleted successfully.");
		    	vm.getList();
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error deleting mapping.");
		    });	
			
		}
		
	}
	
	angular.module('fhirApp').controller('MappingListCtrl', MappingListCtrl);	
})();
