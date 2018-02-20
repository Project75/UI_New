<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="dh-inner-header ng-scope" ng-show="ctrl.pageLoadComplete">
  <div class="row">	
	  <div class="col-md-12">	
		<ol class="breadcrumb pull-right">
		  	<li><a href="#!/">Home</a></li>
  			<li><a href="#!/mappings/mappingList">Mappings</a></li>
  			<li class="active">Mapping Detail</li>
		</ol>		
		<h1 class="ng-scope dh-page-header">Mapping Detail</h1>
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
				{{ctrl.mapping.name}}
			</dd>
		</div>
		<div class="col-sm-6">
			<dt>Status</dt>
			<dd>
				{{ctrl.mapping.status}}
			</dd>
		</div>
	</dl>
</div>
<div class="col-sm-12">
	<dl class="dl-horizontal" >
		<div class="col-sm-6">				
			<dt>Resources</dt>
			<dd>
				{{ctrl.mapping.resources}}
			</dd>
		</div>
		<!-- <div class="col-sm-6">
			<dt>Status</dt>
			<dd>
				{{ctrl.mapping.status}}
			</dd>
		</div> -->
	</dl>
</div>

<legend> Field Details </legend>
<div class="row">
	<div class="col-sm-12">
		<div class="table-responsive dh-table">
			<table tr-ng-grid="" locale="en" items="ctrl.fieldList" enable-filtering="false" order-by="ctrl.sortColumn"
				 order-by-reverse="ctrl.orderByReverse" selection-mode="None"  class="hide-footer table table-striped table-condensed">
				<thead>
					<tr>
						<th class="info" field-name="fieldName" display-name="Name"></th>
						<th class="info" field-name="staticValue" display-name="Use"></th>
						<th class="info" field-name="hl7Segment" display-name="HL7 Segment"></th>
						<th class="info" field-name="hl7Field"  display-name="HL7 Field"></th>
						<th class="info" field-name="isExtension"  display-name="User-Defined"></th>
					</tr>
				</thead>
                <tbody>
                    <tr>
                    	<td field-name="isExtension" >
                        	<span ng-show="{{gridItem.isExtension}}"> Y </span>
                        </td>
                    </tr>	       
                </tbody>	
			 </table>
		 </div>
	</div>
</div>



<div ng-show="! ctrl.pageLoadComplete">
    <span><img src="images/ajax-loader.gif" /></span>
</div>
