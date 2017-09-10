$(document).ready(function(){
	var table = $('#tabla').DataTable({
		ajax: {
			url: diccionario.pageContext + "/usuario/listausuarios"
		},
		columns: [
			{
//				orderable: false,
//				render: function(data, type, full, meta){
//					return '<a><span class="glyphicon glyphicon-time"></span> </a><a><span class="glyphicon glyphicon-comment"></span></a>';
//				}
			},
			{
				'data': "nombre"
			},
			{
//				render: function(data, type, full, meta){
//					return '<a><span class="glyphicon glyphicon-time"></span></a>';
//				}
			},
			{
//				data: "fechaNacimiento"
			},
			{
				'data': "dni"
			},
			{
//				data: "pasaporte"
			},
			{
//				data: "segSocial"
			},
			{
//				data: "grupoSanguineo"
			},
			{
//				render: function(data, type, full, meta){
//					return '<a><span class="glyphicon glyphicon-time"></span></a>';
//				}
			}
		]
	});
});
