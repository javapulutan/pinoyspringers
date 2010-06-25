<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<h3>update profile</h>

<form:form action="/pinoyspringers/profile/${id}" method="PUT" modelAttribute="profile">

     <div id="_profile_first_name">
     <form:input id="_first_name" path="personName.firstName"/>
     </div>

     <div id="_profile_middle_name">
     <form:input id="_middle_initial" path="personName.middleName"/>
      </div>

     <div id="_profile_last_name">
     <form:input id="_last_name" path="personName.lastName" />
     </div>

     <div id="_profile_email">
     <form:input id="_email" path="email" />
     </div>

     <div id="_profile_submit">
     <input id="proceed" type="submit" value="Update"/>
     </div>
     <form:hidden id="_id" path="id"/>
     <form:hidden id="_version" path="version"/>
</form:form>