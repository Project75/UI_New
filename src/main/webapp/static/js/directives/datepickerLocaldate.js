//based on information from: http://stackoverflow.com/questions/22623872/angular-ui-datepicker-adjusting-for-timezone

    fhirApp.directive('datepickerlocaldate', ['$parse', function ($parse) {
        var directive = {
            restrict: 'A',
            require: ['ngModel'],
            link: link
        };
        return directive;

        function link(scope, element, attr, ctrls) {
            var ngModelController = ctrls[0];

            // called with a JavaScript Date object when picked from the datepicker
            ngModelController.$parsers.push(function (viewValue) {
        		//console.log("datepickerLocaldate.js:  $parsers.push(" + viewValue + ")");

                if (!viewValue) {
                    return "";
                }
                
        		ngModelController.$setValidity('valid', true);
        		ngModelController.$setValidity('pattern', true);
        		ngModelController.$setValidity('dateRange', true);

        		var strict = (viewValue.length <= 10);
        		var m = moment(viewValue, ['M/D/YYYY', 'M-D-YYYY', 
        		                       'dddd MMMM D YYYY'], strict);	        		

                if (m.isValid()) {
                    var d = Date.parse(viewValue);
                    var earliestDate = new Date('1899-12-31');
                    var currentDate = new Date();
                	                	
                	if (d < earliestDate) {
                		//console.log("datepickerLocaldate.js:  earliestDate check failed - " + d + "  value");
                		ngModelController.$setValidity('dateRange', false);
                	} else if ((ngModelController.$name === 'birthDate') && (d > currentDate)) {
                		///console.log("datepickerLocaldate.js:  currentDate check failed - " + d + "  value");
                		ngModelController.$setValidity('dateRange', false);
                	} else if (attr.greaterthancurrentdate && (d < currentDate)){
						//console.log("datepickerLocaldate.js:  greater than current date check failed - " + d + "  value");
						ngModelController.$setValidity('dateRange', false);
					} else if (attr.lessthancurrentdate && (d > currentDate)){
						//console.log("datepickerLocaldate.js:  less than current date check failed - " + d + "  value");
						ngModelController.$setValidity('dateRange', false);
					} else if (moment(d).year() > 9999){
						ngModelController.$setValidity('dateRange', false);
					} else {
						//console.log("datepickerLocaldate.js:  all passed");
					}
                } else {
            		console.log("datepickerlocaldate:  date check failed - " + d + " - " + viewValue);
            		ngModelController.$setValidity('pattern', false);
                }
                
                return viewValue.toISOString();
            });

            // called with a 'yyyy-mm-dd' string to format
            ngModelController.$formatters.push(function (modelValue) {
        		//console.log("datepickerLocaldate.js:  $formatters.push(" + modelValue + ")");

                if (!modelValue) {
                    return undefined;
                }
                
                // date constructor will apply timezone deviations from UTC (i.e. if locale is behind UTC 'dt' will be one day behind)
                var dt = new Date(modelValue);
                return (dt.getMonth() + 1) + "/" + dt.getDate() + "/" + dt.getFullYear();
            });
        }
    }]);