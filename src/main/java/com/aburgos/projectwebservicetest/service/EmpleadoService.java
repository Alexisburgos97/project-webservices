package com.aburgos.projectwebservicetest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aburgos.projectwebservicetest.entity.Empleado;

public class EmpleadoService {
	
	public Empleado consultarEmpleado(){
		
		Empleado empleado = new Empleado();
		
		empleado.setNumEmpleado("1234");
		empleado.setNombre("alexis");
		empleado.setApellido("burgos");
		empleado.setEdad(24);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		return empleado;
	}
	
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados = new ArrayList<>();
		
		Empleado empleado1 = new Empleado();
		
		empleado1.setNumEmpleado("1234");
		empleado1.setNombre("alexis");
		empleado1.setApellido("burgos");
		empleado1.setEdad(22);
		empleado1.setFechaCreacion(LocalDateTime.now());
		
		Empleado empleado2 = new Empleado();
		
		empleado2.setNumEmpleado("33");
		empleado2.setNombre("Pedro");
		empleado2.setApellido("Lopez");
		empleado1.setEdad(33);
		empleado2.setFechaCreacion(LocalDateTime.now());
		
		empleados.add(empleado1);
		empleados.add(empleado2);
		
		return empleados;
		
	}
	
	public Empleado consultarEmpleadoPorNumeroEmpleado(String numeroEmpleado) {
		List<Empleado> empleadosConsultados = this.consultarEmpleados();
		
		for (Empleado empleadoConsultado : empleadosConsultados) {
			if(empleadoConsultado.getNumEmpleado().equals(numeroEmpleado)) {
				return empleadoConsultado;
			}
		}
		
		return null;
	}
	
	
}
