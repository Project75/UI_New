
//https://github.com/xebia/angularjs-tabs-and-lazy-data-loading
//http://blog.xebia.com/2013/08/28/bootstraps-tabs-and-lazy-data-loading-in-angularjs/
//Using  for supporting lazy data loading  in tabs, as by default any AngularJS provided tabs implementation doesnt provide lazy loading
fhirApp
.directive('mytabs', function () {
	  return {
		    restrict: 'E',
		    replace: true,
		    transclude: true,
		    scope: { 
		        currentTab: '@' // adding this to support opening a mentioned tab directly rather than manually 
				
		      },
		    controller: function($scope,$location) {
		      $scope.templateUrl = '';
		      var tabs = $scope.tabs = [];
		      var controller = this;

		      this.selectTab = function (tab) {
		        angular.forEach(tabs, function (tab) {
		          tab.selected = false;
		        });
		        tab.selected = true; 
				$scope.currentTab = tab.title;
		      };

		      this.setTabTemplate = function (templateUrl) {
		        $scope.templateUrl = templateUrl;
		      }

		      this.addTab = function (tab) {
				// making a tab selected as per the current-tab attribute ( rather than  setting  the first tab as selected tab)
		        if($scope.currentTab == tab.title){//if (tabs.length == 0) {
		          controller.selectTab(tab);
		        }
		        tabs.push(tab);
		      };
		      //Added new method to change the loaction so that selected tab can be reflected in URL
			  this.loadTab = function(tab){
				$location.path($location.path().substring(0,$location.path().lastIndexOf('/')+1)+tab.title);
			  }
		    },
		    template:
		      '<div class="row-fluid">' +
		        '<div class="row-fluid">' +
		          '<div class="nav nav-tabs" ng-transclude></div>' +
		        '</div>' +
		        '<div class="row-fluid">' +
		          '<ng-include src="templateUrl"></ng-include>' +
		        '</div>' +
		      '</div>'
		  };
})
.directive('mytab', function () {
	return {
		 restrict: 'E',
		 replace: true,
		 require: '^mytabs',
		 scope: {
		   glyphicon: '@',
		   title: '@',
		   templateUrl: '@'
		 },
		 link: function(scope, element, attrs, tabsetController) {
		   tabsetController.addTab(scope);
		   
		   scope.showGlyph = (scope.glyphicon) ? true : false;
		   //console.log("app.js:  " + scope.glyphicon + " - " + scope.showGlyph);		
		   
		   scope.select = function () {
			// tabsetController.selectTab(scope);
		     tabsetController.loadTab(scope);
		   }
		
		   scope.$watch('selected', function () {
		     if (scope.selected) {
		       tabsetController.setTabTemplate(scope.templateUrl);
		     }
		   });
		 },
		 template:
		   '<li ng-class="{active: selected}">' +
		     '<a href="" ng-click="select()"><span class="glyphicon glyphicon-{{glyphicon}}" ng-show="showGlyph" style="padding-right:8px;"></span>{{ title }}</a>' +
		   '</li>'
	};
});
