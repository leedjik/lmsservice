package com.lmsproject.lmsservice.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class MailComponents {

    private final JavaMailSender javaMailSender;

    public void sendMailTest(){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("leedjik@naver.com");
        simpleMailMessage.setSubject("안녕하세요. LMS에서 알려 드립니다.");
        simpleMailMessage.setText("안녕하세요. 본 메일이 정상적으로 송신되었습니다.");

        javaMailSender.send(simpleMailMessage);
    }

    public boolean sendMail(String mail, String subject, String text){

        boolean result = false;

        MimeMessagePreparator msg = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(mail);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);
            }
        };
        try{
            javaMailSender.send(msg);
            result = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return result;
    }
}

