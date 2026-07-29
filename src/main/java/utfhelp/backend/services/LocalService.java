package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.models.Feedback;
import utfhelp.backend.models.Local;
import utfhelp.backend.repositories.LocalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    private final LocalRepository localRepository;

    public LocalService(LocalRepository localRepository){
        this.localRepository = localRepository;
    }

    public List<Local> getAll(){
        return localRepository.findAll();
    }

    public Local getById(Long id){
        Optional<Local> local = localRepository.findById(id);
        return local.orElse(null);
    }

    public Local post(Local local){
        return localRepository.save(local);
    }

    @Transactional
    public Local put(Local novo_local, Long id){
        Local local = localRepository.findById(id).orElseThrow();

        local.setAndar(novo_local.getAndar());
        local.setNome(novo_local.getNome());
        local.setDescricao(novo_local.getDescricao());
        local.setTipo(novo_local.getTipo());
        local.setCoord_x(novo_local.getCoord_x());
        local.setCoord_y(novo_local.getCoord_y());
        local.setCoord_z(novo_local.getCoord_z());
        local.setCategoria(novo_local.getCategoria());
        return local;
    }

    public void delete(Long id){
        localRepository.deleteById(id);
    }
}
