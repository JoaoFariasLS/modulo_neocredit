package com.neocredit.neocredit.controller;

import com.neocredit.neocredit.model.Dado;
import com.neocredit.neocredit.model.Empresa;
import com.neocredit.neocredit.service.DadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dado")
public class DadoController {
    @Autowired
    private DadoService service;

    @PostMapping
    public ResponseEntity<Dado> save(@RequestBody Dado dado){
        try{
            return new ResponseEntity<Dado>(service.save(dado), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Dado>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Dado>> save(@RequestBody List<Dado> listadado){
        try{
            return new ResponseEntity<List<Dado>>(service.save(listadado), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<List<Dado>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Dado>> get(){
        try{
            return new ResponseEntity<List<Dado>>(service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Dado>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dado> getById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<Dado>(service.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Dado>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        try{
            service.delete(id);
            return new ResponseEntity<String>("sucesso!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
