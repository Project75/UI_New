<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="dh-inner-header ng-scope">
	<div class="row">	
		<div class="col-md-12">	
			<ol class="breadcrumb pull-right">
				<li><a href="#!/">Home</a></li>
	 			<li>Mappings</li>
			</ol>
			<h1 class="ng-scope dh-page-header ">
		    	Mappings
			</h1>		
	  	</div>
	</div>	
</div>

<div ng-repeat="message in ctrl.messages" class="alert alert-success" role="alert">{{message}}  
	<span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
</div>
<div ng-repeat="error in ctrl.errors" class="alert alert-danger" role="alert">{{error}}
	<span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
</div>


<form class="form-horizontal" name="searchForm" novalidate>
	<div class="row">
	   <div class="form-group">
	            <div class="col-md-8">
	                <div class="fhir-right-inner-addon col-md-12">		
	                     <span class="glyphicon glyphicon-search"></span>
	                     <input name="searchStr" type="text" class="form-control" id="searchStr" placeholder="Search by name , type , message type, bundle Type and status " ng-maxlength="100"
	                         ng-model="ctrl.searchStr" ng-blur="ctrl.getListByFilter()" ng-pattern="ctrl.validCharactersRegex" ng-model-options="{debounce:500}" />
			   			<p class="help-block" ng-show="searchForm.searchStr.$error.pattern">Search String Invalid</p>
			   			<p class="help-block" ng-show="searchForm.searchStr.$error.maxlength">Max length exceeded</p>
		   			</div>
                </div>
                <div class="col-md-2"></div>
				<div class="col-md-2">	
					<div class="col-md-12">
					<div class="fhir-right-justify pull-right">
					 <p> <a href="" ng-click="ctrl.addNewMapping()" role="button" class="btn btn-secondary"> 
							    <span class="glyphicon glyphicon-plus"></span> Add Mapping</a>
					 </p>	
	        		</div>
	        		</div> 
       			</div>   
       			
       		</div>  
    </div><!--  end row -->
</form>

<script>document.getElementById('searchStr').focus();</script>


<!-- <div class="row">
	<div class="col-sm-10"></div>
	<div class="col-sm-2">
		<p>	
			<a href="" ng-click="ctrl.addNewMapping()" role="button" class="btn btn-secondary"> 
			    <span class="glyphicon glyphicon-plus"></span> Add Mapping</a>
		</p>
	</div>
</div> -->

<div ng-show="ctrl.pageLoadComplete">			
	<div ng-hide="(ctrl.mappingList.length > 0)">No results to show</div>		
    <div class="col-sm-12" ng-show="ctrl.mappingList.length > 0">
	    <div class="table-responsive dh-table">
			<table tr-ng-grid="" locale="en" items="ctrl.mappingList" enable-filtering="false" order-by="ctrl.sortColumn"
				 order-by-reverse="ctrl.orderByReverse" selection-mode="None"  class="hide-footer table table-striped table-condensed">
				<thead>
					<tr>
						<th class="info" field-name="name" display-name="Name" enable-filtering="false"></th>
						<th class="info" field-name="status" display-name="Status" enable-filtering="false"></th>
						<th class="info" field-name="mappingType" display-name="Type" enable-filtering="false"></th>
						<th class="info" field-name="messageType" display-name="Message Type" enable-filtering="false"></th>
						<th class="info" field-name="referenceUrlOptions" display-name="Reference URL Option" enable-filtering="false"></th>
						<th class="info" field-name="resourceCreationRules" display-name="Resource Creation Rule" enable-filtering="false"></th>
						<th class="info" field-name="resources" display-name="Resources" enable-filtering="false"></th>
						<th class="info" field-name="additionalNotes" display-name="Additional Notes" enable-filtering="false"></th>
						<th class="info" field-name="action" display-name="Action" enable-filtering="false" style='white-space: nowrap'></th>
					</tr>
				</thead>
				<tbody>
				    <tr>
						<td data-label="Name" field-name="name">
						 	<a href="" ng-click="ctrl.goToDetail(gridItem.id)">
							   	<span>{{gridItem.name}}</span>
							</a>
						</td>				
						
						<td field-name="additionalNotes">
						  <div data-toggle="tooltip" tooltip-placement="top" uib-tooltip="{{gridItem.additionalNotes}}">
                         	 <span ng-show="gridItem.additionalNotes != null" title="{{gridItem.noteadditionalNotes}}" class="glyphicon glyphicon-asterisk"></span>
                          </div>
                        </td>
                        <td field-name="action"  style='white-space: nowrap'>
                        	<div>
                        		<a href="" ng-click="ctrl.edit(gridItem.id)" role="button" class="btn btn-warning" ng-show ="gridItem.status == 'Development' || gridItem.status == 'Testing'">
                        			<div data-toggle="tooltip" tooltip-placement="top" uib-tooltip="Edit"><span class="glyphicon glyphicon-pencil"></span></div>
                        		</a>
                        		<a href="" ng-hide ="gridItem.status == 'Development' || gridItem.status == 'Testing'">
                        		</a>
                        		<a href="" ng-click="ctrl.deleteConfirmationDialog(gridItem)" role="button" class="btn btn-danger">
                        			<div data-toggle="tooltip" tooltip-placement="top" uib-tooltip="Delete"><span class="glyphicon glyphicon-trash"></span></div>
                        		</a>
                        		 <span ng-show="gridItem.operationInProgress"><img src="images/ajax-loader.gif" /></span>
	                        </div>  
                        </td>
				    </tr>
				</tbody>
		  </table>
        </div>
    </div>
	
</div>
<div ng-show="!ctrl.pageLoadComplete">
	 <span><img src="images/ajax-loader.gif" /></span>
</div>
