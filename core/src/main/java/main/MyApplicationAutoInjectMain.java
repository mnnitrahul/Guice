package main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import consumer.MyApplicationWithConstructorInject;
import consumer.MyApplicationWithNamedConstructorInject;
import consumer.MyApplicationWithSetterInject;
import injector.ProviderInjectorModule;
import service.EmailService;
import service.MessageService;
import service.SmsService;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class MyApplicationAutoInjectMain {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ProviderInjectorModule());
        /**
         * Automatically binding
         */
        MyApplicationWithConstructorInject app = injector.getInstance(MyApplicationWithConstructorInject.class);
        app.sendMessage("hello world");

        /**
         * Injecting through Setter and Passing Object instead of Interface so bind function is not used
         */
        MyApplicationWithSetterInject app2 = injector.getInstance(MyApplicationWithSetterInject.class);
        app2.sendMessage("Hello world");

        MyApplicationWithNamedConstructorInject app3 = injector.getInstance(MyApplicationWithNamedConstructorInject.class);
        app3.sendMessage("Hello World");

        /**
         * This will again create new Email Service client
         */
        EmailService singletonEmailService =  injector.getInstance(Key.get(EmailService.class, Names.named("SingletonEmailService")));
        singletonEmailService.sendMsg("hello world");

    }
}
