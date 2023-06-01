package com.sms.sendsms.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSMessageData{

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Recipients")
	private List<RecipientsItem> recipients;
}