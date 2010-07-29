<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Enterprise Sales Management</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
	<style type="text/css" media="screen">
        @import url("<c:url value="/resources/css-framework/css/tools.css" />");
        @import url("<c:url value="/resources/css-framework/css/typo.css" />");
        @import url("<c:url value="/resources/css-framework/css/forms.css" />");
        @import url("<c:url value="/resources/css-framework/css/layout-navtop-localleft.css" />");
        @import url("<c:url value="/resources/css-framework/css/layout.css" />");
        @import url("<c:url value="/static/styles/pinoyspringers.css"/>");
    </style>
    <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
</head>
<body class="tundra">
<div id="wrap">
    <div id="header" class="clearfix spring" style="height: 1em;margin:0px;">
		<div id="branding" class="spring" style="height: 1em;">
             <span style="font-size:2em;">Pinoy Springers CRM</span>
		</div>
	</div>

    <div id="menu">
       <%@ include file="/WEB-INF/jsp/layouts/menu.jsp" %>
    </div>

	<div id="content" class="clearfix">
       <div id="main">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<div id="footer" class="clearfix spring">
		<%--
		<a href="http://www.springframework.org">
			<img src="<c:url value="/resources/images/powered-by-spring.png"/>" alt="Powered by Spring" />
		</a>
		--%>
	</div>
</div>
</body>
</html>