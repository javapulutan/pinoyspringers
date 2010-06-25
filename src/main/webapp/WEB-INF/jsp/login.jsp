<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
       <link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
       <style type="text/css" media="screen">
               @import url("<c:url value="/resources/css-framework/css/tools.css" />");
               @import url("<c:url value="/resources/css-framework/css/typo.css" />");
               @import url("<c:url value="/resources/css-framework/css/forms.css" />");
               @import url("<c:url value="/resources/css-framework/css/layout-navtop-localleft.css" />");
               @import url("<c:url value="/resources/css-framework/css/layout.css" />");
           </style>

      <script djconfig="parseOnLoad: true" src="<c:url value="/resources/dojo/dojo.js"/>" type="text/javascript"></script>
      <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"> </script>
      <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"> </script>
      <script type="text/javascript">
           dojo.require("dojo.parser");
      </script>
      <title>Pinoy Springers</title>
    </head>
    <body class="tundra">
       <div >
           <div>
               <p>You have tried to access a protected area of this application.</p>
               <p>By default you can login as "admin", with a password of "admin".</p>
            </div>
            <div>
            <div style="border-style:solid; width:50%;margin-left: 25%">
               <!--
               <script type="text/javascript">dojo.require("dijit.TitlePane");</script>

               <div dojoType="dijit.TitlePane" style="width: 100%" title="Spring Security Login">
                   -->
                   <%-- this form-login-page form is also used as the
                       form-error-page to ask for a login again.
                   --%>
                   <c:if test="${not empty param.login_error}">
                       <font color="red">Your login attempt was not successful, try again.<br/>
                           Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                       </font>
                   </c:if>
                   <form name="f" action="<c:url value='/static/j_spring_security_check'/>" method="POST">
                       <div style="margin-top: 3em;">
                          <label for="j_username">Login or Email</label>
                        </div>
                       <div>
                            <input id="j_username" type='text' name='j_username' style="width:350px;font-size:15px;height:20px;"/>
                            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "j_username", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Your Username", required : true}})); </script>
                        </div>
                        <br/>
                        <div>
                             <label for="j_password" >Password</label>
                        </div>
                        <div>
                             <input id="j_password" type='password' name='j_password' style="width:350px;font-size:15px;height:20px;" />
                             <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "j_password", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Your Password", required : true}})); </script>
                         </div>
                         <br/>
                         <div class="submit">
                             <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));</script>
                                 <input id="proceed" type="submit" value="Submit"/>
                                 <input id="reset" type="reset" value="Reset"/>
                         </div>
                    </form>
                 <!--
                 </div>-->
             </div>
             </div>
         </div>
         
    </body>
</html>
