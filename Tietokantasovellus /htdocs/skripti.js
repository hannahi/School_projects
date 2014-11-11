window.addEventListener("load", sivuLadattu);
var taulukot = document.querySelectorAll(".taulu");
var indeksit = new Array();
indeksit.length = 6;

function sivuLadattu() {
 var taulukot = document.querySelectorAll(".taulu");
 var valinnat = document.querySelectorAll(".valinta");
 for(var i = 0; i < valinnat.length; i++) {
   var temp = i + 1;
   var item = "p" + temp.toString();
   var checkValue = sessionStorage.getItem(item);
    if(checkValue === "1") {

        taulukot[i].style.display = "";
	 valinnat[i].checked = 1;
    }
  }
}

function etsiIndeksi(n) {
 var taulukot = document.querySelectorAll(".taulu");
 for (var i = 0; i < taulukot.length; i++)
   if (taulukot[i].id === n) 
     return i;
 }

function validate(chk){
 var taulukot = document.querySelectorAll(".taulu");
 if (chk.checked == 1) {
    var indeksi = etsiIndeksi(chk.name);
    taulukot[indeksi].style.display="";
    indeksit[indeksi] = 1;
    console.log("indeksi: " + indeksit[indeksi]);
    sessionStorage.setItem(chk.name, 1);
 }
 if (chk.checked == 0) {
    var indeksi = etsiIndeksi(chk.name);
    taulukot[indeksi].style.display="none";
    indeksit[indeksi] = 0;
    console.log("indeksi: " + indeksi + " " + indeksit[indeksi]); 
    sessionStorage.setItem(chk.name, 0);
 }
}