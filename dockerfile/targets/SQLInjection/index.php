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

	if(isset($_GET['password'])){
		$password = $_GET['password'];
		$sql="SELECT * FROM passwords WHERE password='$password' LIMIT 0,1";
		$result=mysqli_query($con, $sql);
		$row = mysqli_fetch_array($result, MYSQLI_BOTH);
		if($row){
		  	echo $row['result'];
		}else{
			echo "PASSWORD INCORRECT";
			print_r(mysqli_error($con)); 
		}

	}else{ echo "Please input the ID as parameter with numeric value";}
	
?>

