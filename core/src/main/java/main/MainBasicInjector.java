package main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import consumer.MyApplicationWithConstructorInject;
import injector.ProviderInjectorModule;
import service.*;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class MainBasicInjector {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ProviderInjectorModule());
        /**
         * Creating SMS service client and send message
         */
        MessageService messageService = injector.getInstance(SmsService.class);
        messageService.sendMsg("hello world");

        /**
         * Create Email Service client and send message
         */
        messageService = injector.getInstance(EmailService.class);
        messageService.sendMsg("hello world");

        /**
         * Same object is used because smsservice object is singleton
         */
        messageService = injector.getInstance(SmsService.class);
        messageService.sendMsg("hello world");

        /**
         * New object is created because EmailService is not singleton
         */
        messageService = injector.getInstance(EmailService.class);
        messageService.sendMsg("hello world");

        /**
         * Getting Named object
         */
        messageService = injector.getInstance(Key.get(EmailService.class, Names.named("SingletonEmailService")));
        messageService.sendMsg("hello world");

        /**
         * Getting Named object
         * Same object is return because singleton
         */

        messageService = injector.getInstance(Key.get(EmailService.class, Names.named("SingletonEmailService")));
        messageService.sendMsg("hello world");

        /**
         * Getting Enhanced Email Service
         * Create new Email Service client
         */
        messageService = injector.getInstance(EnhancedEmailService.class);
        messageService.sendMsg("hello world");

        /**
         * Getting Enhanced Email Service
         * Use existing Email Service client
         */

        messageService = injector.getInstance(Key.get(EnhancedEmailService.class, Names.named("EnhancedEmailServiceWithSingleTonEmailService")));
        messageService.sendMsg("hello world");


    }
}
