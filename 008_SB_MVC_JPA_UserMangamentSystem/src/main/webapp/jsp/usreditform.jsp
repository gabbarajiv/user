<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@page isELIgnored="false" %>
    <h1>Edit Product</h1>
       <form:form method="POST" action="editsave" modelAttribute="user">  
      	<table > 
      	<tr>
      	<td></td>  
         <td><form:hidden  path="uno" /></td>
         </tr>  
      	<tr>
      	<td>User Name</td>  
         <td><form:input  path="uname" /></td>
         </tr> 
         <tr>  
          <td>User Email : </td> 
          <td><form:input path="uemail"  /></td>
         </tr>  
         <tr>  
          <td>User Password :</td>  
          <td><form:input path="upassword" /></td>
         </tr> 
         <tr>  
          <td>User Address :</td>  
          <td><form:input path="uaddress" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  