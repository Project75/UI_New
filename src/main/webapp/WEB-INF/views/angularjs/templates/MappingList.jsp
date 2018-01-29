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
			<a href="" ng-click="ctrl.addNewMapping('seq')" role="button" class="btn btn-secondary"> 
			    <span class="glyphicon glyphicon-plus"></span> Add Mapping</a>
		</p>
	</div>
</div>

<div>			
	<div ng-hide="(ctrl.mappingList.length > 0)">No Results</div>	
	<div class="row" ng-show="ctrl.mappingList.length > 0">
	    <div style="margin-top:10px;">	    
			<div class="col-sm-10">
		         <span ng-show="ctrl.totalCount > ctrl.mappingList.length">{{ctrl.mappingList.length}} of {{ctrl.totalCount}} displayed</span>
			</div>
		</div>
	</div>	
		
    <div class="col-sm-12" ng-show="ctrl.mappingList.length > 0">
	    <div class="table-responsive dh-table"> 
	    
			<table tr-ng-grid="" locale="en" items="ctrl.mappingList"
			    page-items="ctrl.pageItems" on-data-required="ctrl.onServerSideItemsRequested(currentPage, pageItems, orderBy, orderByReverse,ctrl.filterText,true)"
                   total-items="ctrl.totalCount" selected-items="ctrl.selectedItems"				 	
				selection-mode="SingleRow" class="table table-striped table-condensed" enable-filtering="false" order-by="ctrl.sortColumn" order-by-reverse="ctrl.orderByReverse">
				<thead>
					<tr>
						<th class="info" field-name="name" display-name="Name" enable-filtering="false"></th>
						<th class="info" field-name="type.name" display-name="Type" enable-filtering="false" style="width:150px;" ng-show="ctrl.mode != 'requirement'"></th>
						<th class="info" field-name="providerName" display-name="Provider" enable-filtering="false" style="width:100px;" ng-show="ctrl.mode != 'requirement'"></th>
						<th class="info" field-name="durationShortDisplay" display-name="Duration" enable-filtering="false" style="width:150px;" ></th>
						<th class="info" field-name="versionNo" display-name="Version #" enable-filtering="false" style="width:100px;" ></th>
						<th class="info" field-name="status.name" display-name="Status" enable-filtering="false" style="width:100px;"></th>
						<th class="info" field-name="externalSystemDataId" display-name="Linked?" enable-filtering="false" style="width:100px;" title="Linked to MyJourney" ng-hide="ctrl.mode == 'requirement'"></th>
						<th class="info" field-name="owner" display-name="Owner" enable-filtering="false" style="width:100px;" ng-show="ctrl.mode == 'requirement'"></th>
						<th class="info" field-name="note" display-name="Notes" enable-filtering="false" style="width:75px;"></th>
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
                         	 <span ng-show="gridItem.hasNote" title="{{gridItem.note}}" class="glyphicon glyphicon-asterisk"></span>
                          </div>
                        </td>
				    </tr>
				</tbody>
		  </table>
        </div>
    </div>
	
</div>	
