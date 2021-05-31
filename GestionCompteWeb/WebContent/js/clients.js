function deleteClient(cin){
	
	swal({
		  title: "Are you sure!",
		  text: "Once you deleted, you will not be able to recover this Client!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
  if (willDelete) {
	  $.ajax({
			url : "ClientServlet",
			type : "POST",
			data : {
			'delete' : "delete",
			cin : cin
			},
			success : function() {
			$("#" + cin).remove();
			swal("Client has been deleted!", {
			      icon: "success",
			    });
			},
			error : function() {
				alert("erreur");
				}
		
			});
    
  } else {
    swal("Client is safe!");
  }
});
	
	
}