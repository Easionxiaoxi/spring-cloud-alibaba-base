package com.xyz.base.service.spring.impl;

import com.xyz.base.common.model.Result;
import com.xyz.base.domain.form.DownForm;
import com.xyz.base.domain.vo.DownVO;
import com.xyz.base.service.spring.DownloadService;
import com.xyz.base.domain.converter.LoadConverter;
import org.springframework.stereotype.Service;

/**
 * 下载服务实现
 */
@Service
public class DownloadServiceImpl implements DownloadService {
    /**
     * 下载
     *
     * @param form 下载参数
     */
    @Override
    public Result<DownVO> down(DownForm form) {
        return Result.success(LoadConverter.formToVO(form));
    }
}
