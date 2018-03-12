(function(){	
	function MappingDetailCtrl($scope, $route, $routeParams, $location, MappingService, ModalService, NotificationService, ErrorHandlerService) {		
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
		    	//vm.mapping.mappedFields = vm.fieldList;
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details.");
		    });	
		}
		
		vm.changeStatus = function() {
			
			var modalDefaults = {
					templateUrl: '/' + SERVER_INSTANCE_NAME + '/angularjs/templates/MappingStatusChangeModal',
					windowClass: 'fhir-mappingStatusChangeModal'
				};
					
	    	var modalOptions = {
	    			closeButtonText: 'Close',
					actionButtonText: 'Save',
					headerText: 'Are you sure?',
					mapping : vm.mapping
			};
		        
			ModalService.showModal(modalDefaults, modalOptions).then(function(response) {
				$route.reload();
			}).catch(function (response) {
				//Added so that no error is displayed on console for canceling the modal .
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
