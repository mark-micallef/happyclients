<%@ page import="com.mea.happyclients.users.User" %>

<%@include file="header.jsp" %>


<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
<title>The Happy Client</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="stylesheets/foundation.min.css">
<link rel="stylesheet" href="stylesheets/main.css">
<link rel="stylesheet" href="stylesheets/app.css">
<script src="javascripts/modernizr.foundation.js"></script>
<link rel="stylesheet" href="ligature/ligature.css">
<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Playfair+Display:400italic' rel='stylesheet' type='text/css' />
<!-- IE Fix for HTML5 Tags -->
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
<!-- ######################## Main Menu ######################## -->
<nav>
  <div class="twelve columns header_nav">
    <div class="row">
      <ul id="menu-header" class="nav-bar horizontal">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li class="has-flyout"> <a href="#">Example Pages</a><a href="#" class="flyout-toggle"></a>
          <ul class="flyout">
            <!-- Flyout Menu -->
            <li class="has-flyout"><a href="blog.html">Blog</a></li>
            <li class="has-flyout"><a href="blog-single.html">Blog Single Page</a></li>
            <li class="has-flyout"><a href="products-page.html">Products Page</a></li>
            <li class="has-flyout"><a href="product-single.html">Product Single</a></li>
            <li class="has-flyout"><a href="pricing-table.html">Pricing Table</a></li>
            <li class="has-flyout"><a href="contact.html">Contact Page</a></li>
          </ul>
        </li>
        <!-- END Flyout Menu -->
        <li ><a href="galleries.html">Boxed Gallery</a></li>
        <li ><a href="portfolio.html">Portfolio Gallery</a></li>
        <% if (loggedUser == null) {%>
        <li ><a href="register.jsp">Register</a></li>
        <li ><a href="login.jsp">Log In</a></li>
        <% } else { %>
        <li ><a href="profile.jsp">Profile</a></li>
        <li ><a href="logout.jsp">Log Out</a></li>
        <%}%>
      </ul>
      <script>$('ul#menu-header').nav-bar();</script>
    </div>
  </div>
</nav>
<!-- ######################## Header ######################## -->
<header>
  <h1 class="heading_supersize">The Happy Client</h1>
  <h2 class="welcome_text">Help your business prosper with our Client Happiness Solutions!</h2>
</header>
<!-- ######################## Section ######################## -->
<section class="section_light">
  <div class="row">
    <div class="four columns">
      <h3><span class="dropcap_red lsf-icon-dropcap" title="camera"></span>Your clients are busy</h3>
      <p>Every minute clients spend waiting at your establishment is a minute they could have spent doing something more valuable to them.  Minimising waiting time will make clients happier.</p>
    </div>
      <div class="four columns">
      <h3><span class="dropcap_black lsf-icon-dropcap" title="cloud"></span>Your clients want visibility</h3>
      <p>Customers crave visibility into their orders.  Be it waiting for a table to become available, their turn for a haircut or where their taxi has arrived, customers who know what it going on will be less anxious and more happy overall.  </p>
    </div>
    <div class="four columns">
      <h3><span class="dropcap_black lsf-icon-dropcap" title="video"></span>Your clients have access to technology</h3>
      <p>Your clients have mobile devices which can be used to satisfy their needs for more efficient service and visibility.  We harness this technology for your business at an incredible value for money.</p>
    </div>
  </div>
</section>
<!-- ######################## Section ######################## -->
<section  class="section_dark">
  <div class="row">
    <h2>Latest Photos by Our Members</h2>
    <div class="two columns"> <a href="#" class="th"><img src="images/thumb1.jpg" width="100" height="100" alt=""></a> </div>
    <div class="two columns"> <a href="#" class="th"><img src="images/thumb2.jpg" width="100" height="100" alt=""></a> </div>
    <div class="two columns"> <a href="#" class="th"><img src="images/thumb3.jpg" width="100" height="100" alt=""></a> </div>
    <div class="two columns"> <a href="#" class="th"><img src="images/thumb4.jpg" width="100" height="100" alt=""></a> </div>
    <div class="two columns"> <a href="#" class="th"><img src="images/thumb5.jpg" width="100" height="100" alt=""></a> </div>
    <div class="two columns"> <a href="#" class="th"><img src="images/thumb6.jpg" width="100" height="100" alt=""></a> </div>
  </div>
</section>
<!-- ######################## Section ######################## -->
<section class="section_main">
  <h2 style="text-align:center">Discover Hidden Treasures</h2>
  <div class="row">
    <article class="six columns">
      <div class="panel">
        <h3>Lorem Ipsum</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec cursus fermentum metus, id commodo sapien. Donec cursus fermentum metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec cursus fermentum metus, id commodo sapien. Donec cursus fermentum metus.</p>
        <a href="#" class="button secondary small radius">Learn More &raquo;</a> </div>
    </article>
    <article class="six columns">
      <div class="panel">
        <h3>Lorem Ipsum</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec cursus fermentum metus, id commodo sapien. Donec cursus fermentum metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec cursus fermentum metus, id commodo sapien. Donec cursus fermentum metus.</p>
        <a href="#" class="button secondary small radius">Learn More &raquo;</a> </div>
    </article>
  </div>
</section>
<!-- ######################## Footer ######################## -->
<footer>
  <div class="row">
    <div class="twelve columns footer"> <a href="#" class="lsf-icon" style="font-size:16px; margin-right:15px" title="twitter">Twitter</a> <a href="#" class="lsf-icon" style="font-size:16px; margin-right:15px" title="facebook">Facebook</a> <a href="#" class="lsf-icon" style="font-size:16px; margin-right:15px" title="pinterest">Pinterest</a> <a href="#" class="lsf-icon" style="font-size:16px" title="instagram">Instagram</a> </div>
  </div>
</footer>
<!-- ######################## Scripts ######################## -->
<!-- Included JS Files (Compressed) -->
<script src="javascripts/foundation.min.js"></script>
<!-- Initialize JS Plugins -->
<script src="javascripts/app.js"></script>
</body>
</html>