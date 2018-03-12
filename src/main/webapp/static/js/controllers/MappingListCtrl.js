(function(){	
	function MappingListCtrl($scope, $route, $routeParams, $location, MappingService, ModalService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.mappingList = [];
		
		vm.validCharactersRegex = /^[a-zA-Z0-9@.'-() ]*$/;
		
		vm.searchStr = "";

		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};
		
		vm.getListByFilter = function() {
			if (vm.searchStr == null || vm.searchStr == '') {
				searchStr = '~';
			} else {
				searchStr = vm.searchStr;
			}
			vm.getList(searchStr);
		}

		vm.getList = function(searchStr) {
			
			MappingService.getList(searchStr)
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
		vm.getList('~');
		
		vm.addNewMapping = function() {
			$location.path("/mappings/addMapping/0");
		}
		
		vm.goToDetail = function(id) {
			$location.path("/mappings/mappingDetail/" + id);
		}
		
		vm.edit = function(mappingId) {
			$location.path("/mappings/addMapping/" + mappingId);
		}
		
		
		vm.deleteConfirmationDialog = function(mapping) {
			vm.operationInProgress = true;
			
			var modalDefaults = {
				templateUrl: '/' + SERVER_INSTANCE_NAME + '/static/modal.html'
			};
			
			var modalOptions = {
				closeButtonText: 'Cancel',
				actionButtonText: 'Delete',
				headerText: 'Are you sure?',
				bodyText: 'You will not be able to recover this mapping once deleted.'
			};

			ModalService.showModal(modalDefaults, modalOptions).then(function(result){
				vm.delete(mapping.id);
			})
			.catch(function (response) {
			    	vm.operationInProgress = false;
			 });
		}
		
		vm.delete =  function(mappingId) {
			
			vm.clearNotifications();
			
			MappingService.deleteMappping(mappingId)
		    .then(function (response) {
		    	vm.messages.push("Mapping deleted successfully.");
		    	vm.getList('~');
		    })
		    .catch(function (response) {
		    	vm.operationInProgress = false;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error deleting mapping.");
		    });	
			
		}
		
	}
	
	angular.module('fhirApp').controller('MappingListCtrl', MappingListCtrl);	
})();
