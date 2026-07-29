package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.models.ArestaGrafo;
import utfhelp.backend.models.Bloco;
import utfhelp.backend.repositories.BlocoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlocoService {

    private final BlocoRepository blocoRepository;

    public BlocoService(BlocoRepository blocoRepository){
        this.blocoRepository = blocoRepository;
    }

    public List<Bloco> getAll(){
        return blocoRepository.findAll();
    }

    public Bloco getById(Long id){
        Optional<Bloco> bloco = blocoRepository.findById(id);
        return bloco.orElse(null);
    }

    public Bloco post(Bloco bloco){
        return blocoRepository.save(bloco);
    }

    @Transactional
    public Bloco put(Bloco novo_bloco, Long id){
        Bloco bloco = blocoRepository.findById(id).orElseThrow();

        bloco.setDescricao(novo_bloco.getDescricao());
        bloco.setNome(novo_bloco.getNome());
        return bloco;
    }

    public void delete(Long id){
        blocoRepository.deleteById(id);
    }
}
