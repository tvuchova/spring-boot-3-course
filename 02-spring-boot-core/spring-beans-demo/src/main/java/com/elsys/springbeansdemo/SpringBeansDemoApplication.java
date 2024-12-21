package com.elsys.springbeansdemo;

import com.elsys.springbeansdemo.awareness.MyApplicationContextAware;
import com.elsys.springbeansdemo.awareness.MyBeanNameAware;
import com.elsys.springbeansdemo.lifecycle.ExampleBean;
import com.elsys.springbeansdemo.scopes.StudentPrototype;
import com.elsys.springbeansdemo.injectionTypes.constructorInjection.UserService;
import com.elsys.springbeansdemo.injectionTypes.setterInjection.EmailMessageService;
import com.elsys.springbeansdemo.injectionTypes.setterInjection.MessageProcessor;
import com.elsys.springbeansdemo.beanDefinition.xml.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@Slf4j
public class SpringBeansDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBeansDemoApplication.class, args);
        ExampleBean bean = context.getBean("exampleBean", ExampleBean.class);

       UserService userService = context.getBean("userService", UserService.class);
       log.info(userService.getUser().toString());

        MessageProcessor messageProcessor = context.getBean(MessageProcessor.class);
        EmailMessageService emailService = context.getBean(EmailMessageService.class);
        messageProcessor.setMessageService(emailService);

        messageProcessor.processMessage("Hello World", "ddd@dd");

        ItemService itemService = context.getBean("itemServiceImpl", ItemService.class);
        log.info(itemService.findAll().toString());

        StudentPrototype studentPrototype = context.getBean("studentPrototype", StudentPrototype.class);
        log.info(studentPrototype.generateReport("John Doe"));
        StudentPrototype studentPrototype2 = context.getBean("studentPrototype", StudentPrototype.class);
        log.info(studentPrototype2.generateReport("John Do"));
        MyApplicationContextAware awareBean = context.getBean(MyApplicationContextAware.class);
        for (String beanName : awareBean.printBeans()) {
            log.info(beanName);

        }

       // MyBeanNameAware awareBeanName = context.getBean(MyBeanNameAware.class);
        //awareBeanName.printBeanName();
    }
}
