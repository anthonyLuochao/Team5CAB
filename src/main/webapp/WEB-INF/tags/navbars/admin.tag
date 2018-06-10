<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/navbars" prefix="nav" %>

 <nav class="navbar navbar-expand-lg">
		<a class="navbar-brand" href="/www/admin/welcome">CAB</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="justify-content-end collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="/www/admin/facility" role="button">
				Manage Facilities
				</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="bookingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Booking
				</a>
				<div class="dropdown-menu" aria-labelledby="bookingDropdown">
				<a class="dropdown-item" href="#">Make Booking</a>
				<a class="dropdown-item" href="#">Manage Bookings</a>
				</div>
			</li>
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="usersDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Users
				</a>
				<div class="dropdown-menu" aria-labelledby="usersDropdown">
				<a class="dropdown-item" href="#">Manage Users</a>
				<a class="dropdown-item" href="#">Search User</a>
				</div>
			</li>
			</ul>
			<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="">Logout</a></li> 
			</ul>
		</div>
</nav>