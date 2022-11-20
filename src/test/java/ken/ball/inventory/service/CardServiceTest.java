package ken.ball.inventory.service;

import ken.ball.inventory.entity.LocalDP;
import ken.ball.inventory.model.LocalDPRequestDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardServiceTest {
    @Autowired
    CardService cardService;

    @Test
    public void testCreateLocalDp(){
        try {

            LocalDPRequestDTO lDpDto = LocalDPRequestDTO.lDpRequestBuilder()
                    .name("YCKF234GA")
                    .cardType("LOCAL-FIBER-DP")
                    .status("W")
                    .floor("18")
                    .sparePortCnt(1)
                    .exchangeCd("YCK")
                    .mainDpCd("F234")
                    .localDpCd("GA")
                    .odnFrom(0)
                    .odnTo(30)
                    .build();
//            cardService.createLocalDp(lDpDto);

            ModelMapper mapper = new ModelMapper();
            mapper.addMappings(new PropertyMap<LocalDPRequestDTO, LocalDP>() {
                @Override
                protected void configure() {
                    skip(destination.getCard());
                }
            });
            LocalDP localDP = mapper.map(lDpDto, LocalDP.class);

            System.out.println(String.format("[testCreateLocalDp] localDp mapped=%s", localDP));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}