package utfhelp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfhelp.backend.models.ArestaGrafo;

@Repository
public interface ArestaGrafoRepository extends JpaRepository<ArestaGrafo, Long> {
}
