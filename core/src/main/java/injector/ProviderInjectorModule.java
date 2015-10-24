package injector;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import service.*;

/**
 * Created by rahul.ka on 23/10/15.
 */
public class ProviderInjectorModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(MessageService.class).to(SmsService.class);
        bind(MessageService.class).annotatedWith(SingletonSmsService.class).to(SmsService.class);
        bind(MessageService.class).annotatedWith(Names.named("SingletonEmailService")).to(EmailService.class);
    }

    @Inject
    @Provides
    public EmailService getEmailService() {
        return new EmailService();
    }

    @Inject
    @Provides
    @Singleton
    @Named("SingletonEmailService")
    public EmailService getSingleTonEmailService() {
        return new EmailService();
    }

    @Inject
    @Provides
    @Singleton
    public SmsService getSmsService() {
        return new SmsService();
    }

    @Inject
    @Provides
    @Singleton
    public EnhancedEmailService getEnhancedEmailService(EmailService emailService) {
        return emailService.getEnhancedEmailService();
    }

    @Inject
    @Provides
    @Singleton
    @Named("EnhancedEmailServiceWithSingleTonEmailService")
    public EnhancedEmailService getSingleTonEnhancedEmailService(@Named("SingletonEmailService")EmailService emailService) {
        return emailService.getEnhancedEmailService();
    }



}
