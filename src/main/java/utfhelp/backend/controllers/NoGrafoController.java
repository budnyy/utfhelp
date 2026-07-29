package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.models.NoGrafo;
import utfhelp.backend.services.NoGrafoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nos")
public class NoGrafoController {

    private final NoGrafoService noGrafoService;

    public NoGrafoController(NoGrafoService noGrafoService){
        this.noGrafoService = noGrafoService;
    }

    @GetMapping
    public List<NoGrafo> getAll(){
        return noGrafoService.getAll();
    }

    @GetMapping("/{id}")
    public NoGrafo getById(@PathVariable Long id){
        return noGrafoService.getById(id);
    }

    @PostMapping
    public NoGrafo post(@RequestBody NoGrafo noGrafo){
        return noGrafoService.post(noGrafo);
    }

    @PutMapping("/{id}")
    public NoGrafo put(@RequestBody NoGrafo noGrafo, @PathVariable Long id){
        return noGrafoService.put(noGrafo, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        noGrafoService.delete(id);
    }
}
