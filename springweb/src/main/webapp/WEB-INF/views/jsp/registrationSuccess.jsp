<html>
<body>
	<h1>Congratulations!! The application has been processed successfully</h1>
 
	<h2>${msg}</h2>
 	<table>
 		<tr>
 		Employee Name::${employee.empName }<br>
 		</tr>
		<tr>
 		Dept Name::${employee.deptName }	<br>
 		</tr>
 		<tr>
 		Employee Mobile No::${employee.empMobileNo }<br>
 		</tr>
 		<tr>
 		Employee DOB::${employee.empDOB }<br>
 		</tr>
 		<tr>
 		Employee Skills::${employee.empSkills }<br>
 		</tr>
		
		<tr>
			<td>Employee Address :</td>
			<td>country: ${employee.address.country}
			       city: ${employee.address.city}
		</tr> 	</table>
</body>
</html>