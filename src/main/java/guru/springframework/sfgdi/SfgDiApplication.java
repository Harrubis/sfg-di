package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class SfgDiApplication {

    private static final Logger log = Logger.getLogger(SfgDiApplication.class.getName());

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        MyController myController = (MyController) ctx.getBean("myController");
        String helloString = myController.sayHello();
        log.info("--- Primary bean");
        log.info(helloString);

        log.info("--- Property controller");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        log.info(propertyInjectedController.getGreeting());

        log.info("--- Setter controller");

        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        log.info(setterInjectedController.getGreeting());

        log.info("--- Constructor controller");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        log.info(constructorInjectedController.getGreeting());
    }

}
