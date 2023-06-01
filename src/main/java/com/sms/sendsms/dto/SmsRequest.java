package com.sms.sendsms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequest {
    private String phoneNumber;

    private String message;

    private String from;
}
