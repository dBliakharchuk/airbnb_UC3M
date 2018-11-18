<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->

<%@ page import="model.*" %>
<%@ page import=" java.util.*"%>
<%@ page import="logic.*" %>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>TIWbnb</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="css/superfish.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
	<!-- CS Select -->
	<link rel="stylesheet" href="css/cs-select.css">
	<link rel="stylesheet" href="css/cs-skin-border.css">
	
	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">

		<!-- start:header-top -->
			<%
			String emailOfLoggedUser = (String) request.getSession().getAttribute("emailOfLoggedUser"); 		
			if (emailOfLoggedUser != null) { %>
				<jsp:include page="headerLogin.jsp"/> 
				
			<% } else {  %>
				<jsp:include page="headerLogout.jsp"/>
			<% } %>
			<script type="text/javascript">
				document.getElementById("tab-index").classList.add("active");
			</script>

		<!-- end:header-top -->

		<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
		
				<div class="row">
					<% Apartment apartment = (Apartment)request.getSession().getAttribute("selectedApartment"); 
					
					ApartmentPK apartmentPK = apartment.getId();
					
					String loginError = (String)request.getAttribute("loginError");
					ApartmentPK apartmentKey = apartment.getId();
					String photoUrl = request.getContextPath() + "/apartmentsImages/" + apartmentKey.toUrl();

					if(loginError!=null){ %>
				
						<script type="text/javascript">
							alert("<%= loginError%>")
						</script>
					<% } %>
					<div class="col-md-12 animate-box">
						<h2 class="heading-title"><%= apartment.getName() %></h2>
					</div>
					<div class="col-md-6 animate-box">
                        <span class="description">
						<p><%= apartment.getDescription() %></p> 
                        </span>
                        <table class="table">
                            <tbody>
                            	<tr>
                                        <th scope="row">Address:</th>
                                        <td><span class="beds"><%= apartmentPK.getStreet() + " " + apartmentPK.getBuildingNumber() + "/" +apartmentPK.getFlatNumber() 
                                        							+ ", " + apartmentPK.getCity() +", " + apartment.getCountry()%></span></td>
                                </tr>
                                <tr>                                
                                    <th scope="row">Host:</th>
                                    <td><span class="host"><%= apartment.getHost().getName() + " " + apartment.getHost().getSurname() %></span></td>
                                </tr>
                                
                                <tr>                                
                                        <th scope="row">Price:</th>
                                    <td><span class="price"><%= String.format ("%.2f", apartment.getPrice()) %>€</span></td>
                                </tr>
                                <tr>
                                        <th scope="row">Beds:</th>
                                        <td><span class="beds"><%= apartment.getBedsAdult() + " for adults and " + apartment.getBedsChild() + " for children"%></span></td>
                                </tr>
                                <tr>
                                        <th scope="row">Type:</th>
                                        <td><span class="type">
                                        <%=  ApartmentLogic.correctApartmentTypeDisplay(apartment.getType().toString()) %>
                                       </span></td>
                                </tr>                               
                            </tbody>
                        </table>
                        	<form action="reservations" method="post">
                        	<div class="col-xxs-12 col-xs-6 mt">
                            	<input type="submit" class="btn btn-primary btn-block" value="Reservation">
                        	</div>
                        	</form>
                        <div class="col-xxs-12 col-xs-6 mt">
                            <input type="contact" class="btn btn-primary btn-block" value="Contact">
                        </div>
                                                                        
                    </div>
					<div class="col-md-6 animate-box">
						<img class="img-responsive" src=<%=photoUrl %> alt="travel">
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

                
	<!-- jQuery -->

	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/sticky.js"></script>

	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>
        
	</body>
</html>

