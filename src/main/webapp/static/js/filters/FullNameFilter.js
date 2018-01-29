(function(){
	
	
	function FullNameFilter(){
	    return function (item) {
	        return item.firstName + " " + item.lastName;
	    	//return item.lastName + ", " + item.firstName ;	    		


	    };

	};
	

	
	angular.module('fhirApp').filter('FullNameFilter', FullNameFilter);	
	
})();	