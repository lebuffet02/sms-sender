package br.com.send.sms.service;

import br.com.send.sms.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioService.class);

    public void sendSms(TwilioConfig twilio) throws RuntimeException {
        Message.creator(new PhoneNumber(twilio.getPhoneNumber()), new PhoneNumber(twilio.getTrialNumber()), twilio.getMessage()).create();
        LOGGER.info(String.format("\n Número: ---> [%s]  Mensagem: ---> [%s]", twilio.getPhoneNumber(), twilio.getMessage()));
    }
}

