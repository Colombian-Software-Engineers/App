package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.Empleado;
import com.ColombianSoftwareEngineers.APP.services.EmpleadoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    EmpleadoServices service;
    public EmpleadoController(EmpleadoServices services) {
        this.service = services;
    }

    @GetMapping("/empleado")
    public List<Empleado> EmpleadoList(){ return this.service.getEmpleadoList(); }
    @PostMapping("/empleado")
    public Empleado PostEmpleado(@RequestBody Empleado empleado){ return this.service.createOrUpdateEmpleado(empleado);}

    @GetMapping("/empleado/{id}")
    public Empleado EmpleadoById(@PathVariable Long id){ return this.service.getEmpleadoById(id); }
    @PatchMapping("/empleado/{id}")
    public Empleado PatchEmpleadoById(@PathVariable Long id, @RequestBody Empleado empleado){
        Empleado resultado = this.service.getEmpleadoById(id);
        resultado.setNombreEmpleado(empleado.getNombreEmpleado());
        resultado.setCorreoEmpleado(empleado.getCorreoEmpleado());
        resultado.setEmpresaEmpleado(empleado.getEmpresaEmpleado());
        resultado.setRolEmpleado(empleado.getRolEmpleado());
        return this.service.createOrUpdateEmpleado(resultado);
    }
    @DeleteMapping("/empleado/{id}")
    public String DeleteEmpleadoById(@PathVariable Long id){
        this.service.deleteEmpleadoById(id);
        return "Empleado eliminado";
    }

    // TODO sync empleado table with empresa and movimientos table
}
