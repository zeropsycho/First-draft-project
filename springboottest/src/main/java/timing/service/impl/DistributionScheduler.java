package timing.service.impl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DistributionScheduler {

    /**
     * 创建一个JobDetail实例，讲该实例与TimingJob绑定
     */
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.err.println("当前时间：" + sdf.format(date));
        JobDetail jobDetail = JobBuilder.newJob(Distribution.class)
                .withIdentity("detailName", "DetailGroupId")
                .usingJobData("message", "信息")
                .usingJobData("float1", 5.0f)
                .build();
        // 创建一个Trigger实例，定义该job立即执行，每个五秒重复执行一次
        /**
         * settings StartTime and EndTime
         */
        // 设置3秒后开始
        /*date.setTime(date.getTime() + 3000);
        // 设置5秒后结束
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 4000);*/

        /**
         * 指定时间执行指定次数 SimpleTrigger
         */
        // 获取四秒后的时间
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 4000);
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 12000);
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
//        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "TriggerGroupId")
                .usingJobData("message", "信息")
                .usingJobData("float1", 3.0f)
                /*.startAt(startDate) // 触发开始
                .endAt(endDate)// 触发结束*/
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(2)
                                .withRepeatCount(3))
                .build();
        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            // 将时间的 与 执行时间绑定在scheduler
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.shutdown(false);
            System.err.println("Scheduler shutdown :" + scheduler.isShutdown());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
