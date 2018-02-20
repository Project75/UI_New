(function(){
	
	angular.module('fhirApp').factory('ProfileService', function ProfileService($http ,NotificationService) {
		
		var ProfileService = {};
				
		
		ProfileService.getList = function() {			
			 return $http.get('/' + SERVER_INSTANCE_NAME + '/api/profile/getList');
		};
		
		ProfileService.getById = function(profileId) {			
			 return $http.get('/' + SERVER_INSTANCE_NAME + '/api/profile/getById/' + profileId);
		};
		
		
		
		return ProfileService;			
	});
	

})();	