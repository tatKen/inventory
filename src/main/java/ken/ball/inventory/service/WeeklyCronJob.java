package ken.ball.inventory.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Slf4j
public class WeeklyCronJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try{
            log.info("running WeeklyCronJob at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMDD hhmmss")));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


