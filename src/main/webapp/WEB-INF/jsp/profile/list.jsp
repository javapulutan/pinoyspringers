<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<h3>List</h3>
<div>
      <c:if test="${not empty profiles}">
          <table>
                  <thead>
                          <tr>
                              <td>First Name</td>
                              <td>Middle Name</td>
                              <td>Last Name</td>
                          <tr>
                  </thead>
                  <tbody>
                          <c:forEach var="item" items="${profiles}">
                              <tr>
                                  <td>${item.personName.firstName}</td>
                                  <td>${item.personName.middleName}</td>
                                  <td>${item.personName.lastName}</td>
                                  <td>
                                       <form:form action="/pinoyspringers/profile/${item.id}/form" method="GET">
                                          <input type="submit" id="proceed" value="Edit"/>
                                       </form:form>
                                       <form:form action="/pinoyspringers/profile/${item.id}/remove" method="DELETE">
                                          <input type="submit" id="proceed_del" value="Delete"/>
                                       </form:form>

                                  </td>
                              <tr>
                          </c:forEach>
                          <tr>
                               <td colspan="4">
                                       <form:form action="/pinoyspringers/profile/form" method="GET">
                                           <input type="submit" id="proceed_add" value="Add"/>
                                       </form:form>
                               </td>
                          </td>
                  </tbody>
          </table>
      </c:if>
</div>
