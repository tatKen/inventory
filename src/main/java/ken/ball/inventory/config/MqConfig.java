package ken.ball.inventory.config;

import ken.ball.inventory.repository.CardRepository;
import ken.ball.inventory.service.CardService;
import ken.ball.inventory.service.mq.MainDpSyncReceiver;
import ken.ball.inventory.service.mq.MainDpSyncSender;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
    @Autowired
    public CardService cardService;

    @Bean
    public Queue queueSyncMainDp(){
        return new Queue("q-sync-maindp");
    }

    @Bean
    public MainDpSyncReceiver mainDpReceiver(){
        return new MainDpSyncReceiver(cardService, "1");
    }

    @Bean
    public MainDpSyncReceiver mainDpReceiver2(){
        return new MainDpSyncReceiver(cardService, "2");
    }

    @Bean
    public MainDpSyncSender mainDpSyncSender(){
        return new MainDpSyncSender();
    }

    // topic exchange and queue for sync Main DP
    @Bean
    public TopicExchange topicExcSyncMainDp(){
        return new TopicExchange("inv.exc-topic-sync-maindp");
    }

    @Bean
    public Queue qSyncMainDp(){
        return QueueBuilder.durable("inv.q-sync-maindp").withArgument("x-dead-letter-exchange", "inv.exc-dlq-sync-maindp")
                .withArgument("x-dead-letter-routing-key", "dlq.inv.maindp").build();
    }

    @Bean
    public Binding mainDpBinding(){
        return BindingBuilder.bind(qSyncMainDp()).to(topicExcSyncMainDp()).with("q.inv.maindp");
    }

    // exchagne and queue for DLQ
    @Bean
    public TopicExchange topicExcDlq(){
        return new TopicExchange("inv.exc-dlq-sync-maindp");
    }

    @Bean
    public Queue qDlqMainDp(){
        return new Queue("inv.q-dlq-sync-maindp");
    }

    @Bean
    public Binding dlqBinding(){
        return BindingBuilder.bind(qDlqMainDp()).to(topicExcDlq()).with("dlq.inv.maindp");
    }

}
