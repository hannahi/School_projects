<?php
session_start();

include ('yhteys.php');
mysql_select_db("Kurssit", $yhteys);
$result_kayttajat = mysql_query("SELECT * FROM kayttajat");
$tunnus = $_POST["tunnus"];
$salasana = $_POST["salasana"];
while ($row = mysql_fetch_array($result_kayttajat)) {
	$kayt_tunnus = $row['username'];
	$pw = $row['password'];
	if ($kayt_tunnus == $tunnus) {
		if ($pw == $salasana) {
			$_SESSION["tunnus"] = $tunnus;
		} 
	} 
}

mysql_close($yhteys);
header("Location: index.php");
?>