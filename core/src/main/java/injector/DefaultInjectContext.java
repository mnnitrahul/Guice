package injector;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
/**
 * Created with IntelliJ IDEA.
 * User: rahul.ka
 * Date: 17/02/15
 * Time: 8:28 AM
 * To change this template use File | Settings | File Templates.
 */


/**
 * Application context based on configurations provided by fk-ad-prod-ads app in conman
 * The context fully constructs itself.
 */
public class DefaultInjectContext {

    private static Injector injector;

    private static void init(){
        if (injector == null){
            synchronized (DefaultInjectContext.class){
                if (injector == null){
                    ProviderInjectorModule providerInjectorModule = new ProviderInjectorModule();
                    injector = Guice.createInjector(providerInjectorModule);
                }
            }
        }
    }

    public static <T> T getInstance(Class<T> klass){
        init();
        return injector.getInstance(klass);
    }

    public static <T> T getInstance(Class<T> klass, String namedAnnotation){
        init();
        return injector.getInstance(Key.get(klass, Names.named(namedAnnotation)));
    }

}
