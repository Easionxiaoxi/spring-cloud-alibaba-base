package com.xyz.base.service.dubbo;

import com.xyz.base.common.model.Result;
import com.xyz.base.domain.form.DownForm;
import com.xyz.base.domain.vo.DownVO;

/**
 * 下载服务
 */
public interface DubboLoadService {
    /**
     * 下载
     *
     * @param form 下载参数
     */
    Result<DownVO> down(DownForm form);
}
