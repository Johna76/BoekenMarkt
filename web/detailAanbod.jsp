
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DAL.AangebodenBoek"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<script type="text/javascript" src="js/ddsmoothmenu.js">
</script>

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
        <ul>
            <li><a href="/Web_BoekenMarkt/ListAangBoekenServlet" class="selected">Home</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="/Web_BoekenMarkt/ZoekpgWeegevenServlet">Zoek</a></li>
            <li><a href="/Web_BoekenMarkt/NieuwBoekStp1Servlet">Verkoop boek</a></li>
            <li><a href="/Web_BoekenMarkt/OverzichtMijnBoekenServlet">Mijn boeken</a></li>
            <li><a href="contact.html">Contact</a></li>
        </ul>
        <br style="clear: left" />
    </div> <!-- end of templatemo_menu -->
    <div id="templatemo_main">
   	<h1>Detail Aangeboden Boek</h1>         
        <div id="detail">
            <% AangebodenBoek aangBoek = (AangebodenBoek)session.getAttribute("aangBoek");
            String datum = DateFormat.getDateInstance(DateFormat.DEFAULT).format(aangBoek.getDatum());
            String locatieAfb = aangBoek.getBoekID().getAfbeelding();
            %>
        <img id="afb_boek" src="images/background.jpg" alt="" width="200" height="100" />
        <table width="400" id="DetailList"> 
            <tr>
              <td>Titel:</td><td><%= aangBoek.getBoekID().getTitel()%></td>
            </tr>
            <tr>
              <td>Auteur:</td><td><%= aangBoek.getBoekID().getAuteur()%></td>
            </tr>
            <tr>
              <td>Isbn:</td><td><%= aangBoek.getBoekID().getIsbn()%></td>              
          	</tr>
            <tr>
             <td>Richting:</td><td><%= aangBoek.getBoekID().getRichting()%></td>
            </tr>
            <tr>
              <td>Conditie:</td><td><%= aangBoek.getConditie()%></td>
            </tr>
            <tr>
              <td>Prijs:</td><td><%= aangBoek.getPrijs()%> EUR</td> 
            </tr>
            <tr>
              <td>Geplaatst op:</td><td><%= datum%></td>
            </tr>
            <tr>
                <td>Omschrijving:</td><td><%= aangBoek.getOmschrijving()%></td>
            </tr>
            <tr>
                <td>
                    <form action="confirmation.html" method="POST" id="verzenden">                        
                        <input type="submit" value="Email verzenden">
                </td>
                <td>
                        <input type="hidden" name="AangBoekId" value="<%= aangBoek.getId()%>">
                    </form>
                </td>
            </tr>
        </table>
        </div>        
        <div class="clear"></div>
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