$(document).ready(function(){
	var table = $('#tabla').DataTable({
		dom: 'ftp',
		ajax: {
			url: diccionario.pageContext + "/usuario/listausuarios",
			dataSrc: ''
		},
		order: [[ 1, "asc" ]],
		language: {
			"oPaginate": {
		        "sFirst":    diccionario.tablaPrimero,
		        "sLast":     diccionario.tablaUltimo,
		        "sNext":     diccionario.tablaSiguiente,
		        "sPrevious": diccionario.tablaAnterior
		    },
		},
		columns: [
			{
				orderable: false,
				render: function(data, type, full, meta){
					return '<a data-idusuario="'+full.id+'" class="editar_usuario"><span class="fa fa-pencil"></span> </a>'+
							'<a data-iusuariod="'+full.id+'" class="eliminar_usuario"><span class="fa fa-eraser"></span></a>';
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.nombre != undefined){
						return full.nombre;
					}
					return " ";
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.usaClave){
						return diccionario.usuarioPrivacidadActivada
					}
					return diccionario.usuarioPrivacidadDesactivada;
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.fechaNacimiento != undefined){
						return full.fechaNacimiento;
					}
					return " ";
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.dni != undefined){
						return full.dni;
					}
					return " ";
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.pasaporte != undefined){
						return full.pasaporte;
					}
					return " ";
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.segSocial != undefined){
						return full.segSocial;
					}
					return " ";
				}
			},
			{
				render: function(data, type, full, meta){
					if(full.grupoSanguineo != undefined){
						return full.grupoSanguineo;
					}
					return " ";
				}
			}
		]
	});
	
	$('body').on('click', '.editar_usuario', function(){
		
	})
	
});




