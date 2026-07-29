package utfhelp.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import utfhelp.backend.dtos.request.FeedbackRequest;
import utfhelp.backend.models.Categoria;
import utfhelp.backend.models.Feedback;
import utfhelp.backend.repositories.FeedbackRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAll(){
        return feedbackRepository.findAll();
    }

    public Feedback getById(Long id){
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        return feedback.orElse(null);
    }

    public Feedback post(Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    @Transactional
    public Feedback put(Feedback novo_feedback, Long id){
        Feedback feedback = feedbackRepository.findById(id).orElseThrow();

        feedback.setTipo(novo_feedback.getTipo());
        feedback.setMensagem(novo_feedback.getMensagem());
        feedback.setCreated_at(novo_feedback.getCreated_at());
        return feedback;
    }

    public void delete(Long id){
        feedbackRepository.deleteById(id);
    }
}
