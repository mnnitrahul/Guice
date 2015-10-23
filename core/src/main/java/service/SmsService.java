package service;

import java.util.Random;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class SmsService implements MessageService {
    private int id;
    public SmsService() {
        id = new Random().nextInt();
        System.out.println("creating sms service client");
    }

    public boolean sendMsg(String msg) {
        System.out.println("Sms service: " + msg);
        return true;
    }

    public int getId() {
        return id;
    }
}
