package school.cesar.ecommerce;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueListener {
    @RabbitListener(queues = RabbitConfig.QUEUE_ESTOQUE)
    public void processOrder(String order) {
        System.out.println("Estoque received: " + order);
    }
}
