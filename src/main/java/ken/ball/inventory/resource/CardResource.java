package ken.ball.inventory.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import ken.ball.inventory.entity.Card;
import ken.ball.inventory.entity.Splitter;
import ken.ball.inventory.model.CardRequestDTO;
import ken.ball.inventory.model.MainDPRequestDTO;
import ken.ball.inventory.model.SplitterRequestDTO;
import ken.ball.inventory.service.CardService;
import ken.ball.inventory.service.mq.MainDpSyncSender;
import ken.ball.inventory.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/card")
public class CardResource {
    private final CardService cardService;
    private final MainDpSyncSender mainDpSyncSender;

    // MediaType.APPLICATION_JSON_VALUE
    // MediaType.APPLICATION_OCTET_STREAM_VALUE
    // MediaType.APPLICATION_FORM_URLENCODED_VALUE
    // MediaType.TEXT_PLAIN_VALUE

    @PostMapping(value = "/readTypicalJson", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<String> readTypicalJson(@RequestBody CardRequestDTO card){
        log.info("----------------- enter readTypicalJson --------------------------");
        log.info("[createSplitter] input card="+card.toString());
        try {
//            cardService.createSplitter(card);
//            return ResponseEntity.ok().body("success");
            return ResponseEntity.ok().body("receive card=" + card.toString());
        } catch(Exception e) {
            e.printStackTrace();
            log.error("fail to create splitter with reason=" + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("health check ok");
    }

//    @PostMapping(value = "/readJsonWithLombok", consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<String> readJsonWithLombok(@RequestBody CardLomBokReqDTO card){
//        log.info("----------------- enter readJsonWithLombok --------------------------");
//        log.info("[readJsonWithLombok] input card="+card.toString());
//        try {
////            cardService.createSplitter(card);
////            return ResponseEntity.ok().body("success");
//            return ResponseEntity.ok().body("receive readJsonWithLombok card=" + card.toString());
//        } catch(Exception e) {
//            e.printStackTrace();
//            log.error("fail to create splitter with reason=" + e);
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping(value = "/readJsonByEntity")
    public ResponseEntity<String> readJsonByEntity(@RequestBody Card card){
        log.info("----------------- enter readJsonByEntity --------------------------");
        log.info("[readJsonByEntity] input card="+card.toString());
        try {
//            cardService.createSplitter(card);
//            return ResponseEntity.ok().body("success");
            return ResponseEntity.ok().body("receive readJsonByEntity card=" + card.toString());
        } catch(Exception e) {
            e.printStackTrace();
            log.error("readJsonByEntity fail with reason=" + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/syncMainDP")
    public ResponseEntity<String> syncMainDP(@RequestBody MainDPRequestDTO mainDpDto){
        log.info("----------------- enter syncMainDP --------------------------");
        log.info(String.format("[readJsonByEntity] input card=%s", mainDpDto));
        try {
            mainDpSyncSender.send();
            return ResponseEntity.ok().body(String.format("already sent to queue with dto=%s", mainDpDto));
        } catch(Exception e) {
            e.printStackTrace();
            log.error("readJsonByEntity fail with reason=" + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PostMapping(value = "/createSplitter")
//    public ResponseEntity<String> createSplitter(@RequestBody SplitterRequestDTO dto){
//        log.info("----------------- enter readJsonByEntity --------------------------");
//        log.info("[readJsonByEntity] input card="+dto.toString());
//        try {
//            Splitter splitter = new Splitter();
//            splitter.setSplitterClass(dto.getSplitterClass());
//            splitter.setOltId(CommonUtils.strNullToEmpty(dto.getOltId()));
//            splitter.setSlotId(CommonUtils.strNullToEmpty(dto.getSlotId()));
//            splitter.setInterfaceNo(CommonUtils.strNullToEmpty(dto.getInterfaceNo()));
//            splitter.setBwB(Optional.ofNullable(dto.getBwB()).orElse(0));
//            splitter.setBwP(Optional.ofNullable(dto.getBwP()).orElse(0));
//            splitter.setBwV(Optional.ofNullable(dto.getBwV()).orElse(0));
//            splitter.setBwS(Optional.ofNullable(dto.getBwS()).orElse(0));
//            splitter.setCreatedBy(CommonUtils.strNullToEmpty(dto.getCreatedBy()));
//            splitter.setLastModifiedBy(CommonUtils.strNullToEmpty(dto.getCreatedBy()));
//
//            Card card = new Card();
//            card.setName(CommonUtils.strNullToEmpty(dto.getName()));
//            card.setCardType(CommonUtils.strNullToEmpty(dto.getCardType()));
//            card.setStatus(CommonUtils.strNullToEmpty(dto.getStatus()));
//            card.setFloor(CommonUtils.strNullToEmpty(dto.getFloor()));
//            card.setSparePortCnt(Optional.ofNullable(dto.getSparePortCnt()).orElse(0));
//            card.setSplitter(splitter);
//            card.setCreatedBy(CommonUtils.strNullToEmpty(dto.getCreatedBy()));
//            card.setLastModifiedBy(CommonUtils.strNullToEmpty(dto.getCreatedBy()));
//
//            cardService.createSplitter(card);
//            return ResponseEntity.ok().body(String.format("create splitter success for splitter [%s]", dto.getName()));
//        } catch(Exception e) {
//            e.printStackTrace();
//            log.error("readJsonByEntity fail with reason=" + e);
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    // MediaType.MULTIPART_FORM_DATA_VALUE
//    @PostMapping(value = "/multipartWithFile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseEntity<?> multipartWithFile(@RequestParam("fileName") String fileName, @RequestPart("file") File file){
//
//    }

}
