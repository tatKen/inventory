package ken.ball.inventory.config;

import ken.ball.inventory.jobs.FixedDateCronJob;
import ken.ball.inventory.jobs.WeeklyCronJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

//@Slf4j
//@RequiredArgsConstructor
//@AutoConfigureAfter(QuartzAutoConfiguration.class)
//@Configuration
public class SchedulerConfig {

//    private final Scheduler scheduler;
//    @Value("${app.ball.weekly.cron}")
//    private String weeklyCron;
//    @Value("${app.ball.fixday.cron}")
//    private String fixDayCron;
//
//    @PostConstruct
//    public void scheduleJobs() throws SchedulerException{
//        // delete old batch jobs
//        for(JobKey key: scheduler.getJobKeys(GroupMatcher.jobGroupEquals("batch"))){
//            scheduler.deleteJob(key);
//        }
//
//        // Deploy batch jobs
//        JobDetail wekklyJobDetail = JobBuilder.newJob(WeeklyCronJob.class)
//                .withIdentity(JobKey.jobKey("week_cron_job", "batch"))
//                .withDescription("Running weekly job").build();
//        Trigger weeklyTrigger = TriggerBuilder.newTrigger().withIdentity("week_cron_trigger").forJob(wekklyJobDetail)
//                .withSchedule(CronScheduleBuilder.cronSchedule(weeklyCron)).build();
//        scheduler.scheduleJob(wekklyJobDetail, weeklyTrigger);
//
//        JobDetail fixDayJobDetail = JobBuilder.newJob(FixedDateCronJob.class)
//                .withIdentity(JobKey.jobKey("fixed_date_dron_job", "batch"))
//                .withDescription("Running fixed day job").build();
//        Trigger fixedDayTrigger = TriggerBuilder.newTrigger().withIdentity("fixed_date_trigger").forJob(fixDayJobDetail)
//                .withSchedule(CronScheduleBuilder.cronSchedule(fixDayCron)).build();
//        scheduler.scheduleJob(fixDayJobDetail, fixedDayTrigger);
//    }

}



/*
*
*
        // Deploy batch jobs
        JobDetail jobDetail = JobBuilder.newJob(OtpFileJob.class)
                .withIdentity(JobKey.jobKey("otp_file_job", Constants.QUARTZ_JOB_GROUP_BATCH))
                .withDescription("Download Otp File Job").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("otp_file_trigger").forJob(jobDetail)
                .withSchedule(CronScheduleBuilder.cronSchedule(otpFileCron)).build();
        scheduler.scheduleJob(jobDetail, trigger);

        JobDetail jobDetail2 = JobBuilder.newJob(InterimBlacklistFileJob.class)
                .withIdentity(JobKey.jobKey("interim_blacklist_file_job", Constants.QUARTZ_JOB_GROUP_BATCH))
                .withDescription("Download Interim Blacklist File Job").build();
        Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("interim_blacklist_file_trigger").forJob(jobDetail2)
                .withSchedule(CronScheduleBuilder.cronSchedule(interimBlacklistFileCron)).build();
        scheduler.scheduleJob(jobDetail2, trigger2);
    }
}
*
* */