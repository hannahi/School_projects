<?php
  include ('yhteys.php'); 
  mysql_select_db("Kurssit", $yhteys);

  $kayt = $tunnus;

  $result_1 = mysql_query("SELECT DISTINCT * FROM valinnat WHERE alkuperiodi='1' AND kayttaja='$kayt' ORDER BY nimi ASC");
  $result_2 = mysql_query("SELECT DISTINCT * FROM valinnat WHERE (alkuperiodi='2' OR loppuperiodi='2') AND kayttaja='$kayt' ORDER BY nimi ASC");
  $result_3 = mysql_query("SELECT DISTINCT * FROM valinnat WHERE alkuperiodi='3' AND kayttaja='$kayt' ORDER BY nimi ASC");
  $result_4 = mysql_query("SELECT DISTINCT * FROM valinnat WHERE (alkuperiodi='4' OR loppuperiodi='4') AND kayttaja='$kayt' ORDER BY nimi ASC");
  $result_5 = mysql_query("SELECT DISTINCT * FROM valinnat WHERE alkuperiodi='5' AND kayttaja='$kayt' ORDER BY nimi ASC");
  $result_6 = mysql_query("SELECT DISTINCT * FROM valinnat WHERE (alkuperiodi='6' OR loppuperiodi='6') AND kayttaja='$kayt' ORDER BY nimi ASC");
?>
  <div id="periodit">
   <form name="valitut">
    Valitse periodit: <input class="valinta" type="checkbox" name="p1" value="syksy_1" onclick="return validate(p1);"/> 1
    <input class="valinta" type="checkbox" name="p2" value="syksy_2" onclick="return validate(p2);"/> 2
    <input class="valinta" type="checkbox" name="p3" value="kevät_3" onclick="return validate(p3);"/> 3
    <input class="valinta" type="checkbox" name="p4" value="kevät_4" onclick="return validate(p4);"/> 4
    <input class="valinta" type="checkbox" name="p5" value="kesa_5" onclick="return validate(p5);"/> 5
    <input class="valinta" type="checkbox" name="p6" value="kesa_6" onclick="return validate(p6);"/> 6
   </form>
 </div>
 <div class="taulukot">
  <div class="taulu" id="p1" style="display: none">
<?php
   echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";

   $rivit = mysql_num_rows($result_1)+1;
   $sum_1 = mysql_query("SELECT SUM(op) AS total1 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='1' AND loppuperiodi='1'");
   $query_data = mysql_fetch_array($sum_1);
   $tot1 = $query_data["total1"];
   $sum_2 = mysql_query("SELECT SUM(op) AS total2 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='1' AND loppuperiodi='2'");
   $query_data = mysql_fetch_array($sum_2);
   $tot2 = $query_data["total2"];
   $totsub = $tot1 + ($tot2/2);
?>
   <table class="taulukko">
     <tr>
      <th rowspan="<?php echo $rivit; ?>" class="col0">Periodi I</th>
      <th class="col1">Kurssikoodi</th>
      <th class="col2">Nimi</th>
      <th class="col3">Alkaa</th>
      <th class="col4">Loppuu</th>
      <th class="col5">Op</th>
      <th rowspan="<?php echo $rivit; ?>" class="col6">Opintopisteet: <?php echo $totsub ?></th>
     </tr>
<?php
   while($r = mysql_fetch_array($result_1)) {
?>
     <tr>
      <td><input type="checkbox" name="poista[]" value="<?php echo $r['kurssi_id']; ?>"/><?php echo $r['kurssikoodi']; ?></td>
      <td><?php echo $r['nimi']; ?></td>
      <td><?php echo $r['alkuperiodi']; ?></td>
      <td><?php echo $r['loppuperiodi']; ?></td>
      <td><?php echo $r['op']; ?></td>
     </tr>
<?php
   }
?>
    </table>
    <div class="napit">
     <button name="delete" type="submit">Poista</button>
     <button onClick="window.open('lukujarjestys_1.php')">Lukujärjestys</button>
    </div>
   </form>
  </div>
<div class="taulu" id="p2" style="display:none">
<?php 
   echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";

   $rivit = mysql_num_rows($result_2)+1;
   $sum_1 = mysql_query("SELECT SUM(op) AS total1 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='2' AND loppuperiodi='2'");
   $query_data = mysql_fetch_array($sum_1);
   $tot1 = $query_data["total1"];
   $sum_2 = mysql_query("SELECT SUM(op) AS total2 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='1' AND loppuperiodi='2'");
   $query_data = mysql_fetch_array($sum_2);
   $tot2 = $query_data["total2"];
   $totsub = $tot1 + ($tot2/2);
?>
   <table class="taulukko">
     <tr>
      <th rowspan="<?php echo $rivit; ?>" class="col0">Periodi II</th>
      <th class="col1">Kurssikoodi</th>
      <th class="col2">Nimi</th>
      <th class="col3">Alkaa</th>
      <th class="col4">Loppuu</th>
      <th class="col5">Op</th>
      <th rowspan="<?php echo $rivit; ?>" class="col6">Opintopisteet: <?php echo $totsub ?></th>
     </tr>
<?php
   while($r = mysql_fetch_array($result_2)) {
?>
     <tr>
      <td><input type="checkbox" name="poista[]" value="<?php echo $r['kurssi_id']; ?>"/><?php echo $r['kurssikoodi']; ?></td>
      <td><?php echo $r['nimi']; ?></td>
      <td><?php echo $r['alkuperiodi']; ?></td>
      <td><?php echo $r['loppuperiodi']; ?></td>
      <td><?php echo $r['op']; ?></td>
     </tr>
<?php
   }
?>
    </table>
    <div class="napit">
      <button name="delete" type="submit">Poista</button>
      <button onClick="window.open('lukujarjestys_2.php')">Lukujärjestys</button>
    </div>
   </form>
  </div>
<div class="taulu" id="p3" style="display:none">
<?php
   echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";

   $rivit = mysql_num_rows($result_3)+1;
   $sum_1 = mysql_query("SELECT SUM(op) AS total1 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='3' AND loppuperiodi='3'");
   $query_data = mysql_fetch_array($sum_1);
   $tot1 = $query_data["total1"];
   $sum_2 = mysql_query("SELECT SUM(op) AS total2 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='3' AND loppuperiodi='4'");
   $query_data = mysql_fetch_array($sum_2);
   $tot2 = $query_data["total2"];
   $totsub = $tot1 + ($tot2/2);
?>
   <table class="taulukko">
     <tr>
      <th rowspan="<?php echo $rivit; ?>" class="col0">Periodi III</th>
      <th class="col1">Kurssikoodi</th>
      <th class="col2">Nimi</th>
      <th class="col3">Alkaa</th>
      <th class="col4">Loppuu</th>
      <th class="col5">Op</th>
      <th rowspan="<?php echo $rivit; ?>" class="col6">Opintopisteet: <?php echo $totsub ?></th>
     </tr>
<?php
   while($r = mysql_fetch_array($result_3)) {
?>
     <tr>
      <td><input type="checkbox" name="poista[]" value="<?php echo $r['kurssi_id']; ?>"/><?php echo $r['kurssikoodi']; ?></td>
      <td><?php echo $r['nimi']; ?></td>
      <td><?php echo $r['alkuperiodi']; ?></td>
      <td><?php echo $r['loppuperiodi']; ?></td>
      <td><?php echo $r['op']; ?></td>
     </tr>
<?php

   }
?>
    </table>
    <div class="napit">
     <button name="delete" type="submit">Poista</button>
     <button onClick="window.open('lukujarjestys_3.php')">Lukujärjestys</button>
    </div>
   </form>
  </div>
 <div class="taulu" id="p4" style="display:none">
<?php
   echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";

   $rivit = mysql_num_rows($result_4)+1;
   $sum_1 = mysql_query("SELECT SUM(op) AS total1 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='4' AND loppuperiodi='4'");
   $query_data = mysql_fetch_array($sum_1);
   $tot1 = $query_data["total1"];
   $sum_2 = mysql_query("SELECT SUM(op) AS total2 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='3' AND loppuperiodi='4'");
   $query_data = mysql_fetch_array($sum_2);
   $tot2 = $query_data["total2"];
   $totsub = $tot1 + ($tot2/2);
?>
   <table class="taulukko">
     <tr>
      <th rowspan="<?php echo $rivit; ?>" class="col0">Periodi IV</th>
      <th class="col1">Kurssikoodi</th>
      <th class="col2">Nimi</th>
      <th class="col3">Alkaa</th>
      <th class="col4">Loppuu</th>
      <th class="col5">Op</th>
      <th rowspan="<?php echo $rivit; ?>" class="col6">Opintopisteet: <?php echo $totsub ?></th>
     </tr>
<?php
   while($r = mysql_fetch_array($result_4)) {
?>
     <tr>
      <td><input type="checkbox" name="poista[]" value="<?php echo $r['kurssi_id']; ?>"/><?php echo $r['kurssikoodi']; ?></td>
      <td><?php echo $r['nimi']; ?></td>
      <td><?php echo $r['alkuperiodi']; ?></td>
      <td><?php echo $r['loppuperiodi']; ?></td>
      <td><?php echo $r['op']; ?></td>
     </tr>
<?php
   }
?>
    </table>
    <div class="napit">
     <button name="delete" type="submit">Poista</button>
     <button onClick="window.open('lukujarjestys_4.php')">Lukujärjestys</button>
    </div>
   </form>
  </div>
  <div class="taulu" id="p5" style="display:none">
<?php
   echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";

   $rivit = mysql_num_rows($result_5)+1;
   $sum_1 = mysql_query("SELECT SUM(op) AS total1 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='5' AND loppuperiodi='5'");
   $query_data = mysql_fetch_array($sum_1);
   $tot1 = $query_data["total1"];
   $sum_2 = mysql_query("SELECT SUM(op) AS total2 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='5' AND loppuperiodi='6'");
   $query_data = mysql_fetch_array($sum_2);
   $tot2 = $query_data["total2"];
   $totsub = $tot1 + ($tot2/2);
?>
   <table class="taulukko">
     <tr>
      <th rowspan="<?php echo $rivit; ?>" class="col0">Periodi V</th>
      <th class="col1">Kurssikoodi</th>
      <th class="col2">Nimi</th>
      <th class="col3">Alkaa</th>
      <th class="col4">Loppuu</th>
      <th class="col5">Op</th>
      <th rowspan="<?php echo $rivit; ?>" class="col6">Opintopisteet: <?php echo $totsub ?></th>
     </tr>
<?php
   while($r = mysql_fetch_array($result_5)) {
?>
     <tr>
      <td><input type="checkbox" name="poista[]" value="<?php echo $r['kurssi_id']; ?>"/><?php echo $r['kurssikoodi']; ?></td>
      <td><?php echo $r['nimi']; ?></td>
      <td><?php echo $r['alkuperiodi']; ?></td>
      <td><?php echo $r['loppuperiodi']; ?></td>
      <td><?php echo $r['op']; ?></td>
     </tr>
<?php
   }
?>
    </table>
     <div class="napit">
      <button name="delete" type="submit">Poista</button>
      <button onClick="window.open('lukujarjestys_5.php')">Lukujärjestys</button>
    </div>
   </form>
  </div>
  <div class="taulu" id="p6" style="display:none">
<?php
   echo "<form action='".$_SERVER['PHP_SELF']."' method='post'>";

   $rivit = mysql_num_rows($result_6)+1;
   $sum_1 = mysql_query("SELECT SUM(op) AS total1 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='6' AND loppuperiodi='6'");
   $query_data = mysql_fetch_array($sum_1);
   $tot1 = $query_data["total1"]; 
   $sum_2 = mysql_query("SELECT SUM(op) AS total2 FROM valinnat WHERE kayttaja='$kayt' AND alkuperiodi='5' AND loppuperiodi='6'");
   $query_data = mysql_fetch_array($sum_2);
   $tot2 = $query_data["total2"];
   $totsub = $tot1 + ($tot2/2);
?>
   <table class="taulukko">
     <tr>
      <th rowspan="<?php echo $rivit; ?>" class="col0">Periodi VI</th>
      <th class="col1">Kurssikoodi</th>
      <th class="col2">Nimi</th>
      <th class="col3">Alkaa</th>
      <th class="col4">Loppuu</th>
      <th class="col5">Op</th>
      <th rowspan="<?php echo $rivit; ?>" class="col6">Opintopisteet: <?php echo $totsub ?></th>
     </tr>
<?php
    while($r = mysql_fetch_array($result_6)) {
?>
     <tr>
      <td><input type="checkbox" name="poista[]" value="<?php echo $r['kurssi_id']; ?>"/><?php echo $r['kurssikoodi']; ?></td>
      <td><?php echo $r['nimi']; ?></td>
      <td><?php echo $r['alkuperiodi']; ?></td>
      <td><?php echo $r['loppuperiodi']; ?></td>
      <td><?php echo $r['op']; ?></td>
     </tr>
<?php
   }
?>
    </table>
    <div class="napit">
     <button name="delete" type="submit">Poista</button>
     <button onClick="window.open('lukujarjestys_6.php')">Lukujärjestys</button>
    </div>
   </form>
  </div>
 </div>

 </div>
<?php
   include 'poista.php';
   mysql_close($yhteys);
?>
