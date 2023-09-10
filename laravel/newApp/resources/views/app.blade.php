

<!DOCTYPE html>
<html>
<head>
<title>hola</title>
</head>
<body>

  <?php
  global $text;
  global $color;
  $text = "Hello World!";
  $color = "blue";
  $inputText = "foo";
  echo $text;
    function tweet(){
      return  "crazy";
      // $GLOBALS['text'] = "global";
      // echo $GLOBALS['text'] ;

    }
    $text = tweet();
    function mssg(){
      global $text;
      $text = "mssg function";
    }
    mssg();
    echo $text;
    function changeColor(){
      global $color;
      $color = "green";
    }

    echo $color;

    function Tag(){
      echo "<p> diantres </p>";
    }
  ?>
  <script type="text/javascript">

  alert("hola");

  </script>

  <button type="button" name="button" onclick="Tag()" > php value </button>

<h1 name="texto" id = "palabras"> User input !!!</h1>
<input type="text" name="inputTest" value= '{{$inputText}}' >
<p>{{$inputText}}</p>


<div class="dddd " style = "background-color: {{$color}};color: red;width: 200px; height: 200px"
  onclick = "changeColor()">
<p name = "divText" id = "fff">div</p>
</div>

<textarea name="name" rows="8" cols="80"> {{$inputText}}</textarea>

<?php
$divOut = Input::get('inputTest');
echo $divOut;
echo "not";

function alerta (){
  echo "button update";
}
 ?>

</body>
</html>
