package pl.twojadruzyna.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.twojadruzyna.api.ViewModel.FeedbackViewModel;
import pl.twojadruzyna.service.mailSender.IMailSender;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeeedbackController {
    private final IMailSender mailSender;

    @Autowired
    public FeeedbackController(IMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/send")
    public void sendFeedback(FeedbackViewModel feedbackViewModel) {
        this.mailSender.sendEmail
                (feedbackViewModel.getEmail(),
                        feedbackViewModel.getAuthor() + "'s feedback",
                        feedbackViewModel.getContent() + "\n" + feedbackViewModel.getPhoneNumber());
    }

}
