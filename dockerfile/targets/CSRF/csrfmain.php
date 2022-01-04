
<?php

	include 'csrfsql.php';
	

	if ($_COOKIE['user'] !='alex')	
	{
		echo "you are not alex";
		exit();
	}

	$con = sqlconn();
	$sql = "select applenum, banananum from attackerlab.users where username='alex'";
	$result = mysqli_query($con, $sql);
	
	if($result){
		$row = mysqli_fetch_array($result, MYSQLI_BOTH);
		echo 'you got '. $row['applenum'].' apple and '. $row['banananum']. ' banana';
		echo '<br>';

	}
	// if($userresult->num_rows > 0){
	// 	echo "fuck";
	// 	$row = $userresult->fetch_assoc();
	// }

	getPrice("apple");
	getPrice("banana");
	if ($_GET['buy']) {

		buy($_GET['commodity'],$_GET['number']);
		header('Location: csrfmain.php');
	}
?>
