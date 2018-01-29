(function(){
	
	function HeaderCtrl($scope, $route, $location, $rootScope, NotificationService, ErrorHandlerService){
		var vm = this;
		vm.messages = NotificationService.messages;
		vm.errors = NotificationService.errors;
		NotificationService.reset();
	
		vm.userName = "Test USer";
		
		
	    
				
	    vm.isActive = function (viewLocation) { 
	        var s = false;
	        
	        if ($location.path().indexOf(viewLocation) == 0) {
	           s = true;
	        }
	       
	        return s;
	    };		
	    
	    vm.goBack = function (){
	    	window.history.back();	    	
	    };
	    
		vm.go = function(path){
			$location.path( path );
		};
	}
	
	angular.module('fhirApp').controller('HeaderCtrl', HeaderCtrl);	
	
})();	