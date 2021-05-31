$( function() {
	var URL = "http://localhost:8888/GestionCompteWeb/rest/clients/clients";
	$.ajax({
		datatype: "json",
		url: URL,
		success:success
	});});

function success(clients)
{
	var data = [];
	$.each(clients, function(index,value)
	{
		var item1={};
		
		item1["value"] = value.cin;
		data.push(item1);
	});
	$('#cinClients').autocomplete({ 
	     source: data,
	     change: function (event, ui) { alert(ui.item.cin); } });
}

	
	
	
	