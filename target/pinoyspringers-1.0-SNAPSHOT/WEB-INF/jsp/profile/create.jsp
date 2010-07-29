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


<form:form action="/pinoyspringers/profile" method="POST" modelAttribute="profile">

     <div id="_profile_first_name">
     <form:input id="_first_name" path="personName.firstName"/>
     <br/>
     <form:errors cssClass="errors" id="_profile_first_name" path="personName.firstName"/>
     <script type="text/javascript">
         Spring.addDecoration(new Spring.ElementDecoration({elementId : "_first_name", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "First Name (required)", invalidMessage: "", required : true}}));
     </script>

     </div>
     <div id="_profile_middle_name">
     <form:input id="_middle_initial" path="personName.middleName"/>
     <br/>
          <form:errors cssClass="errors" id="_middle_initial" path="personName.middleName"/>
          <script type="text/javascript">
              Spring.addDecoration(new Spring.ElementDecoration({elementId : "_middle_initial", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Middle Name (required)", invalidMessage: "", required : true}}));
          </script>

     </div>

     <div id="_profile_last_name">
     <form:input id="_last_name" path="personName.lastName" />
     <br/>
     <form:errors cssClass="errors" id="_last_name" path="personName.lastName"/>
               <script type="text/javascript">
                   Spring.addDecoration(new Spring.ElementDecoration({elementId : "_last_name", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Last Name (required)", invalidMessage: "", required : true}}));
               </script>

     </div>

     <div id="_profile_email">
     <form:input id="_email" path="email" />
     <br/>
     <form:errors cssClass="errors" id="_email" path="email"/>
     <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "_email", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Email address", invalidMessage: "Ex. kabilaw.101@gmail.com", regExp: ".+@.+\.[a-z]+"}})); </script>

     </div>

     <div id="_profile_submit">
     <input id="proceed" type="submit" value="Save"/>
     </div>

</form:form>
