package com.blog.orderserver03sms.controller;

import com.blog.orderserver03sms.pojo.SmsStatus;
import com.blog.orderserver03sms.sms.SendCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendCodeController {

    @RequestMapping("/checkPhoneNum")
    public SmsStatus checkPhoneNum(String mobile){
        SmsStatus smsStatus = null;
        try {
            smsStatus = SendCode.sendCoreGo(mobile);
        } catch (Exception e) {
            smsStatus = null;
            e.printStackTrace();
        }
        return smsStatus;
    }
}
