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


<div class="row">
	<div class="col-sm-10"></div>
	<div class="col-sm-2">
		<p>	
			<a href="" ng-click="ctrl.addNewMapping()" role="button" class="btn btn-secondary"> 
			    <span class="glyphicon glyphicon-plus"></span> Add Mapping</a>
		</p>
	</div>
</div>

<div>			
	<div ng-hide="(ctrl.mappingList.length > 0)">No Results</div>		
    <div class="col-sm-12" ng-show="ctrl.mappingList.length > 0">
	    <div class="table-responsive dh-table">
			<table tr-ng-grid="" locale="en" items="ctrl.mappingList" enable-filtering="false" order-by="ctrl.sortColumn"
				 order-by-reverse="ctrl.orderByReverse" selection-mode="None"  class="hide-footer table table-striped table-condensed">
				<thead>
					<tr>
						<th class="info" field-name="name" display-name="Name" enable-filtering="false"></th>
						<th class="info" field-name="status" display-name="Status" enable-filtering="false"></th>
						<th class="info" field-name="percentCompletion" display-name="Percent Completion" enable-filtering="false"></th>
						<th class="info" field-name="assignedTo" display-name="Assigned To" enable-filtering="false"></th>
						<th class="info" field-name="note" display-name="Additional Notes" enable-filtering="false"></th>
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
						
						<td field-name="note">
						  <div data-toggle="tooltip" tooltip-placement="top" uib-tooltip="{{gridItem.note}}">
                         	 <span ng-show="gridItem.note != null" title="{{gridItem.note}}" class="glyphicon glyphicon-asterisk"></span>
                          </div>
                        </td>
                        <td field-name="action"  style='white-space: nowrap'>
                        	<div class="btn-group">
                        		<div>
	                        		<a href="" ng-click="ctrl.edit(gridItem.id)" role="button" class="btn btn-warning">
	                        			<div data-toggle="tooltip" tooltip-placement="top" uib-tooltip="Edit"><span class="glyphicon glyphicon-pencil"></span></div>
	                        		</a>
                        		</div>
                        		<div>
	                        		<a href="" ng-click="ctrl.delete(gridItem.id)" role="button" class="btn btn-danger">
	                        			<div data-toggle="tooltip" tooltip-placement="top" uib-tooltip="Delete"><span class="glyphicon glyphicon-trash"></span></div>
	                        		</a>
	                        	</div>	
	                        </div>  
                        </td>
				    </tr>
				</tbody>
		  </table>
        </div>
    </div>
	
</div>	
