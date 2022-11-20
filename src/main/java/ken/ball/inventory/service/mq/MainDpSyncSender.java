package ken.ball.inventory.service.mq;

import ken.ball.inventory.model.MainDPRequestDTO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MainDpSyncSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(){
        // send the mainDP
        MainDPRequestDTO requestDto = MainDPRequestDTO.mDPRequestBuilder()
                .name("YCKF234")
                .cardType("MAIN-FIBER-DP")
                .floor("G")
                .status("W")
                .mainDpCd("F234")
                .exchangeCd("YCK")
                .build();

        this.rabbitTemplate.convertAndSend(queue.getName(), requestDto);
        log.info(String.format("[MainDpSyncSender] messge sent"));
    }

}
