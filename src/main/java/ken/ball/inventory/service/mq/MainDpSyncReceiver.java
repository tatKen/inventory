package ken.ball.inventory.service.mq;

import ken.ball.inventory.model.MainDPRequestDTO;
import ken.ball.inventory.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RequiredArgsConstructor
public class MainDpSyncReceiver {
    @Autowired
    private final CardService cardService;

    private final String id;

    @RabbitHandler
    @RabbitListener(queues = "inv.q-sync-maindp")
    public void receive(MainDPRequestDTO dto) throws Exception {
        log.info(String.format("the dto received on receiver [%s] = %s", id, dto));

        // save the main dp
        try {
            cardService.createMainDp(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
