package utfhelp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfhelp.backend.models.Andar;

@Repository
public interface AndarRepository extends JpaRepository<Andar, Long>{
}
