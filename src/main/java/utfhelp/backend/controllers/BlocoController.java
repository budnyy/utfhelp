package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.dtos.request.BlocoRequestDTO;
import utfhelp.backend.models.Bloco;
import utfhelp.backend.services.BlocoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blocos")
public class BlocoController {

    private final BlocoService blocoService;

    public BlocoController(BlocoService blocoService){
        this.blocoService = blocoService;
    }

    @GetMapping
    public List<Bloco> getAll(){
        return blocoService.getAll();
    }

    @GetMapping("/{id}")
    public Bloco getById(@PathVariable Long id){
        return blocoService.getById(id);
    }

    @PostMapping
    public Bloco post(@RequestBody BlocoRequestDTO bloco){
        return blocoService.post(bloco);
    }

    @PutMapping("/{id}")
    public Bloco put(@RequestBody BlocoRequestDTO bloco, @PathVariable Long id){
        return blocoService.put(bloco, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        blocoService.delete(id);
    }
}
