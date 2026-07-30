package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.dtos.request.AndarRequestDTO;
import utfhelp.backend.models.Andar;
import utfhelp.backend.models.Bloco;
import utfhelp.backend.repositories.AndarRepository;
import utfhelp.backend.repositories.BlocoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AndarService {

    private final AndarRepository andarRepository;
    private final BlocoRepository blocoRepository;

    public AndarService(AndarRepository andarRepository,
                        BlocoRepository blocoRepository){
        this.andarRepository = andarRepository;
        this.blocoRepository = blocoRepository;
    }


    public List<Andar> getAll(){
        return andarRepository.findAll();
    }

    public Andar getById(Long id){
        Optional<Andar> andar = andarRepository.findById(id);
        return andar.orElse(null);
    }

    public Andar post(AndarRequestDTO dto){
        Andar andar = new Andar();

        Bloco bloco = blocoRepository.findById(dto.getBloco_id()).orElseThrow();

        andar.setBloco(bloco);
        andar.setNum_andar(dto.getNum_andar());

        return andarRepository.save(andar);
    }

    @Transactional
    public Andar put(AndarRequestDTO novo_andar, Long id){
        Andar andar = andarRepository.findById(id).orElseThrow();

        Bloco bloco = blocoRepository.findById(novo_andar.getBloco_id()).orElseThrow();

        andar.setNum_andar(novo_andar.getNum_andar());
        andar.setBloco(bloco);

        return andar;
    }

    public void delete(Long id){
        andarRepository.deleteById(id);
    }
}
