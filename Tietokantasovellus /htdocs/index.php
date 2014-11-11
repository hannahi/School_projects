<?php
session_register();
session_start();
$tunnus = $_SESSION["tunnus"];
if ($tunnus == "") {
    header("Location: kirjautuminen.php");
    die();
}
?>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="kurssisuunnitelma.css" />
  <script src="skripti.js"></script>
  <title>Kurssisuunnitelma</title>
 </head>
 <body>
  <div id="ylapalkki">
   <h1>Kurssisuunnitelma</h1>
   <p id="tervehdys">Hei <?php echo $tunnus ?>! | <a class="palkkilinkki" href= "ulos.php" >Kirjaudu ulos</a></p>
  </div>
  <div id='lista'> 
<?php
include ('lista.php');
?>
  </div>
<?php
include ('lisaa.php');
include ('taulukot.php');
?>
 </body>
</html>

