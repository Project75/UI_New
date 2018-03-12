(function(){	
	function AddMappingCtrl($scope, $route, $routeParams, $location, MappingService, ModalService, NotificationService, ErrorHandlerService) {		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		vm.option ='newMapping';
		vm.showCustomFields = false;
		vm.isSequentialView = true;      //Default is sequential view
		vm.showMappingInitialScreen = true;
		vm.emptyResourceType = false;
		vm.pageLoadComplete = false;
		vm.mapping = {};
		vm.mandatoryFieldList = []; 
    	vm.optionalFieldList = []; 
    	vm.customFieldList = [];
    	vm.allFieldList = [];
    	vm.hl7fieldList = [];
    	vm.mandatoryCompletedFields = [];
    	vm.fieldList = []; //Common var used for common reference on jsp

		vm.clearNotifications = function() {
			NotificationService.reset();
	    	vm.messages.length = 0;
	    	vm.errors.length = 0;			
		};
		
		//Constant values ... May be later moved to properties file.
		vm.mappingTypeList = [{id:"hl7", name : "HL7 to FHIR"},
		     			   	  {id:"custom", name : "Custom to FHIR"},
		                      {id:"cda", name : "CDA to FHIR"}
		     			     ];
		
		vm.messageTypeList = [{id:"bundle", name : "Bundle"},
						  	  {id:"individual", name : "Individual"}
			 			     ];
		
		vm.bundleTypeList = [{id:"message", name : "Message"},
			   			     {id:"transaction", name : "Transaction"}
			 			    ];
		
		vm.referenceURLOptions = [{id:"absolute", name : "Absolute reference"},
								  {id:"relative", name : "Relative reference within the Bundle"},
								  {id:"global", name : "Global Identifier"}
								 ];
		
		vm.resourceCreationRules = [{id:"alwaysNew", name : "Always Create new resource"},
			   						{id:"onlyWhenNewRecord", name : "Create resource if new record"}
			 					   ];	
		
		vm.fieldTypes = [{id:"mandatoryFields", name : "Mandatory Fields" , IsOpened : true},
					     {id:"optionalFields", name : "Optional Fields", IsOpened : false},
					     {id:"customFields", name : "Custom Fields", IsOpened : false}
					    ];
		
		vm.getForAddInit = function() {
			MappingService.getForAddInit()
		    .then(function (response) {
		    	vm.resourceTypeList = response.data.resourceList;
		    	vm.baseProfileList = response.data.baseProfileTypeList;
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details to add");
		    });
		}	
		
		
		vm.init = function() {
			
			MappingService.getForNewMapping(vm.mapping)
		    .then(function (response) {
		    	vm.mandatoryFieldList = response.data.mandatoryFieldList;
		    	vm.optionalFieldList = response.data.optionalFieldList;
		    	vm.customFieldList = response.data.customFieldList;
		    	vm.allFieldList = response.data.allFieldList;
		    	vm.hl7fieldList = response.data.hl7fieldList;
		    	vm.segmentList = response.data.segmentList ;
		    	
		    	for (var i=0 ; i < vm.optionalFieldList.length; i++ ) {
		    		vm.optionalFieldList[i].showRemoveButton =  true;
		    	}
		    	
		    	for (var i=0 ; i < vm.customFieldList.length; i++ ) {
		    		vm.customFieldList[i].showRemoveButton =  true;
		    	}
		    	
		    	for (var i=0; i < vm.allFieldList.length; i++) {
		    		if (vm.allFieldList[i].isExtension == true || vm.allFieldList[i].isRequired == false) {
		    			vm.allFieldList[i].showRemoveButton = true;
		    		}
		    		
		    		if (vm.allFieldList[i].staticValuesList != null  && vm.allFieldList[i].staticValuesList != undefined) {
		    			vm.allFieldList[i].showStaticValues = true;
		    		}	
		    	}
		    	
		    	if (vm.isSequentialView == true) {
		    		vm.fieldList = vm.allFieldList;
		    	} else {
		    		vm.fieldTypes[0].IsOpened = true;
		    	}
		    	
		    	if (vm.option == 'existingMapping'  || vm.mode == 'Update') {
		    		if (vm.option == 'existingMapping') {
		    			vm.fieldList = vm.referencedMapping.mappingDetail;
		    		}
		    		if (vm.mode == 'Update') {
		    			vm.fieldList = vm.mapping.mappingDetail;
		    		}
		    		vm.initializeFieldList(vm.fieldList);
		    	}
		    	
		    	vm.calculateProgress();
		    	vm.pageLoadComplete = true;
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details to add");
		    });	
		}
		
		
		vm.initializeFieldList = function(fieldList) {  //Method used to set custom properties for data fetched from API like total Occureences ,show remove button etc.
			
			for (var i = 0; i < fieldList.length; i++) {
    			vm.onSegmentChange(fieldList[i]);
    			if (fieldList[i].isRepeating == true) {
    				fieldList[i].totalOccurences = 1;
    			}
    			
    			if (fieldList[i].isExtension == true || fieldList[i].isRequired == false) {
	    			fieldList[i].showRemoveButton = true;
	    		}
    		}
		}
		
		vm.getMappingById = function(mappingId) {
			MappingService.getById(mappingId)
		    .then(function (response) {
		    	
		    	if (vm.mode == 'Add') {
		    		vm.referencedMapping  = response.data;
		    	} else {
		    		vm.mapping  = response.data;
		    		vm.init();
		    	}
		    	
		    })
		    .catch(function (response) {
		    	vm.pageLoadComplete = true;
		    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving mapping details.");
		    });	
		}
		
		
		if ($routeParams.mappingId == 0) {			
			vm.mode = "Add";
			vm.message = "added";
			vm.getForAddInit();
			
		} else {			
			vm.mode = "Update";
			vm.message = "updated";
			vm.showMappingInitialScreen = false;
			vm.getMappingById($routeParams.mappingId);
		}
		
		vm.onRadioChange = function() {			
			if (vm.option == 'existingMapping') {
				
				MappingService.getList()
			    .then(function (response) {
			    	vm.existingMappingList  = response.data;
			    })
			    .catch(function (response) {
			    	vm.pageLoadComplete = true;
			    	ErrorHandlerService.handleError(response, vm.errors, "Error retrieving existing mapping list.");
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
			var index ;
			if (viewType == 'cat') {
				
				vm.isSequentialView = false;
				vm.mandatoryFieldList = [];
				vm.customFieldList = [];
				vm.optionalFieldList =[];
				
				for (var i=0; i < vm.fieldList.length ; i++) {
										
					if ( vm.fieldList[i].isRequired == true) {
						vm.mandatoryFieldList.push(vm.fieldList[i]);
					} else {
						if (vm.fieldList[i].isExtension == true) {
							vm.customFieldList.push(vm.fieldList[i]);
						} else {
							vm.optionalFieldList.push(vm.fieldList[i]);
						}
					} 
					
				}			
				vm.fieldTypes[0].IsOpened = true;
			} else {
				vm.isSequentialView = true;
				vm.fieldList = vm.mandatoryFieldList.concat(vm.optionalFieldList , vm.customFieldList);
			}
		}
		
		vm.onSegmentChange = function(gridItem) {
			gridItem.hl7fieldList = [];
			for (var i=0; i < vm.hl7fieldList.length ; i++) {
				if (gridItem.hl7Segment) {
					if (vm.hl7fieldList[i].segmentName == gridItem.hl7Segment) {
						gridItem.hl7fieldList.push(vm.hl7fieldList[i]);
					}
				}	
			}
		}
		
		
		vm.addOccurrence = function(gridItem) {
			
			var newItem = angular.copy(gridItem);
			newItem.isRequired = false;
			newItem.isRepeating = false;
			newItem.showRemoveButton = true;
			
			var index = vm.fieldList.indexOf(gridItem);
			
			if (index > -1 && gridItem.totalOccurences < 10) {
					vm.fieldList.splice(index + 1 , 0 , newItem);
					gridItem.totalOccurences ++ ;
			} else if (index == -1) {
				vm.fieldList.push(newItem);
			}
		}
		
		vm.removeOccurrence = function(gridItem) {
			var index = vm.fieldList.indexOf(gridItem);
			
			if (index > -1) {
				vm.fieldList.splice(index , 1);
			}
		}
		
		vm.addCustomField = function() {
			var profileField = {};
			
			profileField.isRepeating = false;
			profileField.isExtension = true;
			profileField.isRequired =  false;
			profileField.showRemoveButton = true;
			
			if (vm.isSequentialView == true) {
				vm.fieldList.push(profileField);
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
		    if ( (gridItem != undefined)  && (gridItem.hl7Field != null  && gridItem.hl7Segment != null && gridItem.isRequired == true) && (!vm.mandatoryCompletedFields.indexOf(gridItem) > -1)) {
		    	vm.mandatoryCompletedFields.push(gridItem);
		    }
		    
		    if (vm.mandatoryCompletedFields.length > 0) {
		    	vm.progressPercentage = (vm.mandatoryCompletedFields.length / vm.mandatoryFieldList.length ) * 100;
		    }
		    
		    if (vm.progressPercentage >= 75 ) {
		    	vm.type = 'success';
		    } else if (vm.progressPercentage < 75 && vm.progressPercentage >= 50) {
		    	vm.type = 'info';
		    } else if (vm.progressPercentage < 50 && vm.progressPercentage >= 25) {
		    	vm.type = 'warning';
		    } else {
		    	vm.type = 'danger';
		    }
		  }
		  
		vm.showOptionalFieldDialog = function() {
			var idx;
			
			if (vm.mode == 'Update') {
				console.log(" HAHHAHHA");
				/*for (var i = 0; i < vm.fieldList.length; i++) {	
					vm.optionalFieldList.forEach(function(element)) {
						 if (element.fieldName  == vm.fieldList[i].fieldName) {
							 
						 }
						
					}); 
					
				
					idx = vm.optionalFieldList.findIndex(vm.fieldList[i] =>  vm.fieldList[i].fieldName == );
					console.log("idx :" + idx);
					if (idx > -1) {
						vm.optionalFieldList.splice(idx, 1);
						console.log("Spliced.");
					}
				}*/
			}
			
			var modalDefaults = {
					templateUrl: '/' + SERVER_INSTANCE_NAME + '/angularjs/templates/AddOptionalFieldModal',
					windowClass: 'fhir-addMappingModal'
				};
					
	    	var modalOptions = {
				closeButtonText: 'Cancel',
				actionButtonText: 'Proceed',
				headerText: 'Select Fields', 
				optionalFieldList : vm.optionalFieldList
			};
	        
			ModalService.showModal(modalDefaults, modalOptions).then(function(response) {
				
				for (var i=0 ; i < modalOptions.optionalFieldList.length ; i++) {
				
					if (modalOptions.optionalFieldList[i].isSelected == true) {
						modalOptions.optionalFieldList[i].isSelected = false;
						vm.addOccurrence(modalOptions.optionalFieldList[i]);
					}
				}
			}).catch(function (response) {
				//Added so that no error is displayed on console for canceling the modal .
	        });
		} 
		
		
		vm.proceed = function(modalOptions) {
			modalOptions.ok();
		}

		
		vm.add = function() {
			
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
			
			/*$scope.$broadcast('show-errors-check-validity');
			if ($scope.addMappingForm.$invalid) {
				return; 
	        }*/
			
			if (vm.isSequentialView == true) {
				vm.mapping.mappingDetail = vm.fieldList;
			} else {
				vm.mapping.mappingDetail = vm.mandatoryFieldList;
				
				if (vm.optionalFieldList.length > 0) {
					vm.mapping.mappingDetail = vm.mapping.mappingDetail.concat(vm.optionalFieldList);
				}
				
				if (vm.customFieldList.length > 0) {
					vm.mapping.mappingDetail = vm.mapping.mappingDetail.concat(vm.customFieldList);
				}
			}
			
			MappingService.addMappping(vm.mapping)
		    .then(function (response) {
		    	NotificationService.addMessage("Mapping - "  + vm.mapping.name + " " + vm.message + " successfully.");
				$location.path("/mappings/mappingList");
		    })
		    .catch(function (response) {
		    	ErrorHandlerService.handleError(response, vm.errors, "Error saving mapping");
		    });	
		}
		
		
		vm.update = function() {
			
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
			
			/*$scope.$broadcast('show-errors-check-validity');
			if ($scope.addMappingForm.$invalid) {
				return; 
	        }*/
			
			if (vm.isSequentialView == true) {
				vm.mapping.mappingDetail = vm.fieldList;
			} else {
				vm.mapping.mappingDetail = vm.mandatoryFieldList;
				
				if (vm.optionalFieldList.length > 0) {
					vm.mapping.mappingDetail = vm.mapping.mappingDetail.concat(vm.optionalFieldList);
				}
				
				if (vm.customFieldList.length > 0) {
					vm.mapping.mappingDetail = vm.mapping.mappingDetail.concat(vm.customFieldList);
				}
			}
			
			MappingService.saveMappping(vm.mapping)
		    .then(function (response) {
		    	NotificationService.addMessage("Mapping - "  + vm.mapping.name + " " + vm.message + " successfully.");
				$location.path("/mappings/mappingList");
		    })
		    .catch(function (response) {
		    	ErrorHandlerService.handleError(response, vm.errors, "Error updating mapping");
		    });	
		}
		
		
		vm.onStaticValueChange = function(item) {
			if (item.staticValue == 'other') {
				item.showStaticInput = true;
			} else {
				item.showStaticInput = false;
			}
		} 
		
		vm.fieldTypes.forEach(function(item) {
            var isOpened = false;
            Object.defineProperty(item, "IsOpened",
            {
                get : function() { return isOpened; },
                set : function (newValue) {
                    isOpened = newValue;
                    if (isOpened) { 
                         if (item.id == 'mandatoryFields') {
                        	 vm.fieldList = vm.mandatoryFieldList;
                        	 vm.showCustomFields = false;
                         } else if (item.id == 'optionalFields') {
                        	 vm.fieldList = vm.optionalFieldList;
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
		
		vm.cancel = function(modalOptions) {
			modalOptions.close();
		}
		
	}
	
	angular.module('fhirApp').controller('AddMappingCtrl', AddMappingCtrl);	
})();
