
<?php 
$dbuser ='root';
$dbpass ='password';
$dbname ="attackerlab";
$host = 'localhost';


@$con = mysqli_connect($host,$dbuser,$dbpass);
// Check connection
if (!$con)
{
    echo "Failed to connect to MySQL: " . mysqli_error($con);
}

@mysqli_select_db($con, $dbname) or die ( "Unable to connect to the database: $dbname");


if(isset($_GET['password'])){
	$password = $_GET['password'];
	if(!waf($password)){
		$sql="SELECT * FROM passwords WHERE password='$password' LIMIT 0,1";
		$result=mysqli_query($con, $sql);
		$row = mysqli_fetch_array($result, MYSQLI_BOTH);
		if($row){
	  		echo $row['result'];
		}else{
			echo "PASSWORD INCORRECT";
		print_r(mysqli_error($con)); 
		}
	}

}

function waf($str){

	$specialChars= "\\,./\"'()";

	$specialArr=array();
	$len= mb_strlen($specialChars,'UTF-8');
	for($i=0;$i<$len;$i++){
		$specialArr[]=mb_substr($specialChars, $i,1,'UTF-8');
	}

	$arr=array();
	$len= mb_strlen($str,'UTF-8');
	for($i=0;$i<$len;$i++){
		$arr[]=mb_substr($str, $i,1,'UTF-8');
	}
	foreach ($arr as $v){
		if(in_array($v, $specialArr)){
			echo "DO NOT ATTACK MY WEBSITE!";
			return true;
		}
	}
	return false;
}
?>

