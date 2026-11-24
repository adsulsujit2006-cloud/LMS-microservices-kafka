
package com.loan_management_system_notifications.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.loan_management_system_notifications.services.NotificationServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationServicesImpl implements NotificationServices {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String to, String subject, String body) {

        log.info("Sending HTML mail to {}", to);

        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);

            // true = HTML mail
            helper.setText(body, true);

            javaMailSender.send(message);

            log.info("HTML mail sent successfully to {}", to);

        } catch (MessagingException e) {

            log.error("Failed to send mail to {}", to, e);

            throw new RuntimeException("Failed to send email", e);
        }
    }
}
