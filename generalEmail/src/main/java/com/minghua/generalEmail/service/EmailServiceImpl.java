package com.minghua.generalEmail.service;

import minghua.utils.P;

import java.util.Map;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-4
 */
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(final String templateId, final Map<String, Object> args, final String... recivers) {
        Thread t = new Thread("send emil  thread") {
            public void run() {
//                if (StringUtils.isEmpty(templateId) || recivers == null  || recivers.length == 0)
//                    return;
                P.rintln("template id is :" + templateId);
                System.out.print(Thread.currentThread().getName());
                P.rintln(templateId + args.get("user") + recivers[0]);
            }
        };
        t.start();
    }
}
