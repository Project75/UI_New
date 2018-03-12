<div style="margin-top:25px;" ng-controller="AddMappingCtrl as ctrl">
	
<div ng-repeat="message in ctrl.messages" class="alert alert-success" role="alert">{{message}}  
    <span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
</div>
<div ng-repeat="error in ctrl.errors" class="alert alert-danger" role="alert">{{error}}
    <span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
</div>
  
  <div class="modal-body">
   <form role="form" class="form-horizontal" name="form" novalidate>
	<h1 class="ng-scope fhir-page-header">Select Fields</h1>
	<div ng-repeat="gridItem in modalOptions.optionalFieldList track by $index">
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
				<div class="col-sm-8">
					<label><input type="checkbox" ng-model="gridItem.isSelected" ng-change ="ctrl.selectOptionalField()">&nbsp;&nbsp;&nbsp;&nbsp;{{gridItem.fieldName}}</label>
				</div>
				</div>
			</div>
		</div>
	
	</div>
	
  </form>
 </div>
    
 <div class="modal-footer">
   <button type="button" class="btn btn-primary" data-ng-click="ctrl.proceed(modalOptions)">Proceed</button>
   <button type="button" class="btn btn-default" data-ng-click="ctrl.cancel(modalOptions)">Cancel</button>
 </div>
    
</div>
