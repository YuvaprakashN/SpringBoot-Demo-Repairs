<%@  include file="common/header.jspf"%>



<nav class="navbar navbar-expand-sm bg-secondary navbar-dark">
	<a class="navbar-brand" href="#"> Repair Service </a>

	<ul class="navbar-nav justify-content-end" style="width: 100%">

		<li class="nav-item"><a href="/userRegistrationPage"
			class="nav-link"><i class="fas fa-user-plus"></i>User
				Registration</a></li>

		<li class="nav-item"><a href="/loginPage" class="nav-link"><i
				class="fas fa-sign-in-alt"></i>User Login</a></li>

		<li class="nav-item"><a href="/workerRegistrationPage"
			class="nav-link"><i class="fas fa-user-plus"> </i>Worker
				Registration</a></li>

		<li class="nav-item"><a href="/showWorkerLogin" class="nav-link"><i
				class="fas fa-sign-in-alt"></i>Worker Login</a></li>

	</ul>

</nav>




<div class="container-fluid"
	style="padding-bottom: 30%; background-image: url('images/bgimg.png'); background-size: cover;">


<h1 style="padding-top: 5%;" class="display-1 text-white"><center><strong>Repair Service</strong></center></h1>

		<div class="card-deck" style="padding-top: 40%;">
			<div class="card bg-primary">
				<div class="card-body text-center">
					<p class="card-text">New User? <a href="/userRegistrationPage" class="text-dark"> Register here</a></p>
				</div>
			</div>
			<div class="card bg-success">
				<div class="card-body text-center">
					<p class="card-text">Existing User? <a href="/loginPage" class="text-dark"> Login here</a></p>
				</div>
			</div>
			<div class="card bg-primary">
				<div class="card-body text-center">
					<p class="card-text">Resister as Worker <a href="/workerRegistrationPage" class="text-dark">Click here</a></p>
				</div>
			</div>
			<div class="card bg-success">
				<div class="card-body text-center">
					<p class="card-text">Login as Worker <a href="/showWorkerLogin" class="text-dark">click here</a></p>
				</div>
		</div>
	</div>
</div>











<%@  include file="common/footer.jspf"%>