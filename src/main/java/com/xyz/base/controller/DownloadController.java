package com.xyz.base.controller;

import com.xyz.base.common.model.Result;
import com.xyz.base.common.util.LoggerUtil;
import com.xyz.base.domain.form.DownForm;
import com.xyz.base.domain.vo.DownVO;
import com.xyz.base.service.spring.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 下载API
 */
@Validated
@RestController
@RequestMapping("/download")
public class DownloadController {
    private final static Logger logger = LoggerFactory.getLogger(DownloadController.class);
    @Resource
    private DownloadService downloadService;

    /**
     * 下载
     */
    @PostMapping("/down")
    public Result<DownVO> down(@Validated @RequestBody DownForm form) {
        LoggerUtil.info(logger, "下载入参 = {0}", form);
        return downloadService.down(form);
    }

}
