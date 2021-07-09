package com.xyz.base.domain.converter;

import com.xyz.base.domain.form.DownForm;
import com.xyz.base.domain.vo.DownVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

/**
 * 类型转换
 */
public class LoadConverter {

    public static DownVO formToVO(DownForm form) {
        DownVO vo = new DownVO();
        if (!ObjectUtils.isEmpty(form)) {
            BeanUtils.copyProperties(form, vo);
        }
        return vo;
    }
}
