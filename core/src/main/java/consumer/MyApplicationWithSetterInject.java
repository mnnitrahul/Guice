package consumer;

import com.google.inject.Inject;
import service.EmailService;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class MyApplicationWithSetterInject implements ApplicationInterface {
    private EmailService emailService;
    public MyApplicationWithSetterInject() {}

    @Inject
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }


    public void sendMessage(String msg) {
        emailService.sendMsg(msg);
    }
}
