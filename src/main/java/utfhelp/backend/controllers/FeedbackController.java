package utfhelp.backend.controllers;

import org.springframework.web.bind.annotation.*;
import utfhelp.backend.dtos.request.FeedbackRequestDTO;
import utfhelp.backend.models.Feedback;
import utfhelp.backend.services.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAll(){
        return feedbackService.getAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id){
        return feedbackService.getById(id);
    }

    @PostMapping
    public Feedback post(@RequestBody FeedbackRequestDTO feedback){
        return feedbackService.post(feedback);
    }

    @PutMapping("/{id}")
    public Feedback put(@RequestBody FeedbackRequestDTO feedback, @PathVariable Long id){
        return feedbackService.put(feedback, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        feedbackService.delete(id);
    }
}
