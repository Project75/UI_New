(function(){
	
	function HomeCtrl($scope, $route, $location, $rootScope, NotificationService, ErrorHandlerService) {
		
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
		
		
			
		vm.init = function() {
			
		}
		
		vm.init();
		
		
	}
	
	angular.module('fhirApp').controller('HomeCtrl', HomeCtrl);	
	
})();