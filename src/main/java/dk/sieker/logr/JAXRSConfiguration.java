package dk.sieker.logr;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author sieker
 */
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {

    public JAXRSConfiguration() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("logr");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setDescription("An API for the logr time tracker");
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/logr/api");
        beanConfig.setResourcePackage("dk.sieker.logr");
        beanConfig.setScan(true);

    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }

}
