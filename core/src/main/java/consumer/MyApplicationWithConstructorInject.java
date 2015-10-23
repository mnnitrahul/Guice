package consumer;

import com.google.inject.Inject;
import service.MessageService;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class MyApplicationWithConstructorInject implements ApplicationInterface {
    private MessageService messageService;
    @Inject
    public MyApplicationWithConstructorInject(MessageService messageService) {
        this.messageService = messageService;
    }
    public void sendMessage(String msg) {
        messageService.sendMsg(msg);
    }
}
