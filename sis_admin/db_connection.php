<?php

$localhost = "localhost";
$username = "root";
$password = "";
$dbname = "sis_it2a";

$conn = mysqli_connect($localhost, $username, $password, $dbname);

if(!$conn){
    die("Connection Failed". mysqli_connect_error());
} else {
    // echo "Connection Successfully";
}

?>