(function(){
	
	angular.module('fhirApp').factory('NotificationService', function NotificationService($http){
		
		var NotificationService = {};
		
		NotificationService.shown = false;
			
		NotificationService.errors = [];		
		NotificationService.warnings = [];		
		NotificationService.messages = [];
		
		NotificationService.addError = function(error){
			NotificationService.errors.push(error);
		};

		NotificationService.addWarning = function(warning){
			NotificationService.warnings.push(warning);
		};
		
		NotificationService.addMessage = function(message){
			NotificationService.messages.push(message);
		};
		
		NotificationService.reset = function(){
			NotificationService.shown = false;
			NotificationService.errors = [];
			NotificationService.warnings = [];
			NotificationService.messages = [];
			
		};		
		
		
		
		NotificationService.loadForView = function() {
		    return $http({
		    	method: 'GET',
		    	url: '/' + SERVER_INSTANCE_NAME + '/api/notification/loadForView'
		    });		
		};	
		
		
		NotificationService.sendNotifications = function() {	
			return $http.post('/' + SERVER_INSTANCE_NAME + '/api/notification/sendNotifications');
		};
		
		
		NotificationService.loadDetail = function(parentNotificationId) {
		    return $http({
		    	method: 'GET',
		    	url: '/' + SERVER_INSTANCE_NAME + '/api/notification/loadDetail/' + parentNotificationId
		    });		
		};	
		
		NotificationService.getNotification = function(notificationId) {
		    return $http({
		    	method: 'GET',
		    	url: '/' + SERVER_INSTANCE_NAME + '/api/notification/getNotification/' + notificationId
		    });		
		};	
		
		return NotificationService;			
	});
		
	
	

})();	