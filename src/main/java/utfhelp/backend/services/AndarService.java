package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.models.Andar;
import utfhelp.backend.repositories.AndarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AndarService {

    private final AndarRepository andarRepository;

    public AndarService(AndarRepository andarRepository){
        this.andarRepository = andarRepository;
    }

    public List<Andar> getAll(){
        return andarRepository.findAll();
    }

    public Andar getById(Long id){
        Optional<Andar> andar = andarRepository.findById(id);
        return andar.orElse(null);
    }

    public Andar post(Andar andar){
        return andarRepository.save(andar);
    }

    @Transactional
    public Andar put(Andar novo_andar, Long id){
        Andar andar = andarRepository.findById(id).orElseThrow();

        andar.setNum_andar(novo_andar.getNum_andar());
        andar.setBloco(novo_andar.getBloco());
        return andar;
    }

    public void delete(Long id){
        andarRepository.deleteById(id);
    }
}
