package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private static final Logger log = Logger.getLogger(LifeCycleDemoBean.class.getName());

    public LifeCycleDemoBean() {
        log.info("## - LifeCycle bean constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("## - Bean factory has been set");
    }

    @Override
    public void setBeanName(String s) {
        log.log(Level.INFO, () -> "## - My bean name is: " + s);
    }

    @Override
    public void destroy() {
        log.info("## - Life cycle bean has been terminated");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("## - The LifeCycleBean has its properties set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("## - Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("## - Post construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("## - Pre destroy annotated method has been called");
    }

    public void beforeInit() {
        log.info("## --- Before init - Called by Bean Post Processor");
    }

    public void afterInit() {
        log.info("## --- After init - Called by Bean Post Processor");
    }
}
