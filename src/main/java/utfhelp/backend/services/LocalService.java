package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.dtos.request.LocalRequestDTO;
import utfhelp.backend.models.Andar;
import utfhelp.backend.models.Categoria;
import utfhelp.backend.models.Local;
import utfhelp.backend.repositories.AndarRepository;
import utfhelp.backend.repositories.CategoriaRepository;
import utfhelp.backend.repositories.LocalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    private final LocalRepository localRepository;
    private final AndarRepository andarRepository;
    private final CategoriaRepository categoriaRepository;

    public LocalService(LocalRepository localRepository,
                        AndarRepository andarRepository,
                        CategoriaRepository categoriaRepository){
        this.localRepository = localRepository;
        this.andarRepository = andarRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Local> getAll(){
        return localRepository.findAll();
    }

    public Local getById(Long id){
        Optional<Local> local = localRepository.findById(id);
        return local.orElse(null);
    }

    public Local post(LocalRequestDTO dto){
        Andar andar = andarRepository.findById(dto.getAndar_id()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(dto.getCategoria_id()).orElseThrow();

        Local local = new Local();

        local.setNome(dto.getNome());
        local.setCategoria(categoria);
        local.setDescricao(dto.getDescricao());
        local.setTipo(dto.getTipo());
        local.setAndar(andar);
        local.setCoord_x(dto.getCoord_x());
        local.setCoord_y(dto.getCoord_y());
        local.setCoord_z(dto.getCoord_z());

        return localRepository.save(local);
    }

    @Transactional
    public Local put(LocalRequestDTO dto, Long id){
        Andar andar = andarRepository.findById(dto.getAndar_id()).orElseThrow();
        Categoria categoria = categoriaRepository.findById(dto.getCategoria_id()).orElseThrow();

        Local local = localRepository.findById(id).orElseThrow();

        local.setNome(dto.getNome());
        local.setCategoria(categoria);
        local.setDescricao(dto.getDescricao());
        local.setTipo(dto.getTipo());
        local.setAndar(andar);
        local.setCoord_x(dto.getCoord_x());
        local.setCoord_y(dto.getCoord_y());
        local.setCoord_z(dto.getCoord_z());

        return local;
    }

    public void delete(Long id){
        localRepository.deleteById(id);
    }
}
