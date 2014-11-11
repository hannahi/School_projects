<link rel="stylesheet" type="text/css" href="ajat.css" />

<?php
session_start();
$kayt = $_SESSION['tunnus'];
include ('yhteys.php');
mysql_select_db("Kurssit", $yhteys);
$result_ajat = mysql_query("SELECT * FROM ajat,valinnat WHERE kayttaja='$kayt' AND ajat.kurssikoodi = valinnat.kurssikoodi AND ajat.loppuperiodi='4' AND valinnat.loppuperiodi='4' AND nimi NOT LIKE '%itseopiskelu%'");

function whatDay($day) {
	if ($day == "MA") return "1";
	if ($day == "TI") return "2";
	if ($day == "KE") return "3";
	if ($day == "TO") return "4";
	if ($day == "PE") return "5";
};

$lukkari = array();
for ($c = 8; $c < 20; $c++) {
	$lukkari[c] = array();
	for ($r = 1; $r < 6; $r++) {
		$lukkari[$c][$r] = NULL;
	}
}

while ($row = mysql_fetch_array($result_ajat)) {
	$alku = $row['alkamisaika'];
	$loppu = $row['loppumisaika'];
	
	for ($i = $alku; $i < $loppu; $i++) {
		if ($lukkari[$i][whatDay($row['vkonpva'])] != NULL) {
			$lukkari[$i][whatDay($row['vkonpva'])] = $lukkari[$i][whatDay($row['vkonpva'])].'; '.$row['nimi'].', '.$row['opetustyyppi'].', '.$row['sali'];
		} else {
			$lukkari[$i][whatDay($row['vkonpva'])] = $row['nimi'].', '.$row['opetustyyppi'].', '.$row['sali'];
		}
	}
}

echo '<input class="nappula" type="button" value="[x] Sulje" onclick="window.close()">';

echo '<table class="lukkarit" border="1">';
echo '<tr>';
echo '<th class="pva">Klo</th>';
echo '<th class="pva">ma</th>';
echo '<th class="pva">ti</th>';
echo '<th class="pva">ke</th>';
echo '<th class="pva">to</th>';
echo '<th class="pva">pe</th>';
echo '<tr>';
for ($i = 8; $i < 20; $i++) {
echo '<tr>';
$temp = $i + 1;
echo '<td class="aika">'.$i.' - '.$temp.'</td>';
	for ($j = 1; $j < 6; $j++) { 
			echo '<td>'.$lukkari[$i][$j].'</td>';
	}
echo '</tr>';
}
echo '</table>';
?>
</div>

<?php
mysql_close($yhteys);
?>
