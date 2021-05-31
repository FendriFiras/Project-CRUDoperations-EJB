/**
 * 
 */
function deleteProduct(index) {
	const swalWithBootstrapButtons = Swal.mixin({
		customClass: {
			confirmButton: 'btn btn-success',
			cancelButton: 'btn btn-danger'
		},
		buttonsStyling: false
	})

	swalWithBootstrapButtons.fire({
		title: 'Are you sure?',
		text: "You won't be able to revert this!",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: 'Yes, delete it!',
		cancelButtonText: 'No, cancel!',
		reverseButtons: true
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				url: 'ShopServlet',
				type: 'post',
				data: { 'index': index },
				success: function(total) {//total from shopServlet
					$('#tr' + index).remove();//remove lligne de la table avec id tr+index
					$('#total').html("le total=" + total);//affiche totale 
					swalWithBootstrapButtons.fire(
						'Deleted!',
						'Your file has been deleted :).',
						'success'
					)
				},
				error: function() {
					alert('error!');
				}
			});
		} else if (
			/* Read more about handling dismissals below */
			result.dismiss === Swal.DismissReason.cancel
		) {
			swalWithBootstrapButtons.fire(
				'Cancelled',
				'Your imaginary file is safe 🙂',
				'error'
			)
		}
	})
}