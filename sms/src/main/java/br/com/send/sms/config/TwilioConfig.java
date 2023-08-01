package br.com.send.sms.config;

import com.twilio.Twilio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties("twilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioConfig {

    private String accountSid;
    private String authToken;
    @NotBlank
    private String trialNumber;
    @NotBlank
    private  String phoneNumber;
    @NotBlank
    private  String message;

    @Bean
    public TwilioConfig getTwilioConfig(TwilioConfig twilioConfig) {
        Twilio.init(this.getAccountSid(), this.getAuthToken());
        return twilioConfig;
    }
}
