
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->




 <%@ page import="model.*" %>
 <%@ page import=" java.util.*"%>
 


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>TIWbnb</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content="" />
	<meta property="og:image" content="" />
	<meta property="og:url" content="" />
	<meta property="og:site-name" content="" />
	<meta property="og:description" content="" />
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link
		href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
		rel='stylesheet' type='text/css'>

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
	<link rel="stylesheet" href="css/administrator.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script type="text/javascript" src="js/administrator.js"></script>

	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
		<script src="js/respond.min.js"></script>
		<![endif]-->

</head>
<body>


</head>
<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">

			<header id="fh5co-header-section" class="sticky-banner">
				<div class="container">
					<div class="nav-header">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
						<h1 id="fh5co-logo"><a href="index.jsp"><i class="icon-airplane"></i>TIWbnb <p id="administrator-header">Administator </p></a></h1>

						<!-- START #fh5co-menu-wrap -->
						<nav id="fh5co-menu-wrap" role="navigation">
							<ul class="sf-menu" id="fh5co-primary-menu">
								<li ><a href="administatorUsers">Users</a></li>
								<li class="active"><a href="trips">Homes</a></li>
								<li ><a href="messages.jsp">Messages</a></li>
								<li><a href="#" id="Log-Out">Log out</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>




			<div class="fh5co-hero">
				<div class="fh5co-overlay"></div>
				<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/cover_bg_5.jpg);">
					<div class="desc">
						<div class="container" id="search-place-form-container">
							<form class="search-form" action="index.html" method="post">
								<input type="text" class="search-form-input" id="from-place-name" placeholder="Place Name"/>
								<input type="submit" class="search-form-submit" value="search"/>
							</form>
						 </div>
						 <div class="container" id="places-panel">
						 	<div id="left-panel" class="panel-containter">
								<div class="place-cel">
									<div class="place-email-field">
											Host Email
									</div>
									<div class="place-name-field">
											Apartment Name
									</div>
								</div>
								
								
								
								<%

									ArrayList<Apartment> apartments = (ArrayList<Apartment>)request.getAttribute("apartments");

									
									for (int i = 0; i < apartments.size(); i++)
									{ %>
										<div class="place-cel">
											<div class="place-email-field">
												<%= apartments.get(i).getHost().getEmail() %>
											</div>
											<div class="place-name-field">
												<%= apartments.get(i).getName() %>
											</div>
										</div>
									
									
									<% } %> 
																	
								



						 	</div>
							<div id="midle-panel" class="panel-containter">
								<label for="name">Apartment Name</label>
								<input type="text" name="name" value="" >
								<label for="host-email">Host Email</label>
								<input type="email" name="host-email" value="" >
								<label for="localization">Localization</label>
								<input type="text" name="localization" value="" >
								<label for="price-per-day">Price Per Day</label>
								<input type="number" name="price-per-day" value="" >
								<label for="type-of-apartment">Type Of Apartment</label>
								<input type="text" name="type-of-apartment" value="" >
								<label for="beds-adult">Adults Beds</label>
								<input type="number" name="beds-adult" value="" >
								<label for="beds-child">Children Beds</label>
								<input type="number" name="beds-child" value="" >
								<label for="description">Description</label>

								<textarea id="place-description" name="description"> </textarea>
								<button type="button" class="btn btn-success" id="save-place-button">Save</button>
								</div>
								<div id="right-panel" class="panel-containter">

								<button type="button" class="btn btn-success" onclick="messageUser()">Messag Host</button>
								<button type="button" class="btn btn-danger" onclick="deletePlace()" >Delete Place</button>

						 	</div>
						 </div>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
