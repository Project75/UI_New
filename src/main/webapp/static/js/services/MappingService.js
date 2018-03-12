(function(){
	
	angular.module('fhirApp').factory('MappingService', function MappingService($http ,NotificationService) {
		
		var MappingService = {};
			
		
		MappingService.getList = function(searchStr) {
			return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getList/' + searchStr);
		};
		
		MappingService.getById = function(mappingId) {			
			 return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/' + mappingId);
		};
		
		
		MappingService.getForAddInit = function() {
		   return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/getForAddInit');
		};
		
		MappingService.getForNewMapping = function(mappingOptions) {
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/getForNewMapping' , mappingOptions);
		};
		
		MappingService.saveMappping = function(mapping) {
		   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/save' ,mapping);
		};
		
		MappingService.addMappping = function(mapping) {
			   return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/add' ,mapping);
			};
				
		MappingService.deleteMappping = function(mappingId) {
			return $http.get('/' + SERVER_INSTANCE_NAME + '/api/mapping/delete/' + mappingId);
			//return $http.delete(TRANSLATOR_API_URL + 'delete/' + mappingId);
		};
		
		MappingService.changeStatus = function(mapping, targetStatusCode){
			return $http.post('/' + SERVER_INSTANCE_NAME + '/api/mapping/changeStatus/' + targetStatusCode , mapping);
		};
		
		
		
		return MappingService;			
	});
		
	
	

})();	