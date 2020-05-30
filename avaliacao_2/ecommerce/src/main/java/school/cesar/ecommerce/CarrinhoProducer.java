package school.cesar.ecommerce;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoProducer implements CommandLineRunner {

    public static final String ORDER = "{ E-mail: lcbm@cesar.school, CEP: 50030-220, SKUs: [1,2,3,4], Valor: R$9,90}";

    @Autowired
    RabbitTemplate template;
    public void run(String... args) throws Exception {
        System.out.println("Sending order...");
        template.convertAndSend(RabbitConfig.EXCHANGE_ORDERS, "", ORDER);
    }
}
