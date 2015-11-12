<html>
<head>
<script type="text/css">
	.divTable
    {
        display:  table;
        width:auto;
        background-color:#eee;
        border:1px solid  #666666;
        border-spacing:5px;/*cellspacing:poor IE support for  this*/
       /* border-collapse:separate;*/
    }

    .divRow
    {
       display:table-row;
       width:auto;
    }

    .divCell
    {
        float:left;/*fix for  buggy browsers*/
        display:table-column;
        width:200px;
        background-color:#ccc;
    }
	</script>
	
</head>
<body>
	<form id="login-form" action="<%=request.getContextPath() %>/app/ahome/router" method="GET" >
		<div class="divTable">
			<div class="divRow">
				<div class="divCell"><label>User Name</label></div>
				<div class="divCell"><input type="text" name="userName" /></div>
			</div>
			<div class="divRow">
				<div class="divCell"><label>Password</label></div>
				<div class="divCell"><input type="password" name="userId" /></div>
			</div>
			<div class="divRow">
				<div class="divCell"><input type="submit" name="submit" value="Submit" /></div>
				<div class="divCell"><input type="button" name="cancle" value="Cancle" /></div>
			</div>

		</div>
	</form>
</body>
</html>
