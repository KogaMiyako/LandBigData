<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>jQuery垂直手风琴多级下拉菜单代码</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/dropdown.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/reset.css">




</head>
<body>
<ul class="cd-accordion-menu animated">
	<li class="has-children">
		<input type="checkbox" name ="group-1" id="group-1" checked>
		<label for="group-1">Group 1</label>

		<ul>
			<li class="has-children">
				<input type="checkbox" name ="sub-group-1" id="sub-group-1">
				<label for="sub-group-1">Sub Group 1</label>

				<ul>
					<li><a href="#0">Image</a></li>
					<li><a href="#0">Image</a></li>
					<li><a href="#0">Image</a></li>
				</ul>
			</li>

			<li><a href="#0">Image</a></li>
			<li><a href="#0">Image</a></li>
		</ul>
	</li>
</ul>

<script src="${pageContext.request.contextPath}/assets/plugins/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/app/js/dropdown.js"></script>


</body>
</html>
