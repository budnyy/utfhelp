package utfhelp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfhelp.backend.models.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
