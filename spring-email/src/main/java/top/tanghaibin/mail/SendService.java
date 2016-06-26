package top.tanghaibin.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by tangh on 2016/5/12.
 */
@Service
public class SendService {

    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage mailMessage;

    public void send(){
        mailSender.send(mailMessage);
    }
}
