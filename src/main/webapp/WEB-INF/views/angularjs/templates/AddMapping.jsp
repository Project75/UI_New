<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="fhir-inner-header ng-scope">
  <div class="row">	
	  <div class="col-md-12">	
		<ol class="breadcrumb pull-right">
		  	<li><a href="#!/">Home</a></li>
		  	<li><a href="#!/mappings/mappingList">Mappings</a></li>
  			<li class="active">Add Mapping</li>
		</ol>		
		<h1 class="ng-scope fhir-page-header">Add Mapping</h1>
	  </div>
  </div>
</div>

<div ng-repeat="message in ctrl.messages" class="alert alert-success" role="alert">{{message}}</div>
<div ng-repeat="error in ctrl.errors" class="alert alert-danger" role="alert">{{error}}</div>  

<div id="optionSelectionDiv" ng-show ="ctrl.showMappingInitialScreen">
 <form role="form" class="form-horizontal" name="addMappingInitForm" novalidate>
	
	<div class="row form-group">
		<div class="col-sm-6">
           <label><h5> &nbsp;&nbsp;Create a new mapping &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></label>
           	<input type ="radio"  name="radioGroup_mappingChoice" ng-model="ctrl.option" ng-checked="true" value="newMapping" ng-change="ctrl.onRadioChange()"/>	
        </div>
        <div class="col-sm-6">
           <label><h5>&nbsp;&nbsp;Copy from an existing mapping&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></label>
           	<input type ="radio"  name="radioGroup_mappingChoice" ng-model="ctrl.option" value="existingMapping" ng-change="ctrl.onRadioChange()" />
    	</div>
	</div>
		
	 <div class="row">
        <div class="col-sm-4">
            <div class="form-group" show-errors>						
				<label for="mappingName" class="col-sm-2 control-label">Mapping Name*</label> 
				<div class="col-sm-10">
	                <input name='mappingName' type="text" class="form-control" id="mappingName" maxlength="100" ng-model="ctrl.mapping.mappingName" required>
			   		<p class="help-block" ng-show="addMappingInitForm.mappingName.$error.maxlength">Max Length Exceeded</p>
			   		<p class="help-block" ng-show="addMappingInitForm.mappingName.$error.required">Name is required</p>
	        	</div>				
        	</div>
    	</div>	       
	 
       <div class="col-sm-4" ng-show="ctrl.option=='newMapping'">
			<div class="form-group" show-errors>
				<label for="baseProfile" class="col-sm-2 control-label">Base Profile*</label>
				<div class="col-sm-10">
				<select ng-model="ctrl.mapping.baseProfileTypeId" class="form-control" ng-options="baseProfile.id as baseProfile.profileName for baseProfile in ctrl.baseProfileList" 
                         id="baseProfile" name="baseProfile" ng-required="ctrl.option=='newMapping'">
                </select>
                <p class="help-block" ng-show="addMappingInitForm.baseProfile.$error.required">Base Profile is required</p>	
                </div>			
			</div>
	   </div>
		
	   <div class="col-sm-4" ng-show="ctrl.option=='newMapping'">
			<div class="form-group" show-errors>
				<label for="resourceType" class="col-sm-2 control-label" ng-hide="ctrl.emptyResourceType">Resource Type(s)*</label>
                <label for="resourceType" class="col-sm-2 control-label text-danger" ng-show="ctrl.emptyResourceType">Resource Type(s)*</label>
				<div class="col-md-10">
					<div 
                      	  isteven-multi-select 
                          input-model="ctrl.resourceTypeList"
					      output-model="ctrl.mapping.selectedResources"
                          item-label="name"
                          button-label="name"
                          tick-property="isSelected"
                          on-item-click="ctrl.onResourceTypeSelection()" 
                          class="fhir-isteven-multi-select-error" 
                          ng-show="ctrl.emptyResourceType">  								
					</div> 
					<div
					    isteven-multi-select
					    input-model="ctrl.resourceTypeList"
					    output-model="ctrl.mapping.selectedResources"
					    button-label="name"
					    item-label="name"
					    tick-property="isSelected"
					    on-item-click="ctrl.onResourceTypeSelection()"
					    ng-hide="ctrl.emptyResourceType" 				    
					>
					<span ng-show="ctrl.emptyResourceType" class="text-danger">Choose at least one resource type </span>
					</div>					
				</div>
			</div>
		</div>
		<div class="col-sm-6" ng-show="ctrl.option=='existingMapping'">
			<div class="form-group" show-errors>
				<label for="copiedProfileId" class="col-md-4 control-label">Existing Mapping To Clone*</label>
				<div class="col-sm-10">
				<select ng-model="ctrl.mapping.copiedProfileId" class="form-control" ng-options="profile.id as profile.name for profile in ctrl.existingMappingsList" 
                         id="copiedProfileId" name="copiedProfileId" ng-required="ctrl.option=='existingMapping'">
                </select>
                <p class="help-block" ng-show="addMappingForm.copiedProfileId.$error.required">Existing profile is required to clone</p>	
                </div>			
			</div>
		</div>
    </div> <!-- End  -->
    
    <div class="row">
		<div class="col-md-12 dh-form-buttons">
		  	<div class="form-group">
				<div class="col-md-offset-10 col-md-2">			
					<button type="button" class="btn btn-primary" ng-click="ctrl.proceedAdd()">Proceed</button>
					<button type="button" class="btn btn-default" ng-click="ctrl.go('/mappings/mappingList')">Cancel</button>
				</div>
			</div>
		</div>		
	</div>
</form>    
    <!-- All the meta data fields overhere + option for seuqntial / categorized view -->
	
 </div><!-- End of option selection Div -->
 
 <div ng-show="!ctrl.showMappingInitialScreen">
	 <div class="row">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
			  <p>	
				 <a href="" ng-click="ctrl.changeView('cat')" role="button" class="btn btn-warning" ng-show="ctrl.isSequentialView"><span class="glyphicon glyphicon-th-list"></span> </a>
				 <a href="" ng-click="ctrl.changeView('cat')" role="button" class="btn btn-primary" ng-show="!ctrl.isSequentialView"><span class="glyphicon glyphicon-th-list"></span> </a>
			     <a href="" ng-click="ctrl.changeView('seq')" role="button" class="btn btn-warning" ng-show="!ctrl.isSequentialView"><span class="glyphicon glyphicon-th-large"></span> </a>
			     <a href="" ng-click="ctrl.changeView('seq')" role="button" class="btn btn-primary" ng-show="ctrl.isSequentialView"><span class="glyphicon glyphicon-th-large"></span> </a>
			  </p>	
			</div>
		</div>
	 
	 <div class="row">  <!--  Common progress bar -->
		<div class="col-sm-10"></div>
		<div class="col-sm-2">
			<uib-progressbar max="max" animate="false" value="ctrl.progressPercentage" type={{ctrl.type}}>
				<span style="color: #170404;white-space:nowrap;"> &nbsp;&nbsp;&nbsp;&nbsp;{{ctrl.mandatoryCompletedFields.length}} / {{ctrl.mandatoryFieldList.length}}  Fields Mapped</span>
			</uib-progressbar>
		</div>	 
	</div>
</div> 

<form role="form" class="form-horizontal" name="addMappingForm" novalidate>
<div ng-show="! ctrl.pageLoadComplete">
    <span><img src="/${serverInstanceName}/images/ajax-loader.gif" /></span>
</div>	
 <div id="sequentialDiv" ng-show="ctrl.isSequentialView && !ctrl.showMappingInitialScreen && ctrl.pageLoadComplete">
 	<div ng-repeat="gridItem in ctrl.fieldList track by $index">
		 <ng-form name="fieldForm">
       	 	<div class="row">
		        <div class="col-sm-4">	
					<div class="form-group">
						<label for="fieldName" class="col-sm-4 control-label">Field</label>
						<div class="col-md-8">
							 <input type="text" class="form-control" ng-model="gridItem.fieldName" ng-disabled="!gridItem.isCustomField" ng-change="ctrl.onFieldNameChange(gridItem)"/>
					    </div>
					</div>
				</div>
				
				<div class="col-sm-3">	
					<div class="form-group" show-errors>
						<label for="hl7Segment" class="col-sm-4 control-label" ng-show="!gridItem.isRequired">HL7 Segment</label>
						<label for="hl7Segment" class="col-sm-4 control-label" ng-show="gridItem.isRequired">HL7 Segment*</label>
						<div class="col-md-8"> 
						<select ng-model="gridItem.hl7Segment" ng-options="segment.segmentName for segment in ctrl.segmentList"  
									class="form-control" id="segment" name="segment"  ng-change="ctrl.onSegmentChange(gridItem)" ng-required="ctrl.isSequentialView && (gridItem.isRequired ||gridItem.isNowRequired)">	
								 <option value="">--Select Segment--</option>						  
						</select>
						<p class="help-block" ng-show="fieldForm.segment.$error.required">HL7 Segment is required</p>										
						</div>
					</div>
				</div>
				
				<div class="col-sm-3">	
					<div class="form-group" show-errors>
						<label for="field" class="col-sm-4 control-label" ng-show="!gridItem.isRequired">HL7 Field</label>
						<label for="field" class="col-sm-4 control-label" ng-show="gridItem.isRequired">HL7 Field*</label>
						<div class="col-md-8"> 
						<select ng-model="gridItem.hl7Field" ng-options="field.fieldName for field in gridItem.hl7fieldList"  
									class="form-control" id="field" name="field" ng-required="ctrl.isSequentialView && (gridItem.isRequired ||gridItem.isNowRequired)"
									ng-change="ctrl.calculateProgress(gridItem)" >	
								 <option value="">--Select Field--</option>						  
						</select>
						<p class="help-block" ng-show="fieldForm.field.$error.required">HL7 Field is required</p>										
						</div>
					</div>
				</div>
				
				<div class="col-sm-1" ng-show="gridItem.isRepetitive">
					<p><a href="" ng-click="ctrl.addOccurrence(gridItem)" role="button" class="btn btn-secondary" ng-disabled="gridItem.totalOccurences >= 10">
					    <span class="glyphicon glyphicon-plus" style="color:blue"></span></a></p>
				</div>
				<div class="col-sm-1" ng-show="gridItem.showRemoveButton">
					<p><a href="" ng-click="ctrl.removeOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-remove" style="color:red"></span></a></p>
				</div>				
				<!-- <div class="col-sm-2" ng-show="gridItem.isRepetitive">
					<div class="form-group" show-errors>
					<label for="repetitions" class="col-md-4 control-label">Repetitions</label>
				 	<div class="col-md-8">
				 		<input name="repetitions" type="number" class="form-control" id="repetitions" ng-model="gridItem.totalOccurences" 
							       ng-min="gridItem.noOfMinOccurences"  ng-max ="10"  ng-change = "ctrl.addOccurrence(gridItem)"/>
						<p class="help-block" ng-show="fieldForm.repetitions.$error.max">Please enter value between 1 to 10</p>
                   		<p class="help-block" ng-show="fieldForm.repetitions.$error.min">Please enter value between 1 to 10</p>
                   	</div>
					</div>
			   </div> -->
								
			</div>
			</ng-form>
       	 </div> <!--  End of repetition -->
       	 
       	 <div class="row">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
				<p><a href="" ng-click="ctrl.addCustomField()" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-plus"></span> Add Custom Field</a>
				</p>
			</div>
		</div>
 	
 </div> <!-- Sequential Div ending -->
 
 <div id="categorizedDiv" ng-show="!ctrl.isSequentialView">
 
  <div class="row">	
   <uib-accordion close-others="true">
	<div ng-repeat="fieldType in ctrl.fieldTypes">	   
	   <div uib-accordion-group class="panel-default" is-open="fieldType.IsOpened" >
        <uib-accordion-heading>
         	{{fieldType.name}}<i class="pull-right glyphicon" ng-class="{'glyphicon-chevron-down': status.open, 'glyphicon-chevron-right': !status.open}"></i>
     	</uib-accordion-heading>
 		<div ng-repeat="gridItem in ctrl.fieldList track by $index">
		 <ng-form name="fieldForm">
       	 	<div class="row">
		        <div class="col-sm-4">	
					<div class="form-group">
						<label for="fieldName" class="col-sm-4 control-label">Field</label>
						<div class="col-md-8">
							 <input type="text" class="form-control" ng-model="gridItem.fieldName" ng-disabled="!gridItem.isCustomField" ng-change="ctrl.onFieldNameChange(gridItem)"/>
					    </div>
					</div>
				</div>
				
				<div class="col-sm-3">	
					<div class="form-group" show-errors>
						<label for="hl7Segment" class="col-sm-4 control-label" ng-show="!gridItem.isRequired">HL7 Segment</label>
						<label for="hl7Segment" class="col-sm-4 control-label" ng-show="gridItem.isRequired">HL7 Segment*</label>
						<div class="col-md-8"> 
						<select ng-model="gridItem.hl7Segment" ng-options="segment.segmentName for segment in ctrl.segmentList"  
									class="form-control" id="segment" name="segment"  ng-change="ctrl.onSegmentChange(gridItem)" ng-required="!ctrl.isSequentialView && gridItem.isRequired">	
								 <option value="">--Select Segment--</option>						  
						</select>
						<p class="help-block" ng-show="fieldForm.segment.$error.required">HL7 Segment is required</p>										
						</div>
					</div>
				</div>
				
				<div class="col-sm-3">	
					<div class="form-group" show-errors>
						<label for="field" class="col-sm-4 control-label" ng-show="!gridItem.isRequired">HL7 Field</label>
						<label for="field" class="col-sm-4 control-label" ng-show="gridItem.isRequired">HL7 Field*</label>
						<div class="col-md-8"> 
						<select ng-model="gridItem.hl7Field" ng-options="field.fieldName for field in gridItem.hl7fieldList"  
									class="form-control" id="field" name="field" ng-required="!ctrl.isSequentialView && (gridItem.isRequired ||gridItem.isNowRequired)"  ng-change="ctrl.calculateProgress(gridItem)">	
								 <option value="">--Select Field--</option>						  
						</select>
						<p class="help-block" ng-show="fieldForm.field.$error.required">HL7 Field is required</p>										
						</div>
					</div>
				</div>
				
				<div class="col-sm-2" ng-show="gridItem.isRepetitive">
					<div class="form-group" show-errors>
					<label for="repetitions" class="col-md-4 control-label">Repetitions</label>
				 	<div class="col-md-8">
				 		<input name="repetitions" type="number" class="form-control" id="repetitions" ng-model="gridItem.totalOccurences" 
							       ng-min="gridItem.noOfMinOccurences"  ng-max ="10"  ng-change = "ctrl.addOccurrence(gridItem)"/>
						<p class="help-block" ng-show="fieldForm.repetitions.$error.max">Please enter value between 1 to 10</p>
                   		<p class="help-block" ng-show="fieldForm.repetitions.$error.min">Please enter value between 1 to 10</p>
                   	</div>
					</div>
			   </div>
								
			</div>
			</ng-form>
       	 </div> <!--  End of repetition for fields-->
       	 <div ng-hide="ctrl.fieldList.length > 0"> No fields to show currently.</div>
       	 <div class="row" ng-show="ctrl.showCustomFields">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
				<p><a href="" ng-click="ctrl.addCustomField()" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-plus"></span> Add Custom Field</a>
				</p>
			</div>
		 </div>
       	       	 	
		</div> <!-- Accordion group end -->
	   </div><!-- End of repetion for accordion  -->
	  </uib-accordion>
    </div>
</div>  <!-- Categorized div ending -->
	    
    <div class="row" ng-hide ="ctrl.showMappingInitialScreen">
		<div class="col-md-12 dh-form-buttons">
		  	<div class="form-group">
				<div class="col-md-offset-10 col-md-2">			
					<button type="submit" class="btn btn-primary" ng-click="ctrl.save()">Save</button>
					<button type="submit" class="btn btn-default" ng-click="ctrl.cancel()">Cancel</button>
				</div>
			</div>
		</div>		
	</div>
  </form>

</div>
