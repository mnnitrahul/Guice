package consumer;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import service.MessageService;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class MyApplicationWithNamedConstructorInject implements ApplicationInterface {
    private MessageService messageService;
    @Inject
    public MyApplicationWithNamedConstructorInject(@Named("SingletonEmailService") MessageService messageService) {
        this.messageService = messageService;
    }
    public void sendMessage(String msg) {
        messageService.sendMsg(msg);
    }
}
