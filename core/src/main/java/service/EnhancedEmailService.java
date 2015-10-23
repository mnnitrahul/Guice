package service;

import java.util.Random;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class EnhancedEmailService implements MessageService {
    private int id;
    public EnhancedEmailService() {
        id = new Random().nextInt();
        System.out.println("creating enhanced email service client with id " + id);
    }


    public boolean sendMsg(String msg) {
        System.out.println("Enhanced Email service: " + msg);
        return true;
    }

    public int getId() {
        return id;
    }
}
