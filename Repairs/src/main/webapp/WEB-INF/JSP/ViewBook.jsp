<%@ include file="common/header.jspf" %>
<%@ include file="common/UserNavigation.jspf" %>

<div class="container" style="padding-bottom: 20%">
<h1 class="pb-4"><strong><center>Booking Table</center></strong></h1>
<div class="row">
				<table class="table table-striped table-bordered table-hover ">
					<thead>
						<tr>
							<th>S.no</th>
							<th>Worker Name</th>
							<th>Profession</th>
							<th>Phone</th>
							<th>Description</th>
							<th>Booking Status</th>
							<th></th>
						</tr>
					</thead>


					<tbody>
						<c:forEach items="${bookings}" var="book" varStatus="serial">
							<tr>
								<td>${ serial.count}</td>
								<td>${book.worker.name}</td>
								<td>${book.worker.profession.professionName}</td>
								<td>${book.worker.phone}</td>
								<td>${book.description }</td>
								<td>${book.status}</td>
								<c:if test="${book.status !='Cancelled' }">
								<td><a href="/bookingStatusUpdating?bookId=${book.id}&statusUpdate=cancel&user=true"><button class="btn btn-warning" type="button">Cancel</button></a></td>
								</c:if>
							</tr>
						</c:forEach>

					</tbody>



				</table>
			</div>

</div>


<%@ include file="common/footer.jspf" %>