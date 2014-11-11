<?php
include ('yhteys.php');
mysql_select_db("Kurssit", $yhteys);

if(isset($_POST['poista'])){
	foreach($_POST['poista'] as $value){
       	$sql = "DELETE FROM valinnat WHERE kayttaja='$tunnus' AND kurssi_id='$value'";
      		$onnistuiko = mysql_query($sql, $yhteys);
	}
       if ($onnistuiko){
       	echo "<meta http-equiv=\"refresh\" content=\"0;URL=index.php\">";
       }
}

mysql_close($yhteys);
?>
