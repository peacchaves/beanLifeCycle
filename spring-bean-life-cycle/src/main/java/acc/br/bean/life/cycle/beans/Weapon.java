package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon(String name) {
        System.out.println("1. Instantiation: A new weapon has been created: " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Setting bean name for weapon: " + name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware: Setting application context for weapon.");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3. BeanFactoryAware: Setting bean factory for weapon: " + getName());
        this.beanFactory = beanFactory;
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: " + getName() + " weapon is being prepared.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: " + getName() + " weapon is being sharpened.");
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Performing weapon-specific initialization.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: " + getName() + " weapon is being retired.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: " + getName() + " weapon is being disassembled.");
        cleanAndStore();
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: Final maintenance for " + getName() + " weapon.");
    }

    private void cleanAndStore() {
        System.out.println("12. DisposableBean: " + getName() + " weapon is being cleaned and stored.");
    }
}