package main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import injector.DefaultInjectContext;
import injector.ProviderInjectorModule;
import service.EmailService;
import service.EnhancedEmailService;
import service.MessageService;
import service.SmsService;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class DefaultInjectorMain {

    public static void main(String[] args) {

        MessageService messageService = DefaultInjectContext.getInstance(SmsService.class);
        messageService.sendMsg("hello world");

        /**
         * Create Email Service client and send message
         */
        messageService = DefaultInjectContext.getInstance(EmailService.class);
        messageService.sendMsg("hello world");

        /**
         * Same object is used because smsservice object is singleton
         */
        messageService = DefaultInjectContext.getInstance(SmsService.class);
        messageService.sendMsg("hello world");

        /**
         * New object is created because EmailService is not singleton
         */
        messageService = DefaultInjectContext.getInstance(EmailService.class);
        messageService.sendMsg("hello world");

        /**
         * Getting Named object
         */
        messageService = DefaultInjectContext.getInstance(EmailService.class, "SingletonEmailService");
        messageService.sendMsg("hello world");

        /**
         * Getting Named object
         * Same object is return because singleton
         */

        messageService = DefaultInjectContext.getInstance(EmailService.class,"SingletonEmailService");
        messageService.sendMsg("hello world");

        /**
         * Getting Enhanced Email Service
         * Create new Email Service client
         */
        messageService = DefaultInjectContext.getInstance(EnhancedEmailService.class);
        messageService.sendMsg("hello world");

        /**
         * Getting Enhanced Email Service
         * Use existing Email Service client
         */

        messageService = DefaultInjectContext.getInstance(EnhancedEmailService.class, "EnhancedEmailServiceWithSingleTonEmailService");
        messageService.sendMsg("hello world");


    }
}
