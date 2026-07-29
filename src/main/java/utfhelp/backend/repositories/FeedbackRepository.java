package utfhelp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfhelp.backend.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
