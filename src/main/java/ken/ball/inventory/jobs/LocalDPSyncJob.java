package ken.ball.inventory.jobs;

import ken.ball.inventory.model.LocalDPRequestDTO;
import ken.ball.inventory.service.CardService;
import ken.ball.inventory.util.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@AllArgsConstructor
public class LocalDPSyncJob extends QuartzJobBean {

    private final CardService cardService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            processSyncLocalDp();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void processSyncLocalDp() {
        // to do the job logic
        // check if file exists
        String targatFile = "D:\\data\\inventory_sync\\local_dp\\localdp_sync.xlsx";
        Path srcPath = Paths.get(targatFile);

        if(srcPath.toFile().exists()){
            try {
                // open the excel
                FileInputStream srcExcel = new FileInputStream(srcPath.toFile());
                XSSFWorkbook workbook = new XSSFWorkbook(srcExcel);

                // read the file
                XSSFSheet sheet = workbook.getSheetAt(0);
                sheet.iterator().forEachRemaining(row -> {
                    // for each row
                    String name = CommonUtils.strNullToEmpty(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    String cardType = CommonUtils.strNullToEmpty(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    String status = CommonUtils.strNullToEmpty(row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    String floor = CommonUtils.strNullToEmpty(row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    int sparePortCnt = (int)row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                    String exchangeCd = CommonUtils.strNullToEmpty(row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    String mainDpCd = CommonUtils.strNullToEmpty(row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    String localDpCd = CommonUtils.strNullToEmpty(row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
                    int odnFrom = (int)row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                    int odnTo = (int)row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();

//                    LocalDpRequestDTO dto = new LocalDpRequestDTO(name, cardType, status, floor, sparePortCnt, exchangeCd, mainDpCd, localDpCd, odnFrom, odnTo);

                    LocalDPRequestDTO dto = LocalDPRequestDTO.lDpRequestBuilder()
                            .name(name)
                            .cardType(cardType)
                            .status(status)
                            .floor(floor)
                            .sparePortCnt(sparePortCnt)
                            .exchangeCd(exchangeCd)
                            .mainDpCd(mainDpCd)
                            .localDpCd(localDpCd)
                            .odnFrom(odnFrom)
                            .odnTo(odnTo)
                            .build();

                    log.debug(String.format("[executeInternal] request localDp dto=%s", dto.toString()));

                    try {
                        cardService.createLocalDp(dto);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /*
                    *
                    *
                    * private String exchangeCd;
    private String MainDpCd;
    private String localDpCd;
    private Long odnFrom;
    private Long odnTo;
    *
    * private String cardType;          // LOCAL-FIBER-DP

    @NaturalId
    private String name;
    private String status;
    private String floor;
    private Long sparePortCnt;
    *
    *
                    * Iterator<Row> rowIterator = sheet.iterator();
                        while (rowIterator.hasNext())
                        {
                            Row row = rowIterator.next();
                            //For each row, iterate through all the columns
                            Iterator<Cell> cellIterator = row.cellIterator();

                            while (cellIterator.hasNext())
                            {
                                Cell cell = cellIterator.next();
                                //Check the cell type and format accordingly
                                switch (cell.getCellType())
                                {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        System.out.print(cell.getNumericCellValue() + "t");
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        System.out.print(cell.getStringCellValue() + "t");
                                        break;
                                }
                            }
                            System.out.println("");
                        }
                        file.close();
                        * */
                });
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            log.debug("No source file to execute.");
        }
        /*
        *
        *   System.out.println(eachFile.getAbsolutePath());
            Path movetargetPath = Paths.get(prop.getAppOclBackupPath(), eachFile.getName()+"_"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
            Path temp = Files.move(Paths.get(eachFile.getAbsolutePath()), movetargetPath, REPLACE_EXISTING);
            log.info(String.format("[OclInterimBlacklistTask housekeep] file has been moved from %s to %s", Paths.get(eachFile.getAbsolutePath()), movetargetPath));

        *
        * */

    }
}
