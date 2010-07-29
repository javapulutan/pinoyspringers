<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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