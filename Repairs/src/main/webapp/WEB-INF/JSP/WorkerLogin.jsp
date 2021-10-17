<%@ include file="common/header.jspf"%>



<div class="container pt-4 pb-5">


	
		<h1 class="pb-4"><strong><center>Repair Worker Login</center></strong></h1>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md">
			<form:form modelAttribute="workerLog">
				<form:input path="phone" value="1234567890" hidden="true" />
				<form:input path="address" value="qqqqqqqqqqqqqq" hidden="true" />
				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="email">Email:</form:label>
							<form:input path="email" type="text" class="form-control"
								placeholder="abc@abc.com" />
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md">

						<div class="form-group">
							<form:label path="password">Password:</form:label>
							<form:input path="password" type="password" class="form-control" />
							<form:errors path="password" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md">

						<div class="row">
							<div class="col-md">
								<button class="btn btn-primary">Login</button>
							</div>
							<div class="col-md">
								<button class="btn btn-primary" type="reset">Reset</button>
							</div>
						</div>
					</div>
				</div>
			</form:form>
			<br>
			<span>New to Repair Service?  </span><a href="/workerRegistrationPage"><button type="button" class="btn btn-primary">Sign up</button></a>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>


<%@ include file="common/footer.jspf"%>