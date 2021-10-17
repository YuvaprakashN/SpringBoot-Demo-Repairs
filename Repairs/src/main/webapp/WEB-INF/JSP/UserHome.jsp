<%@ include file="common/header.jspf"%>
<%@ include file="common/UserNavigation.jspf" %>

<div class="container" style="padding-bottom: 20%;">
<center><h1><strong>Worker List</strong></h1></center>

	<div class="row">
		<div class="col-md-12">

			<div class="row justify-content-center">
				<form action="userHome" method="get" class="form-inline">

					<div class="mr-2">
						<label for="profession">Profession:</label> <select
							name="profession">
							<option>Select</option>

							<c:forEach items="${ professions}" var="profession">
								<option value="${profession.id}">${ profession.professionName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mr-2">
						<label for="location">Location:</label> <select name="location">
							<option>Select</option>
							<c:forEach items="${ city}" var="cit">
								<option value="${cit.cityName}">${cit.cityName}</option>

							</c:forEach>
						</select>
					</div>
					<div class="mr-2">
						<label for="costPerHour">CostPerHour: </label> 
						<select name="costPerHour">
						<option value="0">Select</option>
						<option value="1">0-200</option>
						<option value="2">201-400</option>
						<option value="3">401-600</option>
						<option value="4">601-800</option>
						<option value="5">801-1000</option>
						</select>
						
						
					</div>
					<div class="mr-2">
						<button type="submit" class="btn btn-success">Filter</button>
					</div>
				</form>
			</div>
			<div class="row">
				<table class="table table-striped table-bordered table-hover ">
					<thead class="thead-light">
						<tr>
							<th>S.no</th>
							<th>Worker Id</th>
							<th>Worker Name</th>
							<th>Profession</th>
							<th>Phone</th>
							<th>Address</th>
							<th>City</th>
							<th>Email</th>
							<th>Cost/hrs</th>
							<th>Rating</th>
							<th></th>
						</tr>
					</thead>


					<tbody>
						<c:forEach items="${workers}" var="worker" varStatus="serial">
							<tr>
								<td>${ serial.count}</td>
								<td>${worker.id}</td>
								<td>${worker.name}</td>
								<td>${worker.profession.professionName}</td>
								<td>${worker.phone}</td>
								<td>${worker.address}</td>
								<td>${worker.city.cityName}</td>
								<td>${worker.email}</td>
								<td>${worker.costPerHour}</td>
								<td>${worker.rating}</td>
								<td><a href="/bookWorker?worker=${worker.id}&user=${user.id}"><button class="btn btn-success" type="button">Book</button></a></td>
							</tr>

						</c:forEach>

					</tbody>



				</table>
			</div>
		</div>
	</div>


</div>




<%@ include file="common/footer.jspf"%>