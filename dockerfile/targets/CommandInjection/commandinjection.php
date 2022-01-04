<?php
header("Content-type:text/html;charset=utf-8");
if( isset( $_POST[ 'ip' ]  ) ) {

	$target = $_REQUEST[ 'ip' ];
	$substitutions = array(
		'&&' => '',
		';'  => '',
	);


	$target = str_replace( array_keys( $substitutions ), $substitutions, $target );

	if( stristr( php_uname( 's' ), 'Windows NT' ) ) {

		$cmd = shell_exec( 'ping  ' . $target );
	}
	else {

		$cmd = shell_exec( 'ping  -c 4 ' . $target );
	}

	echo "<pre>{$cmd}</pre>";
}

if(isset($_POST['password'])){
	$password = $_POST['password'];
	if($password == "2x$^Nv1Y)rvxGdby"){
		echo "YOU GOT IT";
	}else{
		echo "PASSWORD INCORRECT";
	}
}

?>
