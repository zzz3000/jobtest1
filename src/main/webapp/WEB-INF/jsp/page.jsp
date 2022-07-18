<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>
	zzzz

	<form action="save1.do" method="post">

	Please enter your name and pick the Sectors you are currently involved in.
<br>
<br>
Name: 

	<input name="id" type="hidden" value="${query.id}">
	<input name="name" type="text" value="${query.name}" required="required">


<br>
<br>
Sectors: <select name="selectedSectors" multiple="" size="25"
			required="required">

			<c:forEach items="${sectors}" var="sector">


				<c:if test="${query.selectedSectors.contains(sector.id)}">
					<option value="${sector.id}" selected="selected">

						<c:if test="${sector.parent!=null}">&nbsp;&nbsp;&nbsp;&nbsp;
						
							<c:if test="${sector.parent.parent!=null}">&nbsp;&nbsp;&nbsp;&nbsp;
							
								<c:if test="${sector.parent.parent.parent!=null}">&nbsp;&nbsp;&nbsp;&nbsp;
								
								</c:if>
							</c:if>
							
							
						</c:if>

						${sector.name}
					</option>
				</c:if>

				<c:if test="${!query.selectedSectors.contains(sector.id)}">
					<option value="${sector.id}">
							<c:if test="${sector.parent!=null}">&nbsp;&nbsp;&nbsp;&nbsp;
						
							<c:if test="${sector.parent.parent!=null}">&nbsp;&nbsp;&nbsp;&nbsp;
							
								<c:if test="${sector.parent.parent.parent!=null}">&nbsp;&nbsp;&nbsp;&nbsp;
								
								</c:if>
							</c:if>
							
							
						</c:if>

						${sector.name}  - ${sector.id}
					</option>
				</c:if>




			</c:forEach>
		</select> <br>
<br>
<input name="agreed" type="checkbox" required="required"> Agree to terms

<br>
<br>
		
	<input type="submit" value="Save">
	
	</form>

</body>
</html>