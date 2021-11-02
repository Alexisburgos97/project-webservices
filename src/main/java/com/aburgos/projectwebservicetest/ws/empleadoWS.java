package com.aburgos.projectwebservicetest.ws;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.aburgos.projectwebservicetest.entity.Empleado;
import com.aburgos.projectwebservicetest.service.EmpleadoService;

@Path("empleadoWS")
public class empleadoWS {
	
	private EmpleadoService empleadoService = new EmpleadoService();
	
	@GET
	@Path("test")
	public String test() {
		return "Probando webservices con Jersey" ;
	}
	
	@GET
	@Path("consultarEmpleado")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleadoService() {
		return this.empleadoService.consultarEmpleado();
	}
	
	@GET
	@Path("consultarEmpleados")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados(){
		return this.empleadoService.consultarEmpleados();
	}
	
	@GET
	@Path("consultarEmpleadoPorNumeroEmpleado/{numEmpleado}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorId(@PathParam("numEmpleado") String numEmpleado) {
		
		Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoPorNumeroEmpleado(numEmpleado);
		
		if(empleadoConsultado == null) {
			return Response.noContent().build();
		}
		
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado, Empleado.class);
		
		return Response.ok(empleadoGeneric).build();
	}
	
	
	@POST
	@Path("guardarEmpleado")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorId(Empleado empleado) {
		
		if(empleado == null) {
			return Response.status(400).entity("No se ingresó información del empleado").build();
		}
		
		if(empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre del empleado es requerido").build();
		}
		
		
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}

}
