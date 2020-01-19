package com.neocredit.neocredit.controller;

import com.neocredit.neocredit.model.Empresa;
import com.neocredit.neocredit.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresa){
        try{
            return new ResponseEntity<Empresa>(service.save(empresa), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Empresa>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> get(){
        try{
            return new ResponseEntity<List<Empresa>>(service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Empresa>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<Empresa>(service.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Empresa>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        try{
            service.delete(id.longValue());
            return new ResponseEntity<String>("sucesso!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
