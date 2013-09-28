<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>  
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>	
	<style type="text/css">
	  .action, .price { margin-top: 20px; }
	</style>
</head>
<body>
  <h1>Demo</h1>
	<h2>
		Choose your domain name and how many years you want to register for:
	</h2>

	<f:form method="get" action="price" modelAttribute="registarForm" novalidate="novalidate">
	  <div id="domain-names">
	  <c:forEach items="${registarForm.registarInfos}" var="registarInfo" varStatus="status">
	    <div class="domain-name">
		    <label for="registarInfos[${status.index}].fullName">Domain Name:</label>
		    <input name="registarInfos[${status.index}].fullName" placeholder="Domain name" value="${registarInfo.fullName}"/>
		    
		    <label for="registarInfos[${status.index}].registerYear">Year(s):</label>
		    <select name="registarInfos[${status.index}].registerYear">
			    <c:forEach begin="1" end="10" step="1" var="i">
			      <option value="${i}" ${registarInfo.registerYear == i ? "selected" : ""}>${i} ${i > 1 ? "Years" : "Year"}</option>
			    </c:forEach>
        </select>
		  </div>
    </c:forEach>
    </div>
	  <div class="action">
	    <input type="button" value="Add Domain Name" id="add-domain-name" />
	    <input type="button" value="Remove Domain Name" id="remove-domain-name" />
	    <input type="submit" value="Query Price" />
	  </div>
	  <c:if test="${not empty totalPrice}">
      <div class="price">Total Price: ${totalPrice}</div>
    </c:if>
	  
	</f:form>  
	
  <script type="text/javascript" src="resources/jquery.min.js"></script>
	<script type="text/javascript">
	  $(function() {
		  $("#add-domain-name").click(function(ev) {
		  	ev.preventDefault();
		    
		  	var current = $("#domain-names .domain-name").length;
				var name_attr = 'registarInfos[' + current + ']';
				var cloneIt = $("#domain-names .domain-name:last").clone().css('display','none');
				cloneIt.find("input[name$=fullName]").attr("name", name_attr + '.fullName').val("");
				cloneIt.find("select[name$=registerYear]").attr("name", name_attr + '.registerYear').val(1);
				cloneIt.appendTo($("#domain-names")).show();

		  	return false;
		  });
		  $("#remove-domain-name").click(function(ev) {
			  	ev.preventDefault();
			    
			  	var current = $("#domain-names .domain-name").length;
			  	if (current == 1) {
			  		alert("Please at lease choose one.")
			  	} else {
			  		$("#domain-names .domain-name:last").remove();
			  	}

			  	return false;
			  });
		});
	</script>
</body>
</html>
