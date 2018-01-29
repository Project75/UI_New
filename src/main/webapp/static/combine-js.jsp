<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
response.setHeader("Cache-Control","public");
response.setHeader("Cache-Control","max-age=3600");
response.setHeader("Pragma","cache");
response.setHeader("Content-Type","application/javascript");
%>

<c:import url="lib/jquery-2.2.4/jquery-2.2.4.min.js" /> 
<c:import url="lib/angular-1.6.2/angular.js" />
<c:import url="lib/bootstrap-3.3.7/js/bootstrap.min.js" />

<c:import url="lib/angular-1.6.2/angular-route.js" />
<c:import url="lib/angular-1.6.2/angular-resource.js" />
<c:import url="lib/angular-1.6.2/angular-sanitize.js" />
<c:import url="lib/angular-xeditable-0.6.0/js/xeditable.min.js"/>

<c:import url="lib/moment-2.17.1/moment.min.js" />
<c:import url="lib/moment-timezone-0.5.10/moment-timezone.min.js" />
<c:import url="lib/multi-select-4.0.0/isteven-multi-select.js" />
<c:import url="lib/phoneformat/phoneformat-20140730.js" />
<c:import url="lib/show-errors-2.3.0/showErrors.min.js" />
<c:import url="lib/telerik.kendoui.professional.2015.2.624/js/kendo.all.min.js" />
<c:import url="lib/trNgGrid-3.1.5/trNgGrid.min.js" />
<c:import url="lib/ui-bootstrap-2.5.0/ui-bootstrap-tpls-2.5.0.min.js" />
<c:import url="lib/ui-utils-0.2.3/ui-utils.min.js"/>



<c:import url="js/app.js" />

<c:import url="js/directives/copyToClipboard.js" />
<c:import url="js/directives/fileModel.js" />
<c:import url="js/directives/myTabs.js" />
<c:import url="js/directives/datepickerLocaldate.js" />

<c:import url="js/controllers/DatepickerCtrl.js" />
<c:import url="js/controllers/HeaderCtrl.js" />
<c:import url="js/controllers/HomeCtrl.js" />


<c:import url="js/controllers/MappingListCtrl.js" />
<c:import url="js/controllers/AddMappingCtrl.js" />

<c:import url="js/services/MappingService.js" />

<c:import url="js/services/ErrorHandlerService.js" />
<c:import url="js/services/NotificationService.js" />
<c:import url="js/services/DatepickerService.js" />
<c:import url="js/services/HomeService.js" />
<c:import url="js/services/ModalService.js" />

<c:import url="js/filters/FullNameFilter.js" />
