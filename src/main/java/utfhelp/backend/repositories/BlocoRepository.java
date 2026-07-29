package utfhelp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfhelp.backend.models.Bloco;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {
}
