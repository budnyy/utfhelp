package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.dtos.request.CategoriaRequestDTO;
import utfhelp.backend.models.Categoria;
import utfhelp.backend.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    public Categoria getById(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    public Categoria post(CategoriaRequestDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());

        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria put(CategoriaRequestDTO novo_categoria, Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();

        categoria.setNome(novo_categoria.getNome());
        return categoria;
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
