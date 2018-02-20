(function(){
	
	angular.module('fhirApp').factory('MappingService', function MappingService($http ,NotificationService) {
		
		var MappingService = {};
			
		
		MappingService.getList = function() {			
			 return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getList');
		};
		
		MappingService.getById = function(mappingId) {			
			 return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getById/' + mappingId);
		};
		
		
		MappingService.getForAddInit = function() {
		   return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getForAddInit');
		};
		
		MappingService.getForNewMapping = function(mappingOptions) {
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/getForNewMapping' , mappingOptions);
		};
		
		MappingService.saveMappping = function(mapping) {
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/saveMappping' ,mapping);
		};
				
		MappingService.deleteMappping = function(mappingId) {
			   return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/delete/' + mappingId);
			};
		
		
		
		return MappingService;			
	});
		
	
	

})();	