package pl.twojadruzyna.api.ViewModel;

import lombok.Data;

@Data
public class FeedbackViewModel {
    private String author;
    private String email;
    private String phoneNumber;
    private String content;

}
