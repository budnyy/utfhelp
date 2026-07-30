package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.dtos.request.NoGrafoRequestDTO;
import utfhelp.backend.models.NoGrafo;
import utfhelp.backend.repositories.NoGrafoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoGrafoService {

    private final NoGrafoRepository noGrafoRepository;

    public NoGrafoService(NoGrafoRepository noGrafoRepository){
        this.noGrafoRepository = noGrafoRepository;
    }

    public List<NoGrafo> getAll(){
        return noGrafoRepository.findAll();
    }

    public NoGrafo getById(Long id){
        Optional<NoGrafo> noGrafo = noGrafoRepository.findById(id);
        return noGrafo.orElse(null);
    }

    public NoGrafo post(NoGrafoRequestDTO dto){
        NoGrafo noGrafo = new NoGrafo();

        noGrafo.setX(dto.getX());
        noGrafo.setY(dto.getY());

        return noGrafoRepository.save(noGrafo);
    }

    @Transactional
    public NoGrafo put(NoGrafoRequestDTO novo_noGrafo, Long id){
        NoGrafo noGrafo = noGrafoRepository.findById(id).orElseThrow();

        noGrafo.setX(novo_noGrafo.getX());
        noGrafo.setY(novo_noGrafo.getY());
        return noGrafo;
    }

    public void delete(Long id){
        noGrafoRepository.deleteById(id);
    }
}
