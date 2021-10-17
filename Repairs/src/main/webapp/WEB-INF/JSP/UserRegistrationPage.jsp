<%@ include file="common/header.jspf"%>

<div class="container pb-4">
	<h1>
		<center>
			<strong>User Registration Page</strong>
		</center>
	</h1>
	<div class="row pt-3" >
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form:form modelAttribute="userreg">


				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="name">Name Of the User: </form:label>
							<form:input path="name" type="text" class="form-control"
								required="required" placeholder="Please Enter the Name" />
							<form:errors path="name" cssClass="text-warning"></form:errors>
						</div>
					</div>
				</div>



				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:input path="password" type="password" class="form-control"
								required="required" placeholder="Enter the Password" />
							<form:errors path="password" cssClass="text-warning" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="confirmPassword">Confirm Password:</form:label>
							<form:input path="confirmPassword" type="password"
								class="form-control" required="required"
								placeholder="Enter the Confirm password" />
							<form:errors path="confirmPassword" cssClass="text-warning" />
						</div>
					</div>
				</div>



				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="email">Email:</form:label>
							<form:input path="email" cssClass="form-control"
								required="required" type="email" placeholder="abc@abc.com" />
							<form:errors path="email" cssClass="text-warning" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="phone">Phone Number:</form:label>
							<form:input path="phone" cssClass="form-control"
								required="required" type="text"
								placeholder="Enter the 10 digit Number" />
							<form:errors path="phone" cssClass="text-warning" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="address">Address</form:label>
							<form:input path="address" cssClass="form-control"
								required="required" type="text" placeholder="Enter theAddress" />
							<form:errors path="address" cssClass="text-warning" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="city">City:</form:label>
							<form:select path="city" class="form-control">
								<c:forEach items="${city}" var="city">
									<form:option value="${city.id}" label="${city.cityName}"></form:option>
								</c:forEach>
								<form:errors path="city"></form:errors>
							</form:select>
						</div>
					</div>
				</div>
				<center><button class="btn-success btn">Register</button></center>
				<div class="col-md-3"></div>
			</form:form>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>