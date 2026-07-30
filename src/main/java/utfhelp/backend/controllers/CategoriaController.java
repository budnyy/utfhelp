package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.dtos.request.CategoriaRequestDTO;
import utfhelp.backend.models.Categoria;
import utfhelp.backend.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> getAll(){
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id){
        return categoriaService.getById(id);
    }

    @PostMapping
    public Categoria post(@RequestBody CategoriaRequestDTO categoria){
        return categoriaService.post(categoria);
    }

    @PutMapping("/{id}")
    public Categoria put(@RequestBody CategoriaRequestDTO categoria, @PathVariable Long id){
        return categoriaService.put(categoria, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoriaService.delete(id);
    }
}
