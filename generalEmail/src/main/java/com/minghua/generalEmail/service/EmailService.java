package com.minghua.generalEmail.service;

import java.util.Map;
import java.util.Set;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-4
 */
public interface EmailService {

    /**
     * @param templateId
     * @param args
     * @param recivers
     */
    void sendEmail(String templateId, Map<String, Object> args,  String ... recivers);
}
