package com.xyz.base.service.dubbo.impl;

import com.xyz.base.common.model.Result;
import com.xyz.base.domain.converter.LoadConverter;
import com.xyz.base.domain.form.DownForm;
import com.xyz.base.domain.vo.DownVO;
import com.xyz.base.service.dubbo.DubboLoadService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 下载服务实现
 */
@Service
public class DubboLoadServiceImpl implements DubboLoadService {
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
