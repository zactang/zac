<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title> <sitemesh:title />www.zaccn.com</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />

<link href="${ctx}/common/assets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" charset="UTF-8" />
<%-- <link href="${ctx}/common/assets/bootstrap/css/bootstrap-responsive.min.css" type="text/css" rel="stylesheet" charset="UTF-8" /> --%>
<link href="${ctx}/common/assets/css/index.css" type="text/css" rel="stylesheet" charset="UTF-8" />



<script  src="${ctx}/common/assets/js/jquery/1.11.2/jquery.min.js" type="text/javascript"   charset="UTF-8"></script> 
<script  src="${ctx}/common/assets/js/jquery/jquery.form.min.js" type="text/javascript"   charset="UTF-8"></script> 
<script  src="${ctx}/common/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"   charset="UTF-8"></script> 


 <!--[if lt IE 9]>
   	<script src="${ctx}/common/assets/js/html5shiv.min.js" type="text/javascript" charset="UTF-8"></script>
   	<script src="${ctx}/common/assets/js/respond.min.js" type="text/javascript" charset="UTF-8"></script>
	<script src="${ctx}/common/assets/js/excanvas.js" type="text/javascript" charset="UTF-8"></script>
	<script src="${ctx}/common/assets/js/respond.js" type="text/javascript" charset="UTF-8"></script>
 <![endif]-->





</head>

 <body>
 	<sitemesh:body />
</body>
</html>