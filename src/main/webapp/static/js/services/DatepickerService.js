(function(){
	
	angular.module('fhirApp').factory('DatepickerService', function DatepickerService(){
		
		var DatepickerService = {};
		
		DatepickerService.localTimezoneOffset = new Date().toString().match(/([-\+][0-9]+)\s/)[1];
		DatepickerService.localTimezoneOffset = DatepickerService.localTimezoneOffset.substring(0,3) + ":" + DatepickerService.localTimezoneOffset.substring(3,5);

        DatepickerService.parseForUI = function(dateStr, returnNullIfEmpty){
            returnNullIfEmpty = typeof returnNullIfEmpty !== 'undefined' ? returnNullIfEmpty : true;
            var date;

            if ((dateStr != null) && (dateStr.length > 0)) {
                date = moment(dateStr, 'YYYYMMDD').hour(12);
                date = date.toDate();
            } else if(!returnNullIfEmpty){
                date = moment(new Date()).hour(12);
                date = date.toDate();
            }

            return date;
        };
				
		DatepickerService.formatForWeb = function(date){
			var formattedDate = moment(date).format("YYYYMMDD");
	        return formattedDate;
		};
		
		return DatepickerService;
		
	});
		

})();	