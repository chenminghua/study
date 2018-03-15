package com.minghua.generalEmailService;

import com.minghua.generalEmail.service.EmailService;
import com.minghua.generalEmail.service.EmailServiceImpl;
import minghua.common.utils.P;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-5
 */
public class EmailServiceTest {
    @Test
    public void testSendEmail() {
        for (int i = 0; i < 5; i++){
            P.rintln("send " + i + "封邮件。。。。");
            String templateId = "" + i;
            Map<String, Object> args = new HashMap<String , Object>();
            args.put("user", "user" + i);
            EmailService emailService = new EmailServiceImpl();
            emailService.sendEmail(templateId, args, i + "");
        }
    }
}
