package do_an.bean;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailer")

public class Xmailler {
@Autowired
JavaMailSender mailer;
	
	public void send(String email,String name, String feedback){
		try{
			MimeMessage mail=mailer.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(mail,true,"utf-8");
		
			helper.setFrom(email,email);
		
			helper.setTo("dungbiuit92@gmail.com");
			helper.setSubject("Feedback From User" +name);
			helper.setText(feedback,true);
			mailer.send(mail);
		}catch(Exception ex){
		throw new RuntimeException(ex);
		}
	}
}