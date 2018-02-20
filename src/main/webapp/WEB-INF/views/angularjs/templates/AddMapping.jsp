<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="fhir-inner-header ng-scope">
  <div class="row">	
	  <div class="col-md-12">	
		<ol class="breadcrumb pull-right">
		  	<li><a href="#!/">Home</a></li>
		  	<li><a href="#!/mappings/mappingList">Mappings</a></li>
  			<li class="active">{{ctrl.mode}} Mapping</li>
		</ol>		
		<h1 class="ng-scope fhir-page-header">{{ctrl.mode}} Mapping</h1>
	  </div>
  </div>
</div>

<div ng-repeat="message in ctrl.messages" class="alert alert-success" role="alert">{{message}}
	<span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
</div>
<div ng-repeat="error in ctrl.errors" class="alert alert-danger" role="alert">{{error}}
	<span style="float:right;" class="glyphicon glyphicon-remove" ng-click="ctrl.clearNotifications()"></span>
</div>  

<div id="optionSelectionDiv" ng-show ="ctrl.showMappingInitialScreen">
 <form role="form" class="form-horizontal" name="addMappingInitForm" novalidate>
	
	<div class="row">
		<div class="col-sm-6">
		  <div class="form-group">
           <label class="col-sm-4 control-label"><h5> &nbsp;&nbsp;Create a new mapping &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></label>
           	<input type ="radio" name="radioGroup_mappingChoice" ng-model="ctrl.option" ng-checked="true" value="newMapping" ng-change="ctrl.onRadioChange()"/>	
          </div>
        </div>  
        <div class="col-sm-6">
          <div class="form-group">
           <label class="col-sm-4 control-label"><h5>&nbsp;&nbsp;Copy from an existing mapping&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></label>
           	<input type ="radio" name="radioGroup_mappingChoice" ng-model="ctrl.option" value="existingMapping" ng-change="ctrl.onRadioChange()" />
    	  </div>
       </div>	  
	</div>
		
	 <div class="row">
        <div class="col-sm-6">
            <div class="form-group" show-errors>						
				<label for="mappingName" class="col-sm-4 control-label">Mapping Name*</label> 
				<div class="col-sm-8">
	                <input name='mappingName' type="text" class="form-control" id="mappingName" maxlength="100" ng-model="ctrl.mapping.mappingName" required>
			   		<p class="help-block" ng-show="addMappingInitForm.mappingName.$error.maxlength">Max Length Exceeded</p>
			   		<p class="help-block" ng-show="addMappingInitForm.mappingName.$error.required">Name is required</p>
	        	</div>				
        	</div>
    	</div>	       
	 
       <div class="col-sm-6" ng-show="ctrl.option=='newMapping'">
			<div class="form-group" show-errors>
				<label for="baseProfile" class="col-sm-4 control-label">Base Profile*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.baseProfileTypeId" class="form-control" ng-options="baseProfile.id as baseProfile.profileName for baseProfile in ctrl.baseProfileList" 
                         id="baseProfile" name="baseProfile" ng-required="ctrl.option=='newMapping'">
                          <option value="">--Select Base Profile--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.baseProfile.$error.required">Base Profile is required</p>	
                </div>			
			</div>
	   </div>
	   
	   <div class="col-sm-6" ng-show="ctrl.option=='existingMapping'">
			<div class="form-group" show-errors>
				<label for="copiedMappingId" class="col-sm-4 control-label">Reference Mapping*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.copiedMappingId" class="form-control" ng-options="mapping.id as mapping.name for mapping in ctrl.existingMappingList" 
                         id="copiedMappingId" name="copiedMappingId" ng-required="ctrl.option=='existingMapping'" ng-change="ctrl.getMappingById(ctrl.mapping.copiedMappingId)">
                         <option value="">--Select Mapping--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.copiedMappingId.$error.required">Existing profile is required to clone</p>	
                </div>			
			</div>
		</div>
	 </div> 
	  
	 <div class="row">
	  
		
    </div> 
    
    <div class="row">
    	<div class="col-sm-6">
			<div class="form-group" show-errors>
				<label for="mappingType" class="col-sm-4 control-label">Mapping Type*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.mappingType" class="form-control" ng-options="mappingType.id as mappingType.name for mappingType in ctrl.mappingTypeList" 
                         id="mappingType" name="mappingType"  required>
                         <option value="">--Select Mapping Type--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.mappingType.$error.required">Mapping Type is required.</p>	
                </div>			
			</div>
		</div>
		
		<div class="col-sm-6">
			<div class="form-group" show-errors>
				<label for="maoppingType" class="col-sm-4 control-label">Message Type*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.messageType" class="form-control" ng-options="messageType.id as messageType.name for messageType in ctrl.messageTypeList" 
                         id="messageType" name="messageType"  required>
                         <option value="">--Select Message Type--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.messageType.$error.required">Message Type is required</p>	
                </div>			
			</div>
		</div>
    </div>
    
    <div class="row">
    	<div class="col-sm-6" ng-show="ctrl.mapping.messageType == 'bundle'">
			<div class="form-group" show-errors>
				<label for="bundleType" class="col-sm-4 control-label">Bundle Type*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.bundleType" class="form-control" ng-options="bundleType.id as bundleType.name for bundleType in ctrl.bundleTypeList" 
                         id="bundleType" name="bundleType" ng-required="ctrl.mapping.messageType == 'bundle'">
                         <option value="">--Select Bundle Type--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.bundleType.$error.required">Bundle Type is required</p>	
                </div>			
			</div>
		</div>
		
		<div class="col-sm-6">
			<div class="form-group" show-errors>
				<label for="referenceURL" class="col-sm-4 control-label">Reference URL Type*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.referenceUrlOptions" class="form-control" ng-options="referenceURL.id as referenceURL.name for referenceURL in ctrl.referenceURLOptions" 
                         id="referenceURL" name="referenceURL"  required>
                         <option value="">--Select Mapping--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.referenceURL.$error.required">Reference URL Option is required</p>	
                </div>			
			</div>
		</div>
    </div>
    
    <div class="row">
    	<div class="col-sm-6">
			<div class="form-group" show-errors>
				<label for="rule" class="col-sm-4 control-label">Resource Creation Rule*</label>
				<div class="col-sm-8">
				<select ng-model="ctrl.mapping.resourceCreationRule" class="form-control" ng-options="rule.id as rule.name for rule in ctrl.resourceCreationRules" 
                         id="rule" name="rule"   required>
                         <option value="">--Select Resource Creation Rule--</option>
                </select>
                <p class="help-block" ng-show="addMappingInitForm.rule.$error.required">Resource Creation rule is required</p>	
                </div>			
			</div>
		</div>
		
		 <div class="col-sm-6" ng-show="ctrl.option=='newMapping'">
			<div class="form-group" show-errors>
				<label for="resourceType" class="col-sm-4 control-label" ng-hide="ctrl.emptyResourceType">Resource Type(s)*</label>
                <label for="resourceType" class="col-sm-4 control-label text-danger" ng-show="ctrl.emptyResourceType">Resource Type(s)*</label>
				<div class="col-md-8" id="resourceType" name="resourceType">
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
    </div>
    
    <div class="row">
		<div class="col-sm-12">
			<div class="form-group" show-errors>
				<label for="notes" class="col-md-2 control-label">Additional Notes</label>
               	<div class="col-md-10"> 
                   <textarea style="overflow:auto" rows="2" cols="5" class="form-control" id="notes" name="notes" ng-model="ctrl.mapping.additionalNotes" ng-maxlength="2000"></textarea>
                   <p class="help-block" ng-show="addMappingInitForm.notes.$error.maxlength">Max Length Exceeded</p>
               	</div>
			</div>
		</div>
	</div>
	
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
	
</div><!-- End of option selection Div -->


<div class="col-sm-12" ng-show="ctrl.mode == 'Update'">
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
 
<div ng-show="!ctrl.showMappingInitialScreen">
	 <div class="row">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
			  <p>	
				 <a href="" ng-click="ctrl.changeView('cat')" role="button" class="btn btn-success" ng-show="ctrl.isSequentialView"><span class="glyphicon glyphicon-th-list"></span> </a>
				 <a href="" ng-click="ctrl.changeView('seq')" role="button" class="btn btn-default" ng-show="!ctrl.isSequentialView"><span class="glyphicon glyphicon-th-list"></span> </a>
			     <a href="" ng-click="ctrl.changeView('seq')" role="button" class="btn btn-success" ng-show="!ctrl.isSequentialView"><span class="glyphicon glyphicon-th-large"></span> </a>
			     <a href="" ng-click="ctrl.changeView('cat')" role="button" class="btn btn-default" ng-show="ctrl.isSequentialView"><span class="glyphicon glyphicon-th-large"></span> </a>
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
    <span><img src="/${serverInstanceName}/src/main/webapp/static/images/ajax-loader.gif" /></span>
</div>	
 <div id="sequentialDiv" ng-show="ctrl.isSequentialView && !ctrl.showMappingInitialScreen && ctrl.pageLoadComplete">
 	
 	<div class="row">
		<div class="col-sm-10"></div>
		<div class="col-sm-2">
			<p><a href="" ng-click="ctrl.showOptionalFieldDialog()" role="button" class="btn btn-secondary">
				    <span class="glyphicon glyphicon-plus"></span> Add Optional Field</a>
			</p>
		</div>	
	</div>
		
 	<div ng-repeat="gridItem in ctrl.fieldList track by $index">
		 <ng-form name="fieldForm">
       	 	<div class="row">
		        <div class="col-sm-4" show-errors>	
					<div class="form-group">
						<label for="fieldName" class="col-sm-3 control-label">Field</label>
						<div class="col-md-5">
							 <input type="text" class="form-control" ng-model="gridItem.fieldName" ng-disabled="!gridItem.isExtension" ng-change="ctrl.onFieldNameChange(gridItem)"/>
					    </div>
					    <div class="col-md-4"  ng-show="gridItem.showStaticValues"> 
							<select ng-model="gridItem.staticValue" ng-options="staticUse for staticUse in gridItem.staticValuesList"  
										class="form-control" id="staticUse" name="staticUse"  ng-required="ctrl.isSequentialView && gridItem.showStaticValues">						  
							</select>									
						</div>
					</div>
				</div>
			<!-- </div> -->
				
				<!-- <div class="col-sm-2">
					<div class="form-group" show-errors ng-show="gridItem.showStaticValues">
						<label for="staticUse" class="col-sm-4 control-label">Use*</label>
						<div class="col-md-8"> 
						<select ng-model="gridItem.staticValue" ng-options="staticUse for staticUse in gridItem.staticValuesList"  
									class="form-control" id="staticUse" name="staticUse"  ng-required="ctrl.isSequentialView && gridItem.showStaticValues">	
								 <option value="">--Select Use--</option>						  
						</select>
						<p class="help-block" ng-show="fieldForm.staticUse.$error.required">Static Use is required</p>										
						</div>
					</div>
				</div> -->
				
				<div class="col-sm-3">	
					<div class="form-group" show-errors>
						<label for="hl7Segment" class="col-sm-4 control-label" ng-show="!gridItem.isRequired">HL7 Segment</label>
						<label for="hl7Segment" class="col-sm-4 control-label" ng-show="gridItem.isRequired">HL7 Segment*</label>
						<div class="col-md-8"> 
						<select ng-model="gridItem.hl7Segment" ng-options="segment.segmentName as segment.segmentName for segment in ctrl.segmentList"  
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
						<select ng-model="gridItem.hl7Field" ng-options="field.fieldName as field.fieldName for field in gridItem.hl7fieldList"  
									class="form-control" id="field" name="field" ng-required="ctrl.isSequentialView && (gridItem.isRequired ||gridItem.isNowRequired)"
									ng-change="ctrl.calculateProgress(gridItem)" >	
								 <option value="">--Select Field--</option>						  
						</select>
						<p class="help-block" ng-show="fieldForm.field.$error.required">HL7 Field is required</p>										
						</div>
					</div>
				</div>
				
				<div class="col-sm-1">
					<p class="col-sm-6" ng-show="gridItem.showRemoveButton"><a href="" ng-click="ctrl.removeOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-remove" style="color:red"></span></a></p>
					<p class="col-sm-6" ng-show="(gridItem.isRepeating  && (10 > gridItem.totalOccurences ))"><a href="" ng-click="ctrl.addOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-plus" style="color:#0D4F8B"></span></a></p>
				</div>
				
				<!-- <div class="col-sm-1">
					<p ng-show="gridItem.showRemoveButton"><a href="" ng-click="ctrl.removeOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-remove" style="color:red"></span></a></p>
				</div>
				<div class="col-sm-1" ng-show="(gridItem.isRepeating  && (10 > gridItem.totalOccurences ))">
					<p><a href="" ng-click="ctrl.addOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-plus" style="color:#0D4F8B"></span></a></p>
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
     	
     	<div class="row" ng-show="fieldType.id == 'optionalFields'">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
				<p><a href="" ng-click="ctrl.showOptionalFieldDialog()" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-plus"></span> Add Optional Field</a>
				</p>
			</div>	
		</div>
 		<div ng-repeat="gridItem in ctrl.fieldList track by $index">
		 <ng-form name="fieldForm">
       	 	<div class="row">
		        <div class="col-sm-4">	
					<div class="form-group">
						<label for="fieldName" class="col-sm-4 control-label">Field</label>
						<div class="col-md-8">
							 <input type="text" class="form-control" ng-model="gridItem.fieldName" ng-disabled="!gridItem.isExtension" ng-change="ctrl.onFieldNameChange(gridItem)"/>
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
				<div class="col-sm-1" ng-show="gridItem.showRemoveButton">
					<p><a href="" ng-click="ctrl.removeOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-remove" style="color:red"></span></a></p>
				</div>
				<div class="col-sm-1" ng-show="!gridItem.showRemoveButton"></div>
				<div class="col-sm-1" ng-show="(gridItem.isRepeating  && (10 > gridItem.totalOccurences ))">
					<p><a href="" ng-click="ctrl.addOccurrence(gridItem)" role="button" class="btn btn-secondary">
					    <span class="glyphicon glyphicon-plus" style="color:#0D4F8B"></span></a></p>
				</div>
								
			</div>  <!-- End of row -->
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
   <div class="row" ng-show ="!ctrl.showMappingInitialScreen">
	<div class="col-md-12 fhir-form-buttons">
	  	<div class="form-group">
			<div class="col-md-offset-10 col-md-2">			
				<button type="submit" class="btn btn-primary" ng-click="ctrl.save()">Save</button>
				<button type="button" class="btn btn-default" ng-click="ctrl.go('/mappings/mappingList')">Cancel</button>
			</div>
		</div>
	</div>		
   </div>
</form>
