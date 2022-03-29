package com.libreria.back.controller;

import com.libreria.back.entity.Partitura;
import com.libreria.back.service.PartiturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partituras")
public class PartiturasController {

    @Autowired
    PartiturasService partiturasService;

    @GetMapping("/listar")
    public ResponseEntity<List<Partitura>> listar(){
        List<Partitura> lista = partiturasService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Partitura> ver(@PathVariable int id){
        Partitura partituraEncontrada = partiturasService.findById(id);
        if(partituraEncontrada.equals(null)){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(partituraEncontrada);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Partitura> crear(@RequestBody Partitura partitura){
        Partitura partituraCreada = partiturasService.save(partitura);
        if(partituraCreada.equals(null)){
            return ResponseEntity.unprocessableEntity().build();
        }else {
            return ResponseEntity.ok(partituraCreada);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Partitura> editar(@RequestBody Partitura partitura){
        Partitura partituraEncontrada = partiturasService.findById(partitura.getId());
        if(partituraEncontrada.equals(null)){
            return ResponseEntity.notFound().build();
        }else{
            partiturasService.update(partitura, partitura.getId());
            return ResponseEntity.ok(partitura);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Partitura> eliminar(@PathVariable int id) {
        partiturasService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
