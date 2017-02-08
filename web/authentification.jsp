
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BoekenMarkt.com</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/orman.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />	

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js"></script>

<script language="javascript" type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="js/slimbox2.js"></script> 
<!--  t e m p l a t e m o  372  t i t a n i u m  -->
</head>
<body>
<div id="templatemo_wrapper">
	<div id="templatemo_header">
    	<div id="site_title"><a href="#">BoekenMarkt.com</a></div>    	
    </div><!-- END of templatemo_header -->
    <div id="templatemo_menu" class="ddsmoothmenu">        
        <br style="clear: left" />
    </div> <!-- end of templatemo_menu -->
    <div id="templatemo_slider">
    	 <div class="slider-wrapper theme-orman">
		<div id="slider" class="nivoSlider">
       	  <img src="images/boekenbeurs.jpg" />
          <img src="images/cvoantwerpen.PNG" />
          <img src="images/moodle.PNG" />
        </div>
            <div class="nivo-controlNav-bg"></div>
      </div> 
		<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript">
        $(window).load(function() {
            $('#slider').nivoSlider({
				controlNav:true
			});
        });
        </script>
    </div><!-- END of templatemo_slider -->
    <div id="templatemo_main">    
    <form id="login_form" action="/Web_BoekenMarkt/LogInServlet" method="POST">
    <table id="loginTable">
    	<tr><td></td><td><h2>Login</h2></td></tr>
        <% if(session.getAttribute("errorMessage").equals("verkeerde login")){
            %><tr><td><font color="red">Login is verkeerd.</font></td><td><font color="red">Probeer opnieuw</font></td></tr><%
        }
        %>
        <tr><td>Gebruikersnaam:</td><td><input type="text" name="userName" value=""></input></td></tr>
        <tr><td>Wachtwoord:</td><td><input type="password" name="password" value=""></input></td></tr>
        <tr ><td></td><td><input type="submit" value="Login" id="submitbtn"></input></td></tr>
    </table>
    </form>	     
        </div>                 
    </div><!-- END of templatemo_main -->
<div id="templatemo_bottom_wrapper">
	<div id="templatemo_bottom">
    	<div class="col one_fourth">
            <h4>Disclaimer</h4>
            <p>
            Alleen leerlingen van het CVO Antwerpen krijgen toegang tot deze website. In geen enkel geval is het CVO verantwoordelijk voor de transacties die via deze website zullen plaatsvinden. </p>
        </div>
	<div class="col one_fourth">
            <ul class="no_bullet"><li></li></ul>
    </div>
    <div class="col one_fourth">
    <ul class="no_bullet"><li></li></ul>
    </div>
    <div class="col one_fourth no_margin_right">
    	<h4>Sociale netwerk sites</h4>
        <ul class="no_bullet">
        	<li><a href="https://twitter.com/cvoantwerpen">Twitter</a></li>
            <li><a href="https://www.facebook.com/cvoAntwerpen">Facebook</a></li>
            <li><a href="http://www.cvoantwerpen.be/home/">CVO Antwerpen</a></li>
        </ul>
    </div>
        
        <div class="clear"></div>
    </div><!-- END of templatemo_bottom -->
    </div><!-- END of templatemo_bottom_wrapper -->    
<div id="templatemo_footer_wrapper">    
    <div id="templatemo_footer">
    	<p>Copyright © 2017 CVO Antwerpen</p>
    </div><!-- END of templatemo_footer -->
</div><!-- END of templatemo_footer_wrapper -->
</body>
</html>