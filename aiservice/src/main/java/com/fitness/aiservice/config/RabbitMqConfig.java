package com.fitness.aiservice.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMqConfig {
    // RabbitMQ configuration can be added here in the future
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName = "fitactivity-exchange";
    @Value("${rabbitmq.routing.key}")
    private String routingKey = "fitactivity-routingkey";
    @Value("${rabbitmq.queue.name}")
    private String queueName = "fitactivity-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }
    @Bean
    public org.springframework.amqp.core.Binding binding(Queue queue, DirectExchange exchange) {
        return org.springframework.amqp.core.BindingBuilder.bind(queue).to(exchange).with(routingKey);
    } 

}
