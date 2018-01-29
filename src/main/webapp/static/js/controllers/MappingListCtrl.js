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
			
			console.log("In getList");			
			MappingService.getList()
		    .then(function (response) {
		    	console.log("response :" , response.data);
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping list.");
	    });	
			
		};
		
		// Initial page load
		vm.getList();	
		
		vm.addMapping = function(type) {
			var modalDefaults = {
					templateUrl: '/' + SERVER_INSTANCE_NAME + '/angularjs/templates/AddMappingModal',
					windowClass: 'fhir-addMappingModal'
				};
					
	    	var modalOptions = {
				closeButtonText: 'Cancel',
				actionButtonText: 'Next',
				headerText: 'Add Mapping'
			};
	        
			ModalService.showModal(modalDefaults, modalOptions).then(function(response) {
				if (type =='seq') {
					$location.path("/mappings/addMappingSeq");
				} else {
					$location.path("/mappings/addMappingCat");
				}
				
			}).catch(function (response) {
				//Added so that no error is displayed on console for canceling the modal .
	        });
		}
		
		vm.addNewMapping = function() {
			$location.path("/mappings/addMapping");
		}
		
	}
	
	angular.module('fhirApp').controller('MappingListCtrl', MappingListCtrl);	
})();
