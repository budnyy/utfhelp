package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.dtos.request.ArestaGrafoRequestDTO;
import utfhelp.backend.models.ArestaGrafo;
import utfhelp.backend.services.ArestaGrafoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/arestas")
public class ArestaGrafoController {

    private final ArestaGrafoService arestaGrafoService;

    public ArestaGrafoController(ArestaGrafoService arestaGrafoService){
        this.arestaGrafoService = arestaGrafoService;
    }

    @GetMapping
    public List<ArestaGrafo> getAll(){
        return arestaGrafoService.getAll();
    }

    @GetMapping("/{id}")
    public ArestaGrafo getById(@PathVariable Long id){
        return arestaGrafoService.getById(id);
    }

    @PostMapping
    public ArestaGrafo post(@RequestBody ArestaGrafoRequestDTO aresta){
        return arestaGrafoService.post(aresta);
    }

    @PutMapping("/{id}")
    public ArestaGrafo put(@RequestBody ArestaGrafoRequestDTO aresta, @PathVariable Long id){
        return arestaGrafoService.put(aresta, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        arestaGrafoService.delete(id);
    }
}
