<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Local Admin Login Page</title>
		<meta charset="UTF-8" />
		<meta name="Designer" content="PremiumPixels.com">
		<meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />" >
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/structure.css" />" >		
	</head>
	<body>
			<form class="box login" name="f" action="<c:url value='j_spring_security_check'/>" method="POST" >
				<fieldset class="boxBody">
				  <label>Username</label>
				  <input type="text" tabindex="1" name="j_username" placeholder="User Name" required>
				  <label><a href="#" class="rLink" tabindex="5">Forget your password?</a>Password</label>
				  <input type="password" tabindex="2" name='j_password' required>
				</fieldset>
				<footer>
				  <input type="submit" class="btnLogin" value="Login" tabindex="4">
				  <input type="reset"  class="btnLogin" name="reset" tabindex="6">
				</footer>
			 </form>
		</form>
	</body>
</html>