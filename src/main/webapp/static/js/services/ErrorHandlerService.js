(function(){
	
	angular.module('fhirApp').factory('ErrorHandlerService', function ErrorHandlerService(){
		
		
		var ErrorHandlerService = {};			
				
		ErrorHandlerService.handleError = function(response, vmErrorsArray, message) {
			console.log("ErrorHandlerService:  status [" + response.status + "]  message [" + message + "]");
				
			if (response.status == 401) {
				window.location = '/' + SERVER_INSTANCE_NAME;		
			} else {
				vmErrorsArray.push(message + ": " + response.status);
			}	
		};						

		
		return ErrorHandlerService;	
			
	});

})();	