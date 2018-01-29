(function(){
	angular.module('fhirApp').factory('ModalService',function ModalService($uibModal){
		var ModalService = {};
		
		var modalDefaults = {
            backdrop: true,
            keyboard: true,
            modalFade: true
			
        };

        var modalOptions = {
            closeButtonText: 'Close',
            hasCloseButton: true,
            actionButtonText: 'OK',
            hasActionButton: true,
            headerText: 'Proceed?',
            bodyText: 'Perform this action?'
        };
        
        var customModalOptions = null;
        
        
        ModalService.getCustomModalOptions = function() {
        	return ModalService.customModalOptions;
        }

        ModalService.showModal = function (customModalDefaults, customModalOptions) {
            if (!customModalDefaults) customModalDefaults = {};
            customModalDefaults.backdrop = 'static';
            return this.show(customModalDefaults, customModalOptions);
        };
		
		ModalService.show = function (customModalDefaults, customModalOptions) {
			ModalService.customModalOptions = customModalOptions;
			
            //Create temp objects to work with since we're in a singleton service
            var tempModalDefaults = {};
            var tempModalOptions = {};

            //Map angular-ui modal custom defaults to modal defaults defined in service
            angular.extend(tempModalDefaults, modalDefaults, customModalDefaults);

            //Map modal.html $scope custom properties to defaults defined in service
            angular.extend(tempModalOptions, modalOptions, customModalOptions);

            if (!tempModalDefaults.controller) {
                tempModalDefaults.controller = function ($scope, $uibModalInstance) {
                    $scope.modalOptions = tempModalOptions;
                    $scope.modalOptions.ok = function (result) {
                        $uibModalInstance.close(result);
                    };
                    $scope.modalOptions.close = function (result) {
                        $uibModalInstance.dismiss('cancel');
                    };
                }
            }

            return $uibModal.open(tempModalDefaults).result;
        };
		
		return ModalService;
		
	});
})();	