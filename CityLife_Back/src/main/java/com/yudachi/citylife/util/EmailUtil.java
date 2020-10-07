package com.yudachi.citylife.util;

import com.sun.mail.util.MailSSLSocketFactory;
import com.yudachi.citylife.dto.EmailDto;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(EmailDto emailDto) throws GeneralSecurityException, MessagingException {
        Properties props = new Properties();
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        // 根据propertise创建会话
        Session session = Session.getInstance(props);

        // 根据会话创建邮件信息
        Message msg = new MimeMessage(session);
        // 邮件主题
        msg.setSubject(emailDto.getTitle());

        // 创建文本"节点"
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(emailDto.getContent(), "text/html;charset=UTF-8");
        // 创建混合节点  将图片节点 文件结点 附件结点 加入
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(text);
        // 将混合节点加入邮件中
        msg.setContent(multipart);

        // 设置邮件发送方
        msg.setFrom(new InternetAddress("xxx"));

        // 开始会话传输
        Transport transport = session.getTransport();
        // 连接邮箱   加入自己（发送方）授权码
        transport.connect("smtp.qq.com","xxx", "xxx");

        // 给目标邮箱发送邮件
        transport.sendMessage(msg, new Address[] { new InternetAddress(emailDto.getEmail()) });
        transport.close();

    }
}
