package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.models.Local;
import utfhelp.backend.services.LocalService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locais")
public class LocalController {

    private final LocalService localService;

    public LocalController(LocalService localService){
        this.localService = localService;
    }

    @GetMapping
    public List<Local> getAll(){
        return localService.getAll();
    }

    @GetMapping("/{id}")
    public Local getById(@PathVariable Long id){
        return localService.getById(id);
    }

    @PostMapping
    public Local post(@RequestBody Local local){
        return localService.post(local);
    }

    @PutMapping("/{id}")
    public Local put(@RequestBody Local local, @PathVariable Long id){
        return localService.put(local, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        localService.delete(id);
    }
}
