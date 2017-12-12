<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生查询管理系统</title>

<style>
	.container {
		max-width: 900px;
		margin: 10px auto;
	}
	header {
		text-align: center;
	}
	
	.caption {
		display: flex;
		justify-content: space-between;
		margin-bottom: 10px;
	}
	
	table {
		width: 100%;
	}

</style>

<script src="js/jquery-3.1.1.min.js"></script>
<script>

// 根据 json 得到 table 的 html
function makeResultHtml(json) {
	var innerHtml = "";
	$.each(json, function (k, v) {
		innerHtml = innerHtml + "<tr>"
			+ "<td><input type='checkbox' name='item' value='" + v.stuNo + "'></td>"
			+ "<td>" + v.stuNo + "</td>"
			+ "<td>" + v.stuName + "</td>"
			+ "<td>" + v.stuAge + "</td>"
			+ "<td>" + v.stuSex + "</td>"
			+ "<td>" + v.score + "</td>"
			+ "</tr>";
	});
	return innerHtml;
}

// 加载完
$(function () {
	// 初始化页面
	$.get("stulist", "", function (res) {
		$(".main table").html(makeResultHtml(res));
	}, "json");

	// 模糊查询
	$("#fuzzyQuery").click(function () {
		$.get("stulist", {condition: $("#condition").val()}, function (res) {
			$(".main table").html(makeResultHtml(res));
		}, "json");
	});
	
	// 删除
	$("#delbutton").click(function () {
		if(!window.confirm("你是否要删除？")) return;
		
	 	$.get("studel", $("td input:checked").serialize(), function () {
			alert("删除成功。");
			// 刷新页面
			window.location.reload();
		});
	});


});


</script>

</head>
<body>

<div class="container">
	<header>
		<h1>学生管理系统</h1>
	</header>
	
	<div class="caption">
		<div>
			<span>条件:</span>
			<input id="condition" name="condition" >
			<button id="fuzzyQuery">模糊查询</button>
		</div>
		<button id="delbutton">删除</button>
	</div>
	
	<div class="main">
		<table border=1>
				
		</table>
	</div>

</div>


</body>
</html>