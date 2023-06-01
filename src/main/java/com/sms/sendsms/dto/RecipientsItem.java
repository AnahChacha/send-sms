package com.sms.sendsms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientsItem{

	@JsonProperty("number")
	private String number;

	@JsonProperty("cost")
	private String cost;

	@JsonProperty("messageId")
	private String messageId;

	@JsonProperty("statusCode")
	private Integer statusCode;

	@JsonProperty("status")
	private String status;
}