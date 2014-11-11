<?php
include ('yhteys.php'); 
mysql_select_db("Kurssit", $yhteys);

$tunnus = $_POST['tunnus'];
$salasana = $_POST['salasana'];

$sql = "INSERT INTO kayttajat (username, password) values ('$tunnus', '$salasana')";
mysql_query($sql, $yhteys) or die('Virhe!');
mysql_close($yhteys);
header("location:kirjautuminen.php");
?>