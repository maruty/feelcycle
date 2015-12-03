<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>バッチ処理</title>
</head>
<body>
<h1>FEELCYCLEバッチ起動確認</h1>
<p>起動が終了しました</p>
<p>処理対象リスト</p>
    <c:forEach var="userList" varStatus="s" items="${userList}">
    	<p>${f:h(userList.userId)}</p>
   	</c:forEach>
</body>
</html>