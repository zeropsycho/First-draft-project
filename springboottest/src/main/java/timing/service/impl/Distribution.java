package timing.service.impl;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Distribution implements Job {
    /**
     * 通过ser方法与同名key进行反射调用
     */

    public Distribution() {}

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("执行：" + sdf.format(new Date()));

//        当前时间sdf
        // 获取开始时间
        Trigger trigger = context.getTrigger();
        try {
            System.err.println("--三秒后执行");
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("触发器信息：\nStratTime：" + sdf.format(trigger.getStartTime())/* + "\tEndTime："
                + sdf.format(trigger.getEndTime())*/);
        // 获取detail信息
        /*JobKey detailKey = context.getJobDetail().getKey();
        TriggerKey triggerKey = context.getTrigger().getKey();
        System.err.println("------My Detail name group are: " + detailKey.getName()
        + "--------Group: " + detailKey.getGroup());
        System.err.println("------My Trigger name group are: " + triggerKey.getName()
        + "--------TriggerGroup: " + triggerKey.getGroup());
        // 获取参数值
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        // Job合并后优先选择Trigger参数
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String message = jobDataMap.getString("message");
        Float float1 = jobDataMap.getFloat("float1");

        System.err.println("带参参数值(String)：" + message);
        System.err.println("带参参数值(Float)：" + float1);*/
    }
}
