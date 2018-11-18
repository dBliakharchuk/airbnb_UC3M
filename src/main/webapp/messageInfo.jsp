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
	<link rel="stylesheet" href="css/reservation.css" type="text/css"/>
	<link rel="stylesheet" href="css/payment.css" type="text/css"/>


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
<%-- 			<% --%>
// 			String emailOfLoggedUser = (String) request.getSession().getAttribute("emailOfLoggedUser"); 		
<%-- 			if (emailOfLoggedUser != null) { %> --%>
<%-- 				<jsp:include page="headerLogin.jsp"/>  --%>
<%-- 			<% } else {  --%>
// 				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); 
// 				dispatcher.forward(request, response); 
<%-- 			}%> --%>
<!-- 			<script type="text/javascript"> -->
// 				document.getElementById("tab-messages").classList.add("active");
<!-- 			</script> -->

			<!-- end:header-top -->
			
			
		 <div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/cover_bg_5.jpg);">
				<div class="desc">
					<div class="container">
						<div id="reservation-container">
							<div>
								<span id="reservation-header">Message</span>
							</div>
							<div id="message-box">
								<br/>
								<form action="transfers" method="post">
								<div class="col-xxs-12 col-xs-12 mt">
									<div class="input-field">
										<label for="from">Sender mail:</label>
										<input type="text" class="form-control" name="senderMail" placeholder=""/>
									</div>
								</div>
								<div class="col-xxs-12 col-xs-12 mt">
									<div class="input-field">
										<label for="from">Receiver mail:</label>
										<input type="text" class="form-control" name="receiverMail" placeholder=""/>
									</div>
								</div>
								<div class="col-xxs-12 col-xs-12 mt">
									<div class="input-field">
										<label for="from">Message:</label>
										<input type="text" class="form-control" name="message" placeholder=""/>
									</div>
								</div>
<!-- 								<div class="col-xxs-12 col-xs-12 mt"> -->
<!-- 									<div class="input-field"> -->
<!-- 										<label for="from">Message:</label> -->
<!-- 										<span class="description"> -->
<!-- 											<p>fdsfsdfsdsdfsddfsdfd</p>  -->
<!-- 				                        </span> -->
<!-- 									</div> -->
<!-- 								</div> -->
                           			<input type="submit" class="btn btn-primary payment-button" value="Reply">
                       			</form>
								<form action="reservations" method="get">
									<input type="submit" class="btn btn-primary payment-button" value="Cancel">
								</form>
							</div>
						</div>
					</div>
				</div>
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
