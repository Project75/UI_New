(function(){
	
	angular.module('fhirApp').factory('MappingService', function MappingService($http ,NotificationService) {
		
		var MappingService = {};
		
		var newMappingSelectedOptions = null;
		
		MappingService.getNewMappingSelectedOptions =  function() {
			return MappingService.newMappingSelectedOptions;
		}
		
		MappingService.setNewMappingSelectedOptions = function(object) {
			console.log("In setting mapping options");
			MappingService.newMappingSelectedOptions = object;
		}
		
		
		MappingService.getList = function() {			
			 return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getList');
		};
		
		
		MappingService.getForAddInit = function() {
		   return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getForAddInit');
		};
		
		MappingService.getForNewMapping = function(mappingOptions) {
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/getForNewMapping' , mappingOptions);
		};
		
		MappingService.getCategorizedFieldsForMapping = function(mappingOptions) {
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/getCategorizedFieldsForMapping' , mappingOptions);
		};
		
		MappingService.saveMappping = function(mapping) {
			//console.log("In save mapping of service : " , mapping);
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/saveMappping' ,mapping);
		};
		
		
		
		return MappingService;			
	});
		
	
	

})();	