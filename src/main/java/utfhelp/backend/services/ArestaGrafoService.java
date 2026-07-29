package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.models.ArestaGrafo;
import utfhelp.backend.repositories.ArestaGrafoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArestaGrafoService {

    private final ArestaGrafoRepository arestaGrafoRepository;

    public ArestaGrafoService(ArestaGrafoRepository arestaGrafoRepository){
        this.arestaGrafoRepository = arestaGrafoRepository;
    }

    public List<ArestaGrafo> getAll(){
        return arestaGrafoRepository.findAll();
    }

    public ArestaGrafo getById(Long id){
        Optional<ArestaGrafo> aresta = arestaGrafoRepository.findById(id);
        return aresta.orElse(null);
    }

    public ArestaGrafo post(ArestaGrafo aresta){
        return arestaGrafoRepository.save(aresta);
    }

    @Transactional
    public ArestaGrafo put(ArestaGrafo novo_aresta, Long id){
        ArestaGrafo aresta = arestaGrafoRepository.findById(id).orElseThrow();

        aresta.setDistancia(novo_aresta.getDistancia());
        aresta.setNo_a(novo_aresta.getNo_a());
        aresta.setNo_b(novo_aresta.getNo_b());
        return aresta;
    }

    public void delete(Long id){
        arestaGrafoRepository.deleteById(id);
    }
}
