package com.libreria.back.controller;

import com.libreria.back.entity.Partitura;
import com.libreria.back.service.PartiturasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partituras")
@ApiOperation(value = "Partituras",
        notes = "Métodos relacionados con el listado, creación, edición, adición y eliminación de partituras")
public class PartiturasController {

    @Autowired
    PartiturasService partiturasService;

    @GetMapping("/listar")
    @ApiOperation(value = "Lista de partituras",
        notes = "Devuelve todas las partituras del sistema")
    public ResponseEntity<List<Partitura>> listar(){
        List<Partitura> lista = partiturasService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ver/{id}")
    @ApiOperation(value = "Ver partitura",
            notes = "Devuelve la partitura cuyo Id se pase como argumento")
    public ResponseEntity<Partitura> ver(@ApiParam(value = "Id numérico de la partitura", required = true)
                                             @PathVariable int id){
        Partitura partituraEncontrada = partiturasService.findById(id);
        if(partituraEncontrada.equals(null)){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(partituraEncontrada);
        }
    }

    @PostMapping("/crear")
    @ApiOperation(value = "Crea una partitura",
            notes = "Crea una partitura según los datos que se le pasen")
    public ResponseEntity<Partitura> crear(@RequestBody Partitura partitura){
        Partitura partituraCreada = partiturasService.save(partitura);
        if(partituraCreada.equals(null)){
            return ResponseEntity.unprocessableEntity().build();
        }else {
            return ResponseEntity.ok(partituraCreada);
        }
    }

    @PutMapping("/editar")
    @ApiOperation(value = "Edita una partitura",
            notes = "Edita una partitura que se encuentre previamente en el sistema")
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
    @ApiOperation(value = "Eliminar partitura",
            notes = "Elimina la partitura cuyo Id se pase como argumento")
    public ResponseEntity<Partitura> eliminar(@ApiParam(value = "Id numérico de la partitura", required = true)
                                                  @PathVariable int id) {
        partiturasService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
