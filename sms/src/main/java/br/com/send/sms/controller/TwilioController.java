package br.com.send.sms.controller;

import br.com.send.sms.config.TwilioConfig;
import br.com.send.sms.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    @Autowired
    TwilioService smsService;

    @PostMapping
    ResponseEntity<?> sendSms(@RequestBody TwilioConfig twilio) {
        smsService.sendSms(twilio);
        return ResponseEntity.ok().build();
    }
}
