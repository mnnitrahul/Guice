package service;

import java.util.Random;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class EmailService implements MessageService {
    private int id;
    private EnhancedEmailService enhancedEmailService;
    public EmailService() {
        id = new Random().nextInt();
        System.out.println("creating email service client");
    }

    public boolean sendMsg(String msg) {
        System.out.println("Email service: " + msg);
        return true;
    }

    public int getId() {
        return id;
    }

    public EnhancedEmailService getEnhancedEmailService() {
        if (enhancedEmailService == null) {
            enhancedEmailService = new EnhancedEmailService();
        }
        return enhancedEmailService;
    }
}
