<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="dh-inner-header ng-scope">
	<div class="row">	
		<div class="col-md-12">	
			<ol class="breadcrumb pull-right">
				<li><a href="#!/">Home</a></li>
	 			<li >Profiles</li>
			</ol>
			<h1 class="ng-scope dh-page-header ">
		    	Profiles
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


<div ng-show="ctrl.pageLoadComplete">			
	<div ng-hide="(ctrl.profileList.length > 0)">No Results</div>
		
    <div class="col-sm-12" ng-show="ctrl.profileList.length > 0">
	    <div class="table-responsive dh-table">
			<table tr-ng-grid="" locale="en" items="ctrl.profileList" enable-filtering="false" order-by="ctrl.sortColumn"
				 order-by-reverse="ctrl.orderByReverse" selection-mode="None"  class="hide-footer table table-striped table-condensed">
				<thead>
					<tr>
						<th class="info" field-name="profileName" display-name="Name" enable-filtering="false"></th>
					</tr>
				</thead>
				<tbody>
				    <tr>
						<td data-label="Name" field-name="profileName">
						 	<a href="" ng-click="ctrl.goToDetail(gridItem.id)">
							   	<span>{{gridItem.profileName}}</span>
							</a>
						</td>
				    </tr>
				</tbody>
		  </table>
        </div>
    </div>
	
</div>	
