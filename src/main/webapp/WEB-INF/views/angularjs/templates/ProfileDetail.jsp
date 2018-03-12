<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="dh-inner-header ng-scope" ng-show="ctrl.pageLoadComplete">
  <div class="row">	
	  <div class="col-md-12">	
		<ol class="breadcrumb pull-right">
		  	<li><a href="#!/">Home</a></li>
  			<li><a href="#!/profiles/profileList">Profiles</a></li>
  			<li class="active">Profile Detail</li>
		</ol>		
		<h1 class="ng-scope dh-page-header">Profile Detail</h1>
	  </div>
  </div>
</div>

<br/>


<legend> General Details </legend>
<div class="col-sm-12">
	<dl class="dl-horizontal" >
		<div class="col-sm-6">				
			<dt>Name</dt>
			<dd>
				{{ctrl.profile.profileName}}
			</dd>
		</div>
		<!-- <div class="col-sm-6">
			<dt>Status</dt>
			<dd>
				{{ctrl.profile.status}}
			</dd>
		</div> -->
	</dl>
</div>

<legend> Field Details </legend>
<div class="row">
	<div class="col-sm-12">
		<div class="table-responsive fhir-table">
			<table tr-ng-grid="" locale="en" items="ctrl.profile.fieldList" enable-filtering="false" order-by="ctrl.sortColumn" page-items="10"
				 order-by-reverse="ctrl.orderByReverse" selection-mode="None"  class="hide-footer table table-striped table-condensed">
				<thead>
					<tr>
						<th class="info" field-name="fieldName" display-name="Name"></th>
						<th class="info" field-name="isRequired" display-name="Mandatory Field"></th>
						<th class="info" field-name="isExtension"  display-name="Custom Field"></th>
					</tr>
				</thead>
                <tbody>
                    <tr>
                    	<td field-name="isRequired" >
                        	<span ng-show="{{gridItem.isRequired}}" class="glyphicon glyphicon-asterisk"></span>
                        </td>
                        <td field-name="isExtension" >
                        	<span ng-show="{{gridItem.isExtension}}"> Y </span>
                        </td>
                    </tr>	       
                </tbody>	
			 </table>
		 </div>
	</div>
</div>

<div class="row">
	<div class="col-md-12 fhir-form-buttons">
	  	<div class="form-group">
			<div class="col-md-offset-10 col-md-2">			
				<button type="button" class="btn btn-primary" ng-click="ctrl.edit()">Edit</button>
				<button type="button" class="btn btn-default" ng-click="ctrl.go('/profiles/profileList')">Cancel</button>
			</div>
		</div>
	</div>		
</div>

<div ng-show="! ctrl.pageLoadComplete">
    <span><img src="images/ajax-loader.gif" /></span>
</div>
