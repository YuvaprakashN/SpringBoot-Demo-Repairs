<%@ include file="common/header.jspf"%>
<%@ include file="common/WorkerNavigation.jspf"%>

<div class="container">

	<h1>
		<center>
			<strong>Edit Worker Profile</strong>
		</center>
	</h1>

	<div class="row">
		<div class="col-md-3"></div>

		<div class="col-md-6">
			<form:form modelAttribute="workeredit">
				<form:hidden path="id" />
				<form:hidden path="createdDate" />
				<form:hidden path="bookings" />
				<form:hidden path="rating"/>
				<form:hidden path="costPerHour"/>

				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="name">Name Of the User:</form:label>
							<form:input path="name" type="text" class="form-control"
								required="required" placeholder="Please Enter the Name"
								value="${workeredit.name}" />
							<form:errors path="name" cssClass="text-warning"></form:errors>
						</div>
					</div>
				</div>



				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:input path="password" type="password" class="form-control"
								required="required" placeholder="Enter the Password"
								value="${workeredit.password}" />
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
								placeholder="Enter the Confirm password"
								value="${workeredit.confirmPassword}" />
							<form:errors path="confirmPassword" cssClass="text-warning" />
						</div>
					</div>
				</div>



				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="email">Email:</form:label>
							<form:input path="email" cssClass="form-control"
								required="required" type="email" placeholder="abc@abc.com"
								value="${workeredit.email}" />
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
								placeholder="Enter the 10 digit Number"
								value="${workeredit.phone}" />
							<form:errors path="phone" cssClass="text-warning" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<form:label path="address">Address</form:label>
							<form:input path="address" cssClass="form-control"
								required="required" type="text" placeholder="Enter theAddress"
								value="${workeredit.address}" />
							<form:errors path="address" cssClass="text-warning" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<form:label path="city">City:</form:label>
							<form:select path="city" class="form-control"
								value="${workeredit.city}">
								<c:forEach items="${city}" var="city">
									<form:option value="${city.id}" label="${city.cityName}"></form:option>
								</c:forEach>
								<form:errors path="city"></form:errors>
							</form:select>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<form:label path="profession">Profession:</form:label>
							<form:select path="profession" class="form-control"
								value="${workeredit.profession}">
								<c:forEach items="${professions}" var="profession">
									<form:option value="${profession.id}"
										label="${profession.professionName}"></form:option>
								</c:forEach>
								<form:errors path="profession"></form:errors>
							</form:select>
						</div>
					</div>
				</div>


				<center>
					<button class="btn-success btn">Save Changes</button>
				</center>
			</form:form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
