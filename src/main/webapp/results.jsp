
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
			if (emailOfLoggedUser != null) { 
				if (!emailOfLoggedUser.equals("admin")) {%>
				<jsp:include page="headerLogin.jsp"/> 
				<%} else { %>
				<jsp:include page="headerAdmin.jsp"/>
			<% } 
			} else {  %>
				<jsp:include page="headerLogout.jsp"/>
			<% } %>
			<script type="text/javascript">
				document.getElementById("tab-index").classList.add("active");
			</script>

			<!-- end:header-top -->

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
				ApartmentPK apartmentKey = null;		
				
				ArrayList<Apartment> apartments = (ArrayList<Apartment>)request.getAttribute("resultApartments");
					
					for (Apartment apartment : apartments)
					{ 
					
					apartmentKey = apartment.getId();%>
						
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
					<div href="#"><img src="images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<div class="desc">
						<span></span>
								<h3><%= apartment.getName() %></h3>
								<span><%= ApartmentLogic.correctApartmentTypeDisplay(apartment.getType().toString()) %></span> 
								<span class="price"><%= String.format ("%.2f", apartment.getPrice()) %></span>
								<form method="get">
									<input name="apartmentHost" type="text" value="<%= apartmentKey.getHost() %>" hidden>
									<input name="apartmentBuildingNumber" type="text" value="<%= apartmentKey.getBuildingNumber() %>" hidden>
									<input name="apartmentStreet" type="text" value="<%= apartment.getStreet() %>" hidden>
									<input name="apartmentFlatNumber" type="text" value="<%= apartment.getFlatNumber() %>" hidden>
									<input name="apartmentCity" type="text" value="<%= apartment.getCity() %>" hidden>
									<input type="submit" class="btn btn-primary btn-outline" value="Select">
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
		<!-- Login Modal -->
		<jsp:include page="loginWindow.jsp"></jsp:include>     
            
		<!-- Registro Modal -->
		<jsp:include page="registrationWindow.jsp"></jsp:include>
		
		<jsp:include page="footer.jsp"/>

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
          $(document).on('click', '#Login', function () {
              $("#loginModal").modal("show");
           });
          $(document).on('click', '#Registro', function () {
              $("#RegistroModal").modal("show");
           });
        
        $(document).on('click', '#goRegistroLogin', function () {
              $("#RegistroModal").modal("hide");
              $("#loginModal").modal("show");              
           });
		
    </script>
        
	</body>
</html>

