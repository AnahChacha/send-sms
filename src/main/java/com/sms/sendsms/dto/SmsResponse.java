package com.sms.sendsms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsResponse{

	@JsonProperty("SMSMessageData")
	private SMSMessageData sMSMessageData;
}