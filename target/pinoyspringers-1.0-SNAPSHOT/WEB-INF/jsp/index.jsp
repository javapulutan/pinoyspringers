<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
       <link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
       <style type="text/css" media="screen">
               @import url("<c:url value="/resources/css-framework/css/tools.css" />");
               @import url("<c:url value="/resources/css-framework/css/typo.css" />");
               @import url("<c:url value="/resources/css-framework/css/forms.css" />");
               @import url("<c:url value="/resources/css-framework/css/layout-navtop-localleft.css" />");
               @import url("<c:url value="/resources/css-framework/css/layout.css" />");
               @import url("<c:url value="/static/styles/pinoyspringers.css"/>");
           </style>

      <script djconfig="parseOnLoad: true" src="<c:url value="/resources/dojo/dojo.js"/>" type="text/javascript"></script>
      <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"> </script>
      <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"> </script>
      <script type="text/javascript">
           dojo.require("dojo.parser");
      </script>
      <title>Pinoy Springers CRM</title>
    </head>

    <body class="tundra">
    <div id="wrap">
	<div id="header" class="clearfix spring" style="height: 1em;margin:0px;">
		<div id="branding" class="spring" style="height: 1em;">
             <span style="font-size:2em;">Pinoy Springers CRM</span>
		</div>
	</div>

	<div id="menu">
	   <ul>
	              <li>
                      <sec:authorize ifAnyGranted="ROLE_ADMIN">
                          <a href="/pinoyspringers/profile">List all</a>
                      </sec:authorize>
	              </li>
	              <li>
                      <sec:authorize ifAnyGranted="ROLE_ADMIN">
                          <a href="/pinoyspringers/profile/form">Create Profile</a>
                      </sec:authorize>
	              </li>
	              <li>
	           <a href="/pinoyspringers/static/aj_spring_security_logout">Log-out</a>
	       </li>

	   </ul>

	</div>
    </div>
    </body>

</html>