<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="login.css" />
  <title>Kirjaudu</title>
 </head>
 <body>
  <div id="lomake">
   <h1>Kirjaudu sisään</h1>
   <form action="sisaan.php" method="post">
    <p>Tunnus: <br>
    <input type="text" name="tunnus">
    </p>
    <p>Salasana: <br>
    <input type="password" name="salasana">
    </p>
    <button type="submit" value="Kirjaudu">Kirjaudu</button>
    <button onClick="window.open('uusitunnus.php')">Luo tunnukset</button>
   </form>
  </div>
 </body>
</html>
