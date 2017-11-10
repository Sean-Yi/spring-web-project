<%@include file="/WEB-INF/view/header.jsp"%>

  
    <div class="container">
	  <h2>Login with Username and Password</h2>
	  
	  <c:if test="${not empty msg}">
      	<div class="msg" style="color: #ff0000;">${msg}</div>
      </c:if>
            
	  <form name="loginForm" action="<c:url value="/login" />" method="post">
      	<c:if test="${not empty error}">
      		<div class="error" style="color: #ff0000;">${error}</div>
      	</c:if>
        <div class="form-group">
            <label for="username">User: </label>
            <input type="text" id="username" name="username" class="form-control" />
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" />
        </div>
	  
	    <button type="submit" class="btn btn-default">Login</button>
	    
	     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	  </form>
	</div>


<%@include file="/WEB-INF/view/footer.jsp" %>
