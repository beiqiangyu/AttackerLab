
<?php
	function sqlconn(){ //连接数据库函数
		$servername = "localhost"; //数据库所在主机名
		$username = "root"; //使用的数据库的用户名 
		$password = "password"; //使用的数据库的用户的密码
		$dbname = "attackerlab";  //用户所使用的数据库
		$conn = mysqli_connect($servername, $username, $password, $dbname);
		if (!$conn) {
    		die("Failed to connect to MySQL: ".$dbname);
		} 
		else{
			return $conn;
		}
	}
	function loginsql(){ //登入判断函数
		$conn = sqlconn();
		$sql = "select password from users where username='{$_GET['username']}'";
		$result = $conn->query($sql);
		if ($result->num_rows > 0)
		{
			$row = $result->fetch_assoc();
			if ($row['password'] === $_GET['password']){
				setCookie('user',"alex");
				header('Location: csrfmain.php');
			}else{
				return "null";
			}
		}
	}
	function getPrice($name){
		$conn = sqlconn();
		$sql = "select * from produce where name='$name'";
		$result = $conn->query($sql);
		if ($result->num_rows > 0)
		{
			$row = $result->fetch_assoc();
			$remain = $row['remain'];
			echo "</br>";
			print <<<EOT
			
			<form action="csrfmain.php" method="GET">
			commodities: <input type="text" value=$name name="commodity" readonly="readonly"> remain: $remain </br>
			number for purchase：<input type="text" value="1" name='number'>
			<input type="submit" name='buy' value="buy">
			</form>
EOT;
		}
		$conn->close();
	}

	function buy($name,$num){
	    if ($_COOKIE['user'] !='alex'){
			break;
		}

		$conn = sqlconn();
		$sql = "update produce set remain=remain-$num where name = '$name'";
		$updateusersql = "";

		if($name =="apple"){
			$updateusersql="update attackerlab.users set applenum=applenum+ '$num' where username = 'alex'";
		}else{
			$updateusersql="update attackerlab.users set banananum=banananum+ '$num' where username = 'alex'";
		}
		$conn->query($sql);
		$conn->query($updateusersql);
		$conn->close();
	}
?>
