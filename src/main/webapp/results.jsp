
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

		<header id="fh5co-header-section" class="sticky-banner">
			<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
					<h1 id="fh5co-logo"><a href="index.jsp"><i class="icon-airplane"></i>TIWbnb</a></h1>
					<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li class="active"><a href="index.jsp">Home</a></li>
							<li ><a href="trips.jsp">Trips</a></li>
							<li ><a href="messages.jsp">Messages</a></li>                              
							<li><a href="#" id="Registro">Registration</a></li>                            
							<li><a href="#" id="Login">Log in</a></li>                            
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<!-- end:header-top -->

		<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Results</h3>
						<p>These are the results according to your selection</p>
					</div>
				</div>
				
				<div class="row row-bottom-padded-md">
				<%
				
						ArrayList<Apartment> apartments = (ArrayList<Apartment>)request.getAttribute("resultApartments");
							
							for (Apartment apartment : apartments)
							{ %>
								
							<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
							<div href="#"><img src="images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
 							<div class="desc">
								<span></span>
										<h3><%= apartment.getName() %></h3>
										<span><%= ApartmentLogic.correctApartmentTypeDisplay(apartment.getType().toString()) %></span> 
										<span class="price"><%= String.format ("%.2f", apartment.getPrice()) %></span>
										<form method="get">
											<input name="apartmentID" type="text" value="<%= apartment.getId() %>" hidden>
											<input type="submit" class="btn btn-primary btn-outline" value="Select">
<!-- 										 	<a class="btn btn-primary btn-outline" href="results">Select <i class="icon-arrow-right22"></i></a> -->
										</form>
									</div>
								</div>
							</div>
						<% } %>
<!-- 					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn"> -->
<!-- 						<div href="#"><img src="images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive"> -->
<!-- 							<div class="desc"> -->
<!-- 								<span></span> -->
<!-- 								<h3>Apartment in Sol</h3> -->
<!-- 								<span>Entire apartment, two beds</span> -->
<!-- 								<span class="price">60€</span> -->
<!-- 								<a class="btn btn-primary btn-outline" href="#">Select <i class="icon-arrow-right22"></i></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn"> -->
<!-- 						<div href="#"><img src="images/place-2.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive"> -->
<!-- 							<div class="desc"> -->
<!-- 								<span></span> -->
<!-- 								<h3>Apartment near Gran Via</h3> -->
<!-- 								<span>Entire apartment, one bed</span> -->
<!-- 								<span class="price">70€</span> -->
<!-- 								<a class="btn btn-primary btn-outline" href="#">Select <i class="icon-arrow-right22"></i></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn"> -->
<!-- 						<div href="#"><img src="images/place-3.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive"> -->
<!-- 							<div class="desc"> -->
<!-- 								<span></span> -->
<!-- 								<h3>Flat in front of the Royal Palace</h3> -->
<!-- 								<span>Entire loft, two beds</span> -->
<!-- 								<span class="price">80€</span> -->
<!-- 								<a class="btn btn-primary btn-outline" href="#">Select <i class="icon-arrow-right22"></i></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn"> -->
<!-- 						<div href="#"><img src="images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive"> -->
<!-- 							<div class="desc"> -->
<!-- 								<span></span> -->
<!-- 								<h3>Central and quiet</h3> -->
<!-- 								<span>Entire apartment, two beds</span> -->
<!-- 								<span class="price">65€</span> -->
<!-- 								<a class="btn btn-primary btn-outline" href="#">Select <i class="icon-arrow-right22"></i></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn"> -->
<!-- 						<div href="#"><img src="images/place-2.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive"> -->
<!-- 							<div class="desc"> -->
<!-- 								<span></span> -->
<!-- 								<h3>Stunning Apartment in Sol</h3> -->
<!-- 								<span>Entire apartment, two beds</span> -->
<!-- 								<span class="price">50€</span> -->
<!-- 								<a class="btn btn-primary btn-outline" href="#">Select <i class="icon-arrow-right22"></i></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn"> -->
<!-- 						<div href="#"><img src="images/place-3.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive"> -->
<!-- 							<div class="desc"> -->
<!-- 								<span></span> -->
<!-- 								<h3>Pretty Apartment in Plaza Mayor</h3> -->
<!-- 								<span>Entire apartment, one bed</span> -->
<!-- 								<span class="price">30€</span> -->
<!-- 								<a class="btn btn-primary btn-outline" href="#">Select <i class="icon-arrow-right22"></i></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>

			</div>
		</div>
            
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row row-bottom-padded-md">
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>About TIWbnb</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor enim et libero pharetra, Nam ipsum augue, eleifend ut dui eu, egestas malesuada velit. </p>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Lorem ipsum </h3>
							<ul>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Lorem ipsum </h3>
							<ul>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Lorem ipsum </h3>
							<ul>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Lorem ipsum </h3>
							<ul>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Lorem ipsum </h3>
							<ul>
								<li><a href="#">Xxxxx xxxx</a></li>
								<li><a href="#">Xxxxx xxxx</a></li>
							</ul>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</footer>

	

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
	
	<!-- Main JS -->
	<script src="js/main.js"></script>

        
    <script>
		
    </script>
        
	</body>
</html>
