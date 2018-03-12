<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="margin-top:25px;" ng-controller="MappingStatusChangeModalCtrl as ctrl">
	
	<div ng-repeat="message in ctrl.messages" class="alert alert-success" role="alert">{{message}}  
		<span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
	</div>
	<div ng-repeat="error in ctrl.errors" class="alert alert-danger" role="alert">{{error}}
		<span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
	</div>
	
	<div class="modal-body">
		<h1 class="ng-scope fhir-page-header">Mapping - Change Status</h1>
		<div class="row">
			<dl class="dl-horizontal" >
				<div class="col-sm-12">				
					<dt>Mapping Name</dt>
					<dd>
						{{modalOptions.mapping.name}}
					</dd>
				</div>
			</dl>
		</div>
		
		<div class="row">
			<dl class="dl-horizontal" >
				<div class="col-sm-12">				
					<dt>Current Status</dt>
					<dd>
						{{modalOptions.mapping.status}}
					</dd>
				</div>
			</dl>
		</div>
		
		<div class="row">
			<dl class="dl-horizontal" >
				<div class="col-sm-12">				
					<dt>Target Status</dt>
					<dd>
						<select ng-model="ctrl.targetStatusCode" class="form-control" ng-change="ctrl.onFormChange()" id="targetStatusCode" name="targetStatusCode" 
							ng-show = "modalOptions.mapping.status == 'development' || modalOptions.mapping.status == 'Development'">
						    <option value="testing">Testing</option>
						</select>
						
						<select ng-model="ctrl.targetStatusCode" class="form-control" ng-change="ctrl.onFormChange()" id="targetStatusCode" name="targetStatusCode" 
							ng-show = "modalOptions.mapping.status == 'testing'">
						    <option value="development">Development</option>
						    <option value="reviewed">Reviewed</option>
						</select>
					
						<select ng-model="ctrl.targetStatusCode" class="form-control" ng-change="ctrl.onFormChange()" id="targetStatusCode" name="targetStatusCode" 
							ng-show = "modalOptions.mapping.status == 'Reviewed' || modalOptions.mapping.status == 'reviewed'">
							<option value="cancelled">Cancelled</option>
						    <option value="deployed">Deploy In Production</option>
						    <option value="onHold">On-hold</option>
						    <option value="testing">Testing</option>
						</select>
					
						<select ng-model="ctrl.targetStatusCode" class="form-control" ng-change="ctrl.onFormChange()" id="targetStatusCode" name="targetStatusCode" 
							ng-show = "modalOptions.mapping.status == 'onHold'">
						    <option value="cancelled">Cancelled</option>
						    <option value="development">Development</option>
						    <option value="reviewed">Reviewed</option>
						</select>
						
						<select ng-model="ctrl.targetStatusCode" class="form-control" ng-change="ctrl.onFormChange()" id="targetStatusCode" name="targetStatusCode" 
							ng-show = "modalOptions.mapping.status == 'deployed'">
						    <option value="suspended">Suspended</option>
						</select>
							
					</dd>
				</div>
			</dl>
		</div>

		
		<div class="row">&nbsp;
		</div>
		<div class="row">&nbsp;
		</div>
		
		<div class="row">
			<dl class="dl-horizontal" >
				<div class="col-sm-10 col-sm-offset-1">
				    			
				    <span ng-show="(ctrl.targetStatusCode == 'reviewed')">
				    	<span class="glyphicon glyphicon-warning"></span> 
						You are about to make the mapping as ready for production. Any further changes will not be allowed to it.  
						<br/>
						Click the check box below to acknowledge.
				    </span>				
				    <span ng-show="(ctrl.targetStatusCode == 'suspended')">
				    	<span class="glyphicon glyphicon-exclamation-sign alert-danger"></span>
						You are about to suspend the Mapping .It will be decommisioned from production environment. This action is not reversible.
						<br/>
						Click the check box below to acknowledge.				
				    </span>			
				    <span ng-show="(ctrl.targetStatusCode == 'deployed')">	
				    	<span class="glyphicon glyphicon-alert alert-danger"></span>
						You are about to promote Mapping .This will update the
						production inventory . This action is not reversible.						
						<br/>
						Click the checkbox below to acknowledge.
				    </span>				
				</div>
			</dl>
		</div>

		
		<div class="row">&nbsp;
		</div>
		
		<div class="row" ng-show="ctrl.acknowledgementRequired">
			<dl class="dl-horizontal" >
				<div class="col-sm-12">				
					<dt>Acknowledge</dt>
					<dd>
						<input type="checkbox" ng-model="ctrl.isAcknowledged" ng-change="ctrl.onFormChange()"/>
					</dd>
				</div>
			</dl>
		</div>

			        		    
    </div>
	<div class="modal-footer">
		 <span ng-show="ctrl.operationInProgress"><img src="images/ajax-loader.gif" /></span>
		 <button type="button" class="btn btn-danger" style="width:75px;" data-ng-click="ctrl.proceed(modalOptions)" ng-disabled="ctrl.proceedButtonDisabled">Proceed</button>
		 <button type="button" class="btn btn-secondary" style="width:75px;" data-ng-click="ctrl.cancel(modalOptions)">Close</button>
	</div>
</div>
