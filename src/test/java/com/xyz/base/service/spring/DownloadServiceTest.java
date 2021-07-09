package com.xyz.base.service.spring;

import com.xyz.base.common.model.Result;
import com.xyz.base.domain.form.DownForm;
import com.xyz.base.domain.vo.DownVO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadServiceTest extends TestCase {
    @Resource
    DownloadService downloadService;

    @Test
    public void testDown() {
        DownForm form = new DownForm();
        form.setFileId("10086");
        Result<DownVO> result = downloadService.down(form);
        boolean success = Result.isSuccess(result);
        System.out.println("结果 = " + success);
    }
}