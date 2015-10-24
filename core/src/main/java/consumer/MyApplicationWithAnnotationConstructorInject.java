package consumer;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import service.MessageService;
import service.SingletonSmsService;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class MyApplicationWithAnnotationConstructorInject implements ApplicationInterface {
    private MessageService messageService;
    @Inject
    public MyApplicationWithAnnotationConstructorInject(@SingletonSmsService MessageService messageService) {
        this.messageService = messageService;
    }
    public void sendMessage(String msg) {
        messageService.sendMsg(msg);
    }
}
