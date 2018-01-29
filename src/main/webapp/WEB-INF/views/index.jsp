<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html ng-app="fhirApp">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/${serverInstanceName}/images/logo4.png" />
<title>FHIR</title>

 <script>
    var SERVER_INSTANCE_NAME = '${serverInstanceName}';
</script>
<script src="static/combine-js.jsp"></script>
<link href="<spring:url value="/static/lib/angular-xeditable-0.6.0/css/xeditable.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/lib/bootstrap-3.3.7/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/lib/bootstrap-3.3.7/css/bootstrap-theme.min.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/lib/multi-select-4.0.0/isteven-multi-select.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/lib/trNgGrid-3.1.5/trNgGrid.min.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/lib/telerik.kendoui.professional.2015.2.624/styles/kendo.common.min.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/lib/telerik.kendoui.professional.2015.2.624/styles/kendo.default.min.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/custom.css"/>" rel="stylesheet">
<link href="<spring:url value="/static/custom-app.css"/>" rel="stylesheet">

</head>
<body style="padding-bottom: 250px;">

 <header id="banner" class="navbar" role="banner">
	<div class="navbar-inner navbar-default" style="min-height: 50px;">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-9 ">
					<spring:url value="/static/images/logo01.png" var="iconUrl" htmlEscape="true" />
					<a class="navbar-brand" rel="home" href="#!/" title="FHIR Mapper"> <img style="max-width: 150px; margin-top: -7px;" src="${iconUrl}">
					</a> <a class="navbar-brand" href="#!/">FHIR Mapper</a>
				</div>
				<div class="clearfix visible-xs-block"></div>
			</div>
		</div>
	</div>

	<div class="navbar-inner navbar-custom" role="navigation">
	 <div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
				<ul class="nav navbar-nav">
					<li ng-class="{ active: headerCtrl.isActive('/mappings/mappingList')}"><a href="#!/mappings/mappingList">Mappings</a></li>
					<li ng-class="{ active: headerCtrl.isActive('/profileList')}"><a href="#!/profileList">Profiles</a></li>
				</ul>				
			</div>
		</div>
	</div>

 </header>
<div class="container" ng-view></div>
</body>
</html>
