
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加帖子</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  type="text/css" rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css"/>
    <script src="js/jquery-3.4.1.js"></script>
    <script src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-control" action="invitation?action=insert" method="post">
    <label for="biaoti">标题</label>
    <input type="text" name="title" id="biaoti"/><br/>
    <label for="neirong">内容</label>
    <input type="text" name="content" id="neirong"/><br/>
    <input type="submit" value="添加" class="btn btn-default">
</form>
</body>
</html>
