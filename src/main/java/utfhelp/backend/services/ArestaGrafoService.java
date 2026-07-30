package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.dtos.request.ArestaGrafoRequestDTO;
import utfhelp.backend.models.ArestaGrafo;
import utfhelp.backend.models.NoGrafo;
import utfhelp.backend.repositories.ArestaGrafoRepository;
import utfhelp.backend.repositories.NoGrafoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArestaGrafoService {

    private final ArestaGrafoRepository arestaGrafoRepository;
    private final NoGrafoRepository noGrafoRepository;

    public ArestaGrafoService(ArestaGrafoRepository arestaGrafoRepository,
                              NoGrafoRepository noGrafoRepository){
        this.arestaGrafoRepository = arestaGrafoRepository;
        this.noGrafoRepository = noGrafoRepository;
    }

    public List<ArestaGrafo> getAll(){
        return arestaGrafoRepository.findAll();
    }

    public ArestaGrafo getById(Long id){
        Optional<ArestaGrafo> aresta = arestaGrafoRepository.findById(id);
        return aresta.orElse(null);
    }

    public ArestaGrafo post(ArestaGrafoRequestDTO dto){
        ArestaGrafo aresta = new ArestaGrafo();

        NoGrafo noA = noGrafoRepository.findById(dto.getNoA_id()).orElseThrow();
        NoGrafo noB = noGrafoRepository.findById(dto.getNoB_id()).orElseThrow();

        aresta.setDistancia(dto.getDistancia());
        aresta.setNo_a(noA);
        aresta.setNo_b(noB);

        return arestaGrafoRepository.save(aresta);
    }

    @Transactional
    public ArestaGrafo put(ArestaGrafoRequestDTO dto, Long id){
        ArestaGrafo aresta = arestaGrafoRepository.findById(id).orElseThrow();

        NoGrafo noA = noGrafoRepository.findById(dto.getNoA_id()).orElseThrow();
        NoGrafo noB = noGrafoRepository.findById(dto.getNoB_id()).orElseThrow();

        aresta.setDistancia(dto.getDistancia());
        aresta.setNo_a(noA);
        aresta.setNo_b(noB);
        return aresta;
    }

    public void delete(Long id){
        arestaGrafoRepository.deleteById(id);
    }
}
