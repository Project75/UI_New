(function(){	
	function AddMappingCtrl($scope, $route, $routeParams, $location, MappingService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.option ='newMapping';
		vm.showCustomFields = false;
		vm.isSequentialView = true;      //Default is sequential view
		vm.showMappingInitialScreen = true;
		vm.emptyResourceType = false;
		vm.mapping = {};
		vm.mandatoryFieldList = []; 
    	vm.optionalFieldList = []; 
    	vm.customFieldList = [];
    	vm.allFieldList = [];
    	vm.mandatoryCompletedFields = [];
    	vm.fieldList = []; //Common var used for common reference on jsp

		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};
		
		vm.fieldTypes = [{id:"mandatoryFields", name : "Mandatory Fields" , IsOpened : true},
					     {id:"optionalFields", name : "Optional Fields", IsOpened : false},
					     {id:"customFields", name : "Custom Fields", IsOpened : false}
					    ];
		
		MappingService.getForAddInit()
		    .then(function (response) {
		    	vm.resourceTypeList = response.data.resourceList;
		    	vm.baseProfileList = response.data.baseProfileTypeList;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details to add");
	    });	
		
		
		vm.init = function() {
			MappingService.getForNewMapping(vm.mapping)
		    .then(function (response) {
		    	
		    	vm.mandatoryFieldList = response.data.mandatoryFieldList; 
		    	vm.optionalFieldList = response.data.optionalFieldList; 
		    	vm.customFieldList = response.data.customFieldList;
		    	vm.allFieldList = response.data.allFieldList;
		    	vm.hl7fieldList = response.data.hl7fieldList ;
		    	vm.segmentList = response.data.segmentList ;
		    	
		    	for (var i=0 ; i < vm.optionalFieldList.length; i++ ) {
		    		vm.optionalFieldList[i].showRemoveButton =  true;
		    	}
		    	
		    	for (var i=0 ; i < vm.customFieldList.length; i++ ) {
		    		vm.customFieldList[i].showRemoveButton =  true;
		    	}
		    	
		    	for (var i=0; i < vm.allFieldList.length; i++) {
		    		if (vm.allFieldList[i].isCustomField == true || vm.allFieldList[i].isRequired == false) {
		    			vm.allFieldList[i].showRemoveButton = true;
		    		}
		    	}
		    	
		    	if (vm.isSequentialView == true) {
		    		console.log(" In seq view");
		    		vm.fieldList = vm.allFieldList;
		    		console.log("vm.fieldList :" , vm.fieldList.length);
		    	} else {
		    		vm.fieldTypes[0].IsOpened = true;
		    		console.log("In else part");
		    	}
		    	
		    	vm.calculateProgress();
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details to add");
		    });	
		}
		
		
		vm.onRadioChange = function() {			
			if (vm.option == 'existingMapping') {
				
				MappingService.getList()
			    .then(function (response) {
			    	console.log("response :" , response);
			    	//vm.existingMappingsList  = response.data.resourceList;
			    })
			    .catch(function (response) {
			    	vm.pageLoadComplete = true;
			    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details to add");
			    });	
			} 
		} 
		
		vm.proceedAdd = function () {
			
			if (vm.mapping.selectedResources.length < 1) {
				vm.emptyResourceType = true;
			}
			$scope.$broadcast('show-errors-check-validity' , addMappingInitForm);
			if ($scope.addMappingInitForm.$invalid) {
				return; 
	        }
			
			vm.showMappingInitialScreen = false;
			vm.init();
		}

		
		vm.changeView = function(viewType) {
			if (viewType == 'cat') {
				vm.isSequentialView = false;
			} else {
				vm.isSequentialView = true;
			}
		}
		
		vm.onSegmentChange = function(gridItem) {
			gridItem.hl7fieldList = [];
			
			for (var i=0; i < vm.hl7fieldList.length ; i++) {
				if (gridItem.hl7Segment) {
					if (vm.hl7fieldList[i].segmentId == gridItem.hl7Segment.segmentId) {
						gridItem.hl7fieldList.push(vm.hl7fieldList[i]);
					}
				}	
			}
		}
		
		
		vm.addOccurrence = function(gridItem) {
			
			var newItem = angular.copy(gridItem);
			newItem.isRequired = false;
			newItem.isRepetitive = false;
			newItem.showRemoveButton = true;
			
			var index = vm.fieldList.indexOf(gridItem);
			
			if (index > -1 && gridItem.totalOccurences < 10) {
				//for (var i =1 ;i < gridItem.totalOccurences; i++) {
					vm.fieldList.splice(index + i , 0 , newItem);
					gridItem.totalOccurences ++ ;
				//}
			}
		}
		
		vm.removeOccurrence = function(gridItem) {
			console.log("Removing");
			
			var index = vm.fieldList.indexOf(gridItem);
			
			if (index > -1) {
				vm.fieldList.splice(index , 0);
			}
		}
		
		vm.addCustomField = function() {
			var profileField = {};
			
			profileField.isRepetitive = true;
			profileField.isCustomField = true;
			profileField.isRequired =  false;
			profileField.showRemoveButton = true;
			
			if (vm.isSequentialView == true) {
				vm.allFieldList.push(profileField);
			} else {
				vm.customFieldList.push(profileField);
			}
		}
		
		vm.onFieldNameChange = function(gridItem) {
			gridItem.isNowRequired = true;
		}
		
		
		vm.calculateProgress = function(gridItem) {
		    vm.progressPercentage = 0;
		    vm.type = "";
		    console.log("vm.mandatoryCompletedFields.length: B4" , vm.mandatoryCompletedFields.length);
		    console.log("gridITem:" , gridItem);
		    
		    if ( (gridItem != undefined)  && (gridItem.hl7Field != null  && gridItem.hl7Segment != null && gridItem.isRequired == true) && (!vm.mandatoryCompletedFields.indexOf(gridItem) > -1)) {
		    	console.log("Pushing");
		    	vm.mandatoryCompletedFields.push(gridItem);
		    }
		    
		    console.log("vm.mandatoryCompletedFields.length:" , vm.mandatoryCompletedFields.length);
		    if (vm.mandatoryCompletedFields.length > 0) {
		    	vm.progressPercentage = (vm.mandatoryCompletedFields.length / vm.mandatoryFieldList.length ) * 100;
		    }
		    
		    console.log("vm.progressPercentage :"  , vm.progressPercentage);
		    if (vm.progressPercentage >= 75 ) {
		    	vm.type = 'success';
		    } else if (vm.progressPercentage < 75 && vm.progressPercentage >= 50) {
		    	vm.type = 'info';
		    } else if (vm.progressPercentage < 50 && vm.progressPercentage >= 25) {
		    	vm.type = 'warning';
		    } else {
		    	vm.type = 'danger';
		    }
		  };

		
		vm.save = function() {
			
			/*for (var i=0 ; i < vm.fieldList.length ; i++) {
				console.log("In for");
				if (vm.fieldList[i].isRequired == false  &&  vm.fieldList[i].hl7Segment) {
					console.log("In 1 if " , i);
					if (vm.fieldList[i].hl7Field == undefined || vm.fieldList[i].hl7Field == null) {
						console.log("In 2 if :" ,i);
						vm.fieldList[i].fieldForm.field.$error.required = true;
					}
				}
			}*/
			
			$scope.$broadcast('show-errors-check-validity');
			if ($scope.addMappingForm.$invalid) {
				return; 
	        }
			
			vm.mapping.mappedFields = vm.mandatoryFieldList;
			
			if (vm.optionalFieldList.length > 0) {
				vm.mapping.mappedFields = vm.mapping.mappedFields.concat(vm.optionalFieldList);
			}
			
			if (vm.customFieldList.length > 0) {
				vm.mapping.mappedFields = vm.mapping.mappedFields.concat(vm.customFieldList);
			}
			
			for (var i = 0; i < vm.mapping.mappedFields.length; i++) {
				delete vm.mapping.mappedFields[i].id;
			}
			
			MappingService.saveMappping(vm.mapping)
		    .then(function (response) {
		    	
		    	console.log("resposne :" , response );
		    	NotificationService.addMessage("Mapping - "  + vm.mapping.mappingName + " added successfully.");
				$location.path("/mappings/mappingList");
		    })
		    .catch(function (response) {
		    	ErrorHandlerService.handleError(response, vm.errors, "Error saving mapping");
		    });	
		}
		

		
		
		// Initial page load
	//	vm.init();
		
		
		vm.fieldTypes.forEach(function(item) {
            var isOpened = false;
            Object.defineProperty(item, "IsOpened",
            {
                get : function() { return isOpened; },
                set : function (newValue) {
                    isOpened = newValue;
                    if (isOpened) {
                        console.log("Openend Item :" , item); 
                         if (item.id == 'mandatoryFields') {
                        	 vm.fieldList = vm.mandatoryFieldList;
                        	 vm.showCustomFields = false;
                         } else if (item.id == 'optionalFields') {
                        	 vm.fieldList = 	vm.optionalFieldList;
                        	 vm.showCustomFields = false;
                         } else if (item.id == 'customFields') {
                        	 vm.fieldList = vm.customFieldList;
                        	 vm.showCustomFields = true;
                         }
                        
                      }
                }});
		});
		
		vm.go = function(path) {
			$location.path(path);
		}
		
	}
	
	angular.module('fhirApp').controller('AddMappingCtrl', AddMappingCtrl);	
})();
