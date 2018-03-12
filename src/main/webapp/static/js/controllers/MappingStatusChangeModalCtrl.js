(function(){	
	function MappingStatusChangeModalCtrl($scope, $route, $routeParams, $location, MappingService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.targetStatusCode = null;
		vm.isAcknowledged = false;
		vm.operationInProgress = false;
		vm.proceedButtonDisabled = true;
		vm.acknowledgementRequired = false;
		
		vm.mapping = {};
		
		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};
			
		
		vm.onFormChange = function() {
			
			vm.proceedButtonDisabled = true;
			
			if ((vm.targetStatusCode == 'reviewed')  && (vm.isAcknowledged)) {
				vm.proceedButtonDisabled = false;
			} else if ((vm.targetStatusCode == 'suspended')  && (vm.isAcknowledged)) {
					vm.proceedButtonDisabled = false;		
			} else if ((vm.targetStatusCode == 'deployed') && (vm.isAcknowledged)){
				vm.proceedButtonDisabled = false;
			} else if ((vm.targetStatusCode == 'testing') || (vm.targetStatusCode == 'development') || (vm.targetStatusCode == 'onHold') || (vm.targetStatusCode == 'cancelled')) {					
				vm.proceedButtonDisabled = false;
			}	
			
			
			if ((vm.targetStatusCode == 'reviewed') || (vm.targetStatusCode == 'suspended') || (vm.targetStatusCode == 'deployed')) {
				vm.acknowledgementRequired = true;
			} else {
				vm.acknowledgementRequired = false;
			}
		}
		
		vm.cancel = function(modalOptions) {
			modalOptions.close();
		}
		
		
		
		vm.updateMapping = function() {
			
		}
		
		
		vm.proceed = function(modalOptions) {
			vm.operationInProgress = true;
			
							
			MappingService.changeStatus(modalOptions.mapping, vm.targetStatusCode)
		    .then(function (response) {
		    	//NotificationService.addMessage();
		    	console.log(" Response :" , response.data);
		    	vm.messages("Mapping Status Changed to " + response.data );
		    	vm.updateMapping();
		    	vm.operationInProgress = false;
				modalOptions.ok();
		    })
		    .catch(function (response) {
		    	vm.operationInProgress = false;
		    	console.log("response:" , response);
		    	ErrorHandlerService.handleError(response, vm.errors, "Error changing status.");
		    });	
			
			
						
		}

		
	}
	
	angular.module('fhirApp').controller('MappingStatusChangeModalCtrl', MappingStatusChangeModalCtrl);	
})();
