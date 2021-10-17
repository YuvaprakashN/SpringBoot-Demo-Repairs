<%@ include file="common/header.jspf"%>
<%@ include file="common/UserNavigation.jspf"%>

<div class="container pb-4">
	<h1  class="pb-4">
		<center>
			<strong>Edit User Profile</strong>
		</center>
	</h1>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<form:form modelAttribute="useredit">


						<form:hidden path="id" />
						<form:hidden path="createdDate" />

						<div class="row">
							<div class="col-md">
								<div class="form-group">
									<form:label path="name">Name Of the User</form:label>
									<form:input path="name" type="text" class="form-control"
										value="${user.name}" required="required"
										placeholder="User Name" />
									<form:errors path="name" cssClass="text-warning"></form:errors>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md">
								<div class="form-group">
									<form:label path="password">Password</form:label>
									<form:input path="password" type="text" class="form-control"
										required="required" value="${user.password}" />
									<form:errors path="password" cssClass="text-warning" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md">
								<div class="form-group">
									<form:label path="confirmPassword">Confirm Password:</form:label>
									<form:input path="confirmPassword" type="text"
										class="form-control" required="required"
										value="${user.confirmPassword}" />
									<form:errors path="confirmPassword" cssClass="text-warning" />
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md">
								<div class="form-group">
									<form:label path="email">Email:</form:label>
									<form:input path="email" cssClass="form-control"
										required="required" type="email" value="${user.email}"
										placeholder="abc@abc.com" />
									<form:errors path="email" cssClass="text-warning"></form:errors>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md">
								<div class="form-group">
									<form:label path="phone">Phone Number:</form:label>
									<form:input path="phone" cssClass="form-control"
										required="required" type="text" value="${user.phone}"
										placeholder="10 digit phone number" />
									<form:errors path="phone" cssClass="text-warning"></form:errors>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md">
								<div class="form-group">
									<form:label path="address">Address</form:label>
									<form:textarea path="address" cssClass="form-control"
										required="required" type="text" value="${user.address}"
										placeholder="Please Enter the Address" />
									<form:errors path="address" cssClass="text-warning"></form:errors>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">

									<form:label path="city">City:</form:label>
									<form:select path="city" class="form-control"
										value="${user.city}">
										<c:forEach items="${city}" var="city">
											<form:option value="${city.id}" label="${city.cityName}"></form:option>
										</c:forEach>
										<form:errors path="city"></form:errors>
									</form:select>
								</div>
							</div>
						</div>

					<center>	<button class="btn-success btn">Save Changes</button></center>


			</form:form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>




<%@ include file="common/footer.jspf"%>