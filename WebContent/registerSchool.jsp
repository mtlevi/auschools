<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AUSchools - A Simple School Registry</title>
<s:head />
<style type="text/css">
@import url(css/style.css);
</style>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/auschools.js"></script>
</head>
<body>
<h1>AUSchools</h1>
<div class="schoolForm">
	<h2>Add/Edit School</h2>
	<br />
	<s:form action="saveOrUpdateSchool">
		<s:push value="school">
			<s:hidden name="id" />
			<s:textfield name="name" label="School Name" />
			<s:select name="area" list="{'Armadale','Bassendean','Bayswater','Belmont','Cambridge','Canning','Claremont','Cockburn','Cottesloe','Fremantle','Gosnells',
										'Joondalup','Kalamunda','Kwinana','Melville','Mosman Park','Mundaring','Nedlands','Peppermint Grove','Rockingham',
										'Serpentine-Jarrahdale','South Perth','Stirling','Subiaco','Swan','Victoria Park','Vincent','Wanneroo','Wembley'}" 
				headerKey="" headerValue="Select an area" label="School Area" />
			<s:textfield name="year" label="Year of Establishment" />
			<s:checkbox name="privateSchool" label="Private School" />
			<s:submit />
		</s:push>
	</s:form>
	<br />
</div>

<br/>

<s:if test="schoolList.size() > 0">
	<div class="schoolListing">
		<h2>Registered Schools</h2>
		<br />
		<div class="content">
			<table class="schoolTable" cellpadding="5px">
				<tr class="even">
					<th>Name</th>
					<th>Area</th>
					<th>Year</th>
					<th>Private</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<s:iterator value="schoolList" status="rowStatus" var="currentSchool">
					<tr class="<s:if test="#rowStatus.odd == true">odd</s:if><s:else>even</s:else>">
						<td><s:property value="name" /></td>
						<td><s:property value="area" /></td>
						<td><s:property value="year" /></td>
						<td>
							<s:if test="#currentSchool.privateSchool == true">yes</s:if><s:else>no</s:else>
						</td>
						<td><s:url id="editURL" action="editSchool">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">Edit</s:a></td>
						<td><s:url id="deleteURL" action="deleteSchool">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</s:if>
</body>
</html>