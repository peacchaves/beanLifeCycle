package acc.br.bean.life.cycle.processor;

import org.springframework.beans.factory.config.BeanPostProcessor;

import acc.br.bean.life.cycle.beans.Character;
import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.beans.Weapon;

public class MagicBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to Character: " + ((Character) bean).getName());
        } else if (bean instanceof Weapon) {
            System.out.println("5. BeanPostProcessor: Enchanting the Weapon: " + ((Weapon) bean).getName());
        } else if (bean instanceof Item) {
            System.out.println("5. BeanPostProcessor: Infusing magical properties into Item: " + ((Item) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("9. BeanPostProcessor: Completing magical enhancement for Character: " + ((Character) bean).getName());
        } else if (bean instanceof Weapon) {
            System.out.println("9. BeanPostProcessor: Final magical empowerment of Weapon: " + ((Weapon) bean).getName());
        } else if (bean instanceof Item) {
            System.out.println("9. BeanPostProcessor: Sealing magical essence into Item: " + ((Item) bean).getName());
        }
        return bean;
    }
}