
<!DOCTYPE html>
<html>
<head>
	<title>login</title>
</head>
<body>
	<p>Thers is a victim, his usename is <b>alex</b> and password is <b>password</b>, he can buy apples and bananas by this account. Suppose you are both a victim and an attacker, and please login with alex account, your browser will sava a cookie, then write an URL that when victim click them, it will complete the purchase without any feeling</p>
<form action="csrflogin.php" method="GET">
<p>username: <input type="text" name="username"><br/></p>
<p>password: <input type="text" name="password"><br/></p>
<input type="submit" value="login" name="login">
</form>
</body>
</html>
<?php
	include 'csrfsql.php';
	$cookie = loginsql();
	if ($cookie == "null") {
		echo "please input correct username or password";
	}
?>
