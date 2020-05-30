package school.cesar.ecommerce;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_ESTOQUE = "estoque-queue";
    public static final String QUEUE_EXPEDICAO = "expedicao-queue";
    public static final String QUEUE_COBRANCA = "cobranca-queue";
    public static final String EXCHANGE_ORDERS = "orders-exchange";

    @Bean
    public Declarables fanoutBindings() {
        Queue estoqueQueue = new Queue(QUEUE_ESTOQUE, false);
        Queue expedicaoQueue = new Queue(QUEUE_EXPEDICAO, false);
        Queue cobrancaQueue = new Queue(QUEUE_COBRANCA, false);

        FanoutExchange ordersExchange = new FanoutExchange(EXCHANGE_ORDERS, false, false);

        return new Declarables(estoqueQueue, expedicaoQueue, cobrancaQueue, ordersExchange,
            BindingBuilder
                .bind(estoqueQueue)
                .to(ordersExchange),
            BindingBuilder
                .bind(expedicaoQueue)
                .to(ordersExchange),
            BindingBuilder
                .bind(cobrancaQueue)
                .to(ordersExchange));
    }

}
