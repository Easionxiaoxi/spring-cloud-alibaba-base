package com.xyz.base.domain.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 下载入参
 */
@Data
public class DownForm {
    @NotBlank(message = "请传入文件ID")
    private String fileId;
}
