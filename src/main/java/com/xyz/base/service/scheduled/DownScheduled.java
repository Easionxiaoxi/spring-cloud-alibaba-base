package com.xyz.base.service.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 */
@Service
public class DownScheduled {
    /**
     * 定时任务（分布式请使用xxl-job）
     * 执行完毕后延迟30s执行一次
     */
    @Scheduled(fixedDelay = 30000)
    public void parseFormJson() {
        System.out.println("定时任务");
    }
}
