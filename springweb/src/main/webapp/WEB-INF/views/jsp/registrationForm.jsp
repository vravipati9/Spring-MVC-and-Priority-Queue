<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<h1> Employee Registration Form</h1>
	
	<tr bgcolor="red">
		<form:errors path="employee.*"/>
	</tr>

	<form action="/springweb/submitRegistrationForm.html" method="post">
		<table>
		<tr>
			<td>Employee Name : </td><td>        <input type="text" name="empName" /></td>
		</tr>
		<tr>
			<td>Dept Name : </td><td>       <input type="text" name="deptName" /></td>
		</tr>
	
			<tr>
			<td>Employee Mobile : </td><td>      <input type="text" name="empMobileNo" /></td>
		</tr>
		<tr>
			<td>Employee DOB : </td><td>     	   <input type="text" name="empDOB" /></td>
		</tr>
		<tr>
			<td>Employee Skills set :</td><td>    <select name="empSkills" multiple>
													<option value="Java Core">Java Core</option>
													<option value="Spring Core">Spring Core</option>
													<option value="Spring MVC">Spring MVC</option>
													</select><td>
		</tr>
		</table>
		
	<table>
			<tr><td>Employee Address : </td></tr> 
		<tr>
			<td>country: <input type="text" name="address.country"/></td>
			<td>city: <input type="text" name="address.city" /></td>
		</tr>
		
		<tr><td><input type="submit" value="Submit this form by clicking here" /></td></tr>
	</table>
		
</form>
 
</body>
</html>

