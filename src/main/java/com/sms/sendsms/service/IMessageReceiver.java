package com.sms.sendsms.service;

import com.sms.sendsms.dto.SmsResponse;

public interface IMessageReceiver {
    SmsResponse sendSms();
}
