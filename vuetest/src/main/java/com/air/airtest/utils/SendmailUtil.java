package com.air.airtest.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SendmailUtil {
    private static String myEmailSMTPHost = "smtp.qq.com";

    private static String myEmailAccount = "892754472@qq.com";

    private static String myEmailPassword = "brldhytlnjxibebe";

    public static void sendEmail(String toEmailAddress, String emailTitle, String emailContent) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.smtp.port", 465);
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        props.setProperty("mail.transport.protocol", "smtp");
        /**SSL认证，注意腾讯邮箱是基于SSL加密的，所以需要开启才可以使用**/
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getInstance(props);
        Message msg = new MimeMessage(session);
        msg.setSubject(emailTitle);
        StringBuilder builder = new StringBuilder();
        builder.append("\n" + emailContent);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.append("邮件发送时间" + sdf.format(new Date()));
        msg.setSentDate(new Date());
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress(myEmailAccount, "嘉丽酒店管理系统提醒", "UTF-8"));
        Transport transport = session.getTransport();

        transport.connect(myEmailSMTPHost, myEmailAccount, myEmailPassword);
        transport.sendMessage(msg, new Address[]{new InternetAddress(toEmailAddress)});
        OutputStream out = new FileOutputStream("MyEmail.eml");
        msg.writeTo(out);
        out.flush();
        out.close();
        transport.close();

    }
}
