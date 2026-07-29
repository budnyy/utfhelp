package utfhelp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfhelp.backend.models.NoGrafo;

@Repository
public interface NoGrafoRepository extends JpaRepository<NoGrafo, Long>{
}
