<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>书籍管理系统</title>

<style>
.main {
	width: 900;
	margin: 10px auto;
	text-align: center;
}

.add {
	text-align: right;
	margin: 10px 0;
}

.addbook {
	position: fixed;
	background: rgba(0, 0, 0, 0.6);
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	z-index: 999;
	display: none;
}

.addbook form {
	width: 300px;
	height: 200px;
	padding: 10px;
	background: white;
	/* 居中显示：*/
	position: absolute;
	left: 50%; top: 50%;
	margin-top: -200px;
	margin-left: -150px;
}

.addbook table {
	width: 100%;
	height: 90%;
}

.booklist {
	border: 1px solid #666;
	border-radius: 3px;
	display: flex;       /* flex:弹性盒子。也可用 float 来表示 */
	flex-flow: row wrap; /* 横向显示，会换行 */
}

.book {
	margin: 20px;
	width: 180px;
	height: 220px;
	box-shadow: 1px 1px 3px #333;
}
</style>

<script src="js/jquery-3.1.1.min.js"></script>
<script>
	$(function() {

		// 加载图书列表
		$.ajax({
			method : "get",
			url : "booklist",
			dataType : "json",
			success : function(res) {
				var booklist = $(".booklist");
				$.each(res, function(k, v) {
					var bookhtml = "<div class='book'>"
					 + "<h3>书名：" + v.bookName + "</h3>"
					 + "<p>价格： " + v.price + "</p>"
					 + "</div>";
					booklist.append(bookhtml);
				});
			}
		});
		
		// 绑定事件，点击显示添加层
		$(".add button").click(function() {
			$(".addbook").show("fast");
		});

		// 取消按钮
		$(".cancel").click(function () {
			$(".addbook").hide("fast");
			return false;
		});
		
		// 提交按钮
		$(".submit").click(function () {
			if(!window.confirm("are you sure?")) {
				return false;
			}
		});

	});
</script>

</head>
<body>
	<div class="container">

		<div class="main">
			<h1>图书管理系统</h1>
			<div class="add">
				<button>新增</button>
			</div>
			<div class="booklist"></div>
		</div>

		<div class="addbook">
			<form action="addbook" method="post">
				<table border="1">
					<tr>
						<th colspan=2>图书信息登记</th>
					</tr>
					<tr>
						<td>书名</td>
						<td><input name="bookName"></td>
					</tr>
					<tr>
						<td>价格</td>
						<td><input name="price"></td>
					</tr>
					<tr>
						<td>出版社</td>
						<td><input name="publisher"></td>
					</tr>
					<tr>
						<td>作者</td>
						<td><input name="author"></td>
					</tr>
					<tr>
						<td>日期</td>
						<td><input name="publishDate"></td>
					</tr>
				</table>
				<div style="text-align: center;">
					<button class='submit'>提交</button>
					<button class='cancel'>取消</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>