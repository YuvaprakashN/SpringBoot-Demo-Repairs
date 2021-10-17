<%@ include file="common/header.jspf"%>
<%@ include file="common/UserNavigation.jspf"%>


<div class="container" style="padding-bottom: 10%">

	<center>
		<h2>Book Worker</h2>
	</center>


	<form:form modelAttribute="book">
		<br>

		<input name="workerId" value="${bookedworker.id}" type="hidden">
		<form:input path="status" value="pending" type="hidden" />

		<div class="row">
			<div class="col-md-12">
				
					<div class="row ">
						<div class="col-md-8">
							<div class="form-group">
								<form:label path="bookedDate">Booking Date:</form:label>
								<form:input path="bookedDate" type="text" class="form-control"
									required="required" />
								<form:errors path="bookedDate" cssClass="text-warning" />
							</div>
						</div>
					</div>

				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
							<form:label path="description">Job Description:</form:label>
							<form:textarea path="description" required="required"
								class="form-control"
								placeholder="Please Enter the Job Description" />
							<form:errors path="description" cssClass="text-warning"/>
						</div>
					</div>
				</div>

				<div class="row">
					<a><button type="submit" class="btn btn-success">Book</button></a>
				</div>

			</div>
		</div>
	</form:form>

</div>
<%@ include file="common/footer.jspf"%>
<script>
	$('#bookedDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>