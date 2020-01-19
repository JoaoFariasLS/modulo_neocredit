package com.neocredit.neocredit.controller;

import com.neocredit.neocredit.model.Consulta;
import com.neocredit.neocredit.model.ConsultaExecucao;
import com.neocredit.neocredit.model.Empresa;
import com.neocredit.neocredit.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<Consulta> save(@RequestBody Consulta consulta){
        try{
            return new ResponseEntity<Consulta>(service.save(consulta), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Consulta>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exec/{id}")
    public ResponseEntity<ConsultaExecucao> save(@PathVariable("id") Long id, @RequestBody List<String> listaCnpj){
        try{
            return new ResponseEntity<ConsultaExecucao>(service.executarConsulta(id, listaCnpj), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<ConsultaExecucao>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> get(){
        try{
            return new ResponseEntity<List<Consulta>>(service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Consulta>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<Consulta>(service.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Consulta>(HttpStatus.BAD_REQUEST);
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
