package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.models.Andar;
import utfhelp.backend.services.AndarService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/andares")
public class AndarController {

    private final AndarService andarService;

    public AndarController(AndarService andarService){
        this.andarService = andarService;
    }

    @GetMapping
    public List<Andar> getAll(){
        return andarService.getAll();
    }

    @GetMapping("/{id}")
    public Andar getById(@PathVariable Long id){
        return andarService.getById(id);
    }

    @PostMapping
    public Andar post(@RequestBody Andar andar){
        return andarService.post(andar);
    }

    @PutMapping("/{id}")
    public Andar put(@RequestBody Andar andar, @PathVariable Long id){
        return andarService.put(andar, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        andarService.delete(id);
    }
}
