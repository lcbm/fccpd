package school.cesar.ecommerce;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CobrancaListener {
    @RabbitListener(queues = RabbitConfig.QUEUE_COBRANCA)
    public void processOrder(String order) {
        System.out.println("Cobranca received: " + order);
    }
}
