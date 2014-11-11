<?php
include ('yhteys.php');
mysql_select_db("Kurssit", $yhteys);
$sql = "CREATE TABLE valinnat (kurssi_id MEDIUMINT,kayttaja varchar(45),kurssikoodi varchar(15),nimi varchar(120),lukukausi char,lukuvuosi smallint,alkuperiodi smallint,loppuperiodi smallint,op varchar(5), PRIMARY KEY (kurssi_id,kayttaja))";
mysql_query($sql, $yhteys);

if (isset($_POST['kurssi'])) {
	foreach($_POST['kurssi'] as $value){
       	$valitut = mysql_query("SELECT * FROM kurssi WHERE id=$value");
              $valittu = mysql_fetch_array($valitut);
              $sql = "INSERT INTO valinnat (kurssi_id,kayttaja,kurssikoodi,nimi,lukukausi,lukuvuosi,alkuperiodi,loppuperiodi,op) VALUES ($valittu[id],'$tunnus','$valittu[kurssikoodi]','$valittu[nimi]','$valittu[lukukausi]',$valittu[lukuvuosi],$valittu[alkuperiodi],$valittu[loppuperiodi],'$valittu[op]')";
              mysql_query($sql, $yhteys);
       }
}

mysql_close($yhteys);
?>
