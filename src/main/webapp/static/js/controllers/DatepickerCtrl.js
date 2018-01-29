(function(){
	
	function DatepickerCtrl($scope) {
		
		var vm = this;
		vm.dateRegex = /^(\d{4})-(\d{2})-(\d{2})$/;
		vm.initDate = new Date('03/24/2016');
		vm.formats = [ 'M!/d!/yyyy', 'd!-MMMM-yyyy',
						'd!.M!.yyyy', 'shortDate' ];
		vm.format = vm.formats[0];
		vm.isOpen = false;

		vm.today = function() {
			vm.dt = new Date();
		};
			
		vm.today();

		vm.clear = function() {
			vm.dt = null;
		};

		// Disable weekend selection
		vm.disabled = function(date, mode) {
			return (mode === 'day' && (date.getDay() === 0 || date
					.getDay() === 6));
		};

		
		vm.toggleMin = function() {
			vm.minDate = vm.minDate ? null : new Date();
		};
		vm.toggleMin();

		vm.open = function($event) {
			$event.preventDefault();
			$event.stopPropagation();

			vm.isOpen = true;
		};
	    vm.dateOptions = {
				formatYear : 'yy',
				startingDay : 1,
				showWeeks : false
		};
	}
	
	angular.module('fhirApp').controller('DatepickerCtrl', DatepickerCtrl);	
	
	
})();	