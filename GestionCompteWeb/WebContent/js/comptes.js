function deleteCompte(rib){
	
	swal({
		  title: "Are you sure!",
		  text: "Once you deleted, you will not be able to recover this Compte!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
  if (willDelete) {
	  $.ajax({
			url : "CompteServlet",
			type : "POST",
			data : {
			'delete' : "delete",
			rib : rib
			},
			success : function() {
			$("#" + rib).remove();
			swal("Your compte has been deleted!", {
			      icon: "success",
			    });
			},
			error : function() {
				alert("erreur");
				}
		
			});
    
  } else {
    swal("Your compte is safe!");
  }
});
	
	
}