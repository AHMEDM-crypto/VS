<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to e-School Learning at VU</title>
<style type="text/css">

		/* Layout */
		body {
			min-width: 630px;
		}

		#container {
			padding-left: 200px;
			padding-right: 190px;
		}
		
		#container .column {
			position: relative;
			float: left;
		}
		
        #container .row {
			position: relative;
			float: right;
		}
		#center {
			padding: 10px 20px;
			width: 100%;
		}
		
		#left {
			width: 180px;
			padding: 0 10px;
			right: 240px;
			margin-left: -100%;
		}
		
		#right {
			width: 130px;
			padding: 0 10px;
			margin-right: -100%;
		}
		
		#footer {
			clear: both;
		}
		
		/* IE hack */
		* html #left {
			left: 150px;
		}

		/* Make the columns the same height as each other */
		#container {
			overflow: hidden;
		}

		#container .column {
			padding-bottom: 1001em;
			margin-bottom: -1000em;
		}

		/* Fix for the footer */
		* html body {
			overflow: hidden;
		}
		
		* html #footer-wrapper {
			float: left;
			position: relative;
			width: 100%;
			padding-bottom: 10010px;
			margin-bottom: -10000px;
			background: #fff;
		}

		/* Aesthetics */
		body {
			margin: 0;
			padding: 0;
			font-family:Sans-serif;
			line-height: 1.5em;
		}
		
		p {
			color: #555;
		}

		nav ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}
		
		nav ul a {
			color: darkgreen;
			text-decoration: none;
		}

		#header, #footer {
			font-size: large;
			padding: 0.3em;
			background: #BCCE98;
		}

		#left {
			background: #DAE9BC;
		}
		
		#right {
			background: #F7FDEB;
		}

		#center {
			background: #fff;
		}

		#container .column {
			padding-top: 1em;
		}
		
        #header-image-menu{
            top: 10px;
            position: relative;
        }
 
        #header-image-menu img{
            width: 100%;
            margin: none;
            padding: none;
        }
 
        #image-text{
            position: absolute;
            top: 20%;
            left: 50%;
            font-family: 'Roboto';
            color: #000;
            transform: translate(-30%, -30%);
            text-align: center;
        }
	</style>
</head>
<body>
<header id="header">
		
	
	<!-- Image menu in Header to contain an Image and
		a sample text over that image -->
	<div id="header-image-menu">
		<img src="https://www.vu.edu.pk/images/home/Sliders/banner3.jpg">
		<h2 id = "image-text">
			Virtual University Project e-School
		</h2>
	</div>
</header>


	<div id="container">

		<main id="center" class="column">
			<article>
			
				<h1>Welcome to eSchool Home</h1>
				<p>In one learning platform, watch your math or chemistry lectures. eSchool is a digital platform offering students, parents and educators a virtual approach of learning </p><p>Perhaps most importantly, eSchool makes distance learning relevant to everyday life<p>Welcome and Enjoy Learning.</p><h3>Our Guiding Principles</h3><p>The most important moment of your life is now. The most important person in your life is the one you are with now, and the most important activity in your life is the one you are involved with right now."</p>
			
			</article>								
		</main>

		<nav id="left" class="column">
			<h3>Academics</h3>
			<ul>
				<li><a href="#">Register for Classes</a></li>
				<li><a href="#">Tuition and Fee</a></li>
				<li><a href="#">Records</a></li>
				<li><a href="#">Faculty & Staff Directory</a></li>
				<li><a href="#">About eSchool</a></li>
			</ul>
			<h3>Resources</h3>
			<ul>
				<li><a href="#">Academic Calendar</a></li>
				<li><a href="#">Student Handbook</a></li>
				<li><a href="#">Catalog</a></li>
			</ul>

		</nav>

		<div id="right" class="column">
		    <h3>Login</h3>
			<ul>
				<li><a href="#">Student Login</a></li>
				<li><a href="FacultyServlet">Faculty Login</a></li>
				<li><a href="UserServlet">Register</a></li>
			</ul>
		</div>

	</div>

	<div id="footer-wrapper">
		<footer id="footer"><p style="font-style: italic;font-size:11px;">Equal Opportunity Institution:eSchool is an affirmative action/equal opportunity employer.</p></footer>
	</div>

</body>

</html>