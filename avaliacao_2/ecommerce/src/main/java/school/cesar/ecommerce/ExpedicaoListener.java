package school.cesar.ecommerce;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ExpedicaoListener {
    @RabbitListener(queues = RabbitConfig.QUEUE_EXPEDICAO)
    public void processOrder(String order) {
        System.out.println("Expedicao received: " + order);
    }
}
