<?php 
	$dbuser ='root';
	$dbpass ='password';
	$dbname ="attackerlab";
	$host = 'localhost';
	$dbname1 = "attackerlab";

	@$con = mysqli_connect($host,$dbuser,$dbpass);
	// Check connection
	if (!$con)
	{
	    echo "Failed to connect to MySQL: " . mysqli_error($con);
	}

	@mysqli_select_db($con, $dbname) or die ( "Unable to connect to the database: $dbname");

	$uagent = $_SERVER['HTTP_USER_AGENT'];
	$IP = $_SERVER['REMOTE_ADDR'];


	if(isset($_POST['username']) && isset($_POST['password'])){
		$username = check_input($_POST['username']);
		$password = check_input($_POST['password']);
		$sql="SELECT * FROM users WHERE users.username='$username' and users.password='$password' LIMIT 0,1;";
		$result = mysqli_query($con, $sql);
		if($result){
		$row = mysqli_fetch_array($result, MYSQLI_BOTH);
			if($row){
				echo $row['result'];
				echo "</br>";
				$insert="INSERT INTO `attackerlab`.`uagents` (`uagent`, `ip_address`, `username`) VALUES ('$uagent', '$IP', '$username')";
				mysqli_query($con, $insert);
				echo 'Your User Agent is: ' .$uagent;
				echo "</br>";
				print_r(mysqli_error($con));
			}else{
				echo "USERNAME OR PASSWORD WRONG";
				print_r(mysqli_error($con));
			}
		}else{
			echo "USERNAME OR PASSWORD WRONG";
			print_r(mysqli_error($con));
		}


	}

	if(isset($_POST['hiddenpassword'])){
		$password = check_input($_POST['hiddenpassword']);
		$sql="SELECT * FROM passwords WHERE password='$password' LIMIT 0,1";
		$result=mysqli_query($con, $sql);
		if($result){
			$row = mysqli_fetch_array($result, MYSQLI_BOTH);
			if($row){
			  	echo $row['result'];
			}else{
				echo "HIDDEN PASSWORD INCORRECT";
			}
		}else{
			echo "HIDDEN PASSWORD INCORRECT";
		}


	}


	function check_input($value){

		if(!empty($value))
			{
			// truncation (see comments)
			$value = substr($value,0,20);
			}

			// Stripslashes if magic quotes enabled
			if (get_magic_quotes_gpc()){
				$value = stripslashes($value);
				}

			// Quote if not a number
			$value = addslashes($value);
			
		return $value;
		}
 ?>
