package com.sms.sendsms.controller;
import com.sms.sendsms.dto.SmsResponse;
import com.sms.sendsms.service.IMessageReceiver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/sms")
public class SmsController {
    private final IMessageReceiver iMessageReceiver;

    public SmsController(IMessageReceiver iMessageReceiver) {
        this.iMessageReceiver = iMessageReceiver;
    }

    @PostMapping(value = "/send")
    public ResponseEntity<SmsResponse>sendSms(){
        return ResponseEntity.ok(iMessageReceiver.sendSms());
    }
}
