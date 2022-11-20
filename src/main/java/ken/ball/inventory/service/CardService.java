package ken.ball.inventory.service;

import ken.ball.inventory.config.Constant;
import ken.ball.inventory.entity.Card;
import ken.ball.inventory.entity.LocalDP;
import ken.ball.inventory.entity.MainDP;
import ken.ball.inventory.model.CardRequestDTO;
import ken.ball.inventory.model.LocalDPRequestDTO;
import ken.ball.inventory.model.MainDPRequestDTO;
import ken.ball.inventory.repository.CardRepository;
import ken.ball.inventory.repository.LocalDPRepository;
import ken.ball.inventory.repository.SplitterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;

@Slf4j
@RequiredArgsConstructor
@Service
public class CardService {
    private final CardRepository cardRepository;
    private final SplitterRepository splitterRepository;
    private final LocalDPRepository localDPRepository;

    private final Predicate<CardRequestDTO> isEmptyName = (card) -> card.getName().isEmpty();
    private final Predicate<CardRequestDTO> isStatusWorking = (card) -> card.getStatus().equalsIgnoreCase(Constant.INV_STATUS_WORKING);
    private final Predicate<CardRequestDTO> isValidCard = isEmptyName.negate().and(isStatusWorking);

    public void initCardData(){

    }

    public void createSplitter(Card card) throws Exception{
        try {
            // if card not null then process
            if (Optional.of(card).isPresent()) {
                log.info("insert card");
//                if (isValidCard.test(card)) {
//                    cardRepository.findByName(card.getName()).orElseGet(() -> cardRepository.save(card));
////                    cardRepository.save(card);
//                    if (Optional.of(card.getSplitter()).isPresent()) {
//                        log.info("insert splitter");
//                        splitterRepository.save(card.getSplitter());
//                    }
//                }
            } else {
                log.info("invalid card");
                throw new Exception("Invalid card");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public synchronized void createLocalDp(LocalDPRequestDTO ldpDto) throws Exception{
        try {
            // if card not null then process
            if (Optional.of(ldpDto).isPresent()) {
                log.info("validate card");
                if (isValidCard.test(ldpDto)) {
                    // insert card
                    Card card = Card.CardBuilder()
                            .name(ldpDto.getName())
                            .cardType(ldpDto.getCardType())
                            .floor(ldpDto.getFloor())
                            .status(ldpDto.getStatus())
                            .sparePortCnt(ldpDto.getSparePortCnt())
                            .createdBy("ArchitectKen")
                            .lastModifiedBy("ArchitectKen")
                            .build();

                    // insert Local DP
                    LocalDP localDP = LocalDP.LocalDPBuilder()
                            .exchangeCd(ldpDto.getExchangeCd())
                            .mainDpCd(ldpDto.getMainDpCd())
                            .localDpCd(ldpDto.getLocalDpCd())
                            .odnFrom(ldpDto.getOdnFrom())
                            .odnTo(ldpDto.getOdnTo())
                            .createdBy("ArchitectKen")
                            .lastModifiedBy("ArchitectKen")
                            .build();

                    card.setLocalDP(localDP);

                    log.debug(String.format("[CardService] insert card=%s", card));
                    log.debug(String.format("[CardService] insert LDP=%s", card.getLocalDP().toString()));
                    cardRepository.findByName(card.getName()).orElseGet(() -> cardRepository.save(card));
                }
            } else {
                log.info("invalid card");
                throw new Exception("Invalid card");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public synchronized void createMainDp(MainDPRequestDTO mdpDto) throws Exception {
        try{
            // if request dto not null then process
            if(Optional.ofNullable(mdpDto).isPresent()){
                log.info(String.format("validate card"));
                if(isValidCard.test(mdpDto)){
                    // insert card
                    Card card = Card.CardBuilder()
                            .name(mdpDto.getName())
                            .cardType(mdpDto.getCardType())
                            .floor(mdpDto.getFloor())
                            .status(mdpDto.getStatus())
                            .sparePortCnt(mdpDto.getSparePortCnt())
                            .createdBy("ArchitectKen")
                            .createdDateTime(LocalDateTime.now())
                            .lastModifiedBy("ArchitectKen")
                            .lastModifiedDateTime(LocalDateTime.now())
                            .build();

                    // insert Main DP
                    MainDP mainDP = MainDP.MainDPBuilder()
                            .mainDpCd(mdpDto.getMainDpCd())
                            .exchangeCd(mdpDto.getExchangeCd())
                            .createdBy("ArchitectKen")
                            .createdDateTime(LocalDateTime.now())
                            .lastModifiedBy("ArchitectKen")
                            .lastModifiedDateTime(LocalDateTime.now())
                            .build();

                    card.setMainDP(mainDP);

                    log.debug(String.format("[createMainDp] insert card=%s", card));
                    log.debug(String.format("[createMainDp] insert MDP=%s", card.getMainDP().toString()));
                    cardRepository.findByName(card.getName()).orElseGet(() -> cardRepository.save(card));
                }
            } else {
                log.info("invalid card");
                throw new Exception("Invalid card");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

}
