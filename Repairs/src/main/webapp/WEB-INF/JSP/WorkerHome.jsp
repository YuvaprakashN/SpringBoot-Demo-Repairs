<%@ include file="common/header.jspf"%>
<%@ include file="common/WorkerNavigation.jspf" %>




<div class="container" style="padding-bottom: 20%;">
<h1><center><strong>Repair Service Booking</strong></center></h1>
	<div class="row">

		<table class="table">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Client Name</th>
					<th>Address</th>
					<th>Describtion</th>
					<th>Booked Date</th>
					<th>Status</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
			
			
				<c:forEach items="${bookingList}" var="book" varStatus="serial">
					<tr>
						<td>${serial.count}</td>
						<td>${ book.user.name}</td>
						<td>${book.user.address}</td>
						<td>${book.description}</td>
						<td><fmt:formatDate value="${book.bookedDate}"
								pattern="dd-MM-yyyy" /></td>
						<td>${book.status}</td>
						<c:if test="${book.status == 'pending'}">
							<td><a
								href="/bookingStatusUpdating?bookId=${book.id}&statusUpdate=confirm&user=false"><button
										class="btn btn-success" type="button">Confirm</button></a></td>
						</c:if>
						<c:if test="${book.status !='Cancelled' }">
							<td><a
								href="/bookingStatusUpdating?bookId=${book.id}&statusUpdate=cancel&user=false"><button
										class="btn btn-warning" type="button">Cancel</button></a></td>
						</c:if>
					</tr>
				</c:forEach>


			</tbody>




		</table>



	</div>


</div>


<%@ include file="common/footer.jspf"%>