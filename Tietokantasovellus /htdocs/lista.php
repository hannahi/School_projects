<?php
include ('yhteys.php');

mysql_select_db("Kurssit", $yhteys);

echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";
?>
 <p class="otsikko1">I periodi</p>
 <p class="otsikko2">Perusopinnot</p>
<?php
$perus_1 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='1' AND taso='perus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($perus_1)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Aineopinnot</p>
<?php
$aine_1 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='1' AND taso='aine' ORDER BY nimi ASC");
while($row = mysql_fetch_array($aine_1)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Harjoitustyöt</p>
<?php
$harj_1 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='1' AND taso='harjoitus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($harj_1)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>

 <p class="otsikko1">II periodi</p>
 <p class="otsikko2">Perusopinnot</p>
<?php
$perus_2 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='2' AND taso='perus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($perus_2)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Aineopinnot</p>
<?php
$aine_2 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='2' AND taso='aine' ORDER BY nimi ASC");
while($row = mysql_fetch_array($aine_2)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Harjoitustyöt</p>
<?php
$harj_2 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='2' AND taso='harjoitus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($harj_2)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>

 <p class="otsikko1">III periodi</p>
 <p class="otsikko2">Perusopinnot</p>
<?php
$perus_3 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='3' AND taso='perus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($perus_3)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Aineopinnot</p>
<?php
$aine_3 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='3' AND taso='aine' ORDER BY nimi ASC");
while($row = mysql_fetch_array($aine_3)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Harjoitustyöt</p>
<?php
$harj_3 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='3' AND taso='harjoitus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($harj_3)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>

 <p class="otsikko1">IV periodi</p>
 <p class="otsikko2">Perusopinnot</p>
<?php
$perus_4 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='4' AND taso='perus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($perus_4)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Aineopinnot</p>
<?php
$aine_4 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='4' AND taso='aine' ORDER BY nimi ASC");
while($row = mysql_fetch_array($aine_4)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Harjoitustyöt</p>
<?php
$harj_4 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='4' AND taso='harjoitus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($harj_4)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>

 <p class="otsikko1">V periodi</p>
 <p class="otsikko2">Perusopinnot</p>
<?php
$perus_5 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='5' AND taso='perus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($perus_5)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Aineopinnot</p>
<?php
$aine_5 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='5' AND taso='aine' ORDER BY nimi ASC");
while($row = mysql_fetch_array($aine_5)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Harjoitustyöt</p>
<?php
$harj_5 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='5' AND taso='harjoitus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($harj_5)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>

 <p class="otsikko1">VI periodi</p>
 <p class="otsikko2">Perusopinnot</p>
<?php
$perus_6 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='6' AND taso='perus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($perus_6)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Aineopinnot</p>
<?php
$aine_6 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='6' AND taso='aine' ORDER BY nimi ASC");
while($row = mysql_fetch_array($aine_6)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
?>
 <p class="otsikko2">Harjoitustyöt</p>
<?php
$harj_6 = mysql_query("SELECT * FROM kurssi WHERE alkuperiodi='6' AND taso='harjoitus' ORDER BY nimi ASC");
while($row = mysql_fetch_array($harj_6)) {
?>
 <input type="checkbox" name="kurssi[]" value="<?php echo $row['id']; ?>"/><?php echo $row['nimi']; ?><br/>
<?php
}
mysql_close($yhteys);
?>
 <div id="lisaysnappi">
  <button type="submit" name="lahetä">Lisää</button>
 </div>
</form>

