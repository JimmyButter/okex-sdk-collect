package com.supermancell.trans.common.constant.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.lang3.StringUtils;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

    //防止一直发邮件
    private static String lastContent = "";
    //邮件服务器主机名
    // QQ邮箱的 SMTP 服务器地址为: smtp.qq.com
    private static String myEmailSMTPHost = "smtp.qq.com";
    //发件人邮箱
    private static String myEmailAccount = "284160266@qq.com";
    //发件人邮箱密码（授权码）
    //在开启SMTP服务时会获取到一个授权码，把授权码填在这里
    private static String myEmailPassword = "gpcmgjmwqlefbica";

    public static synchronized void sendEmail(String emailTitle, String emailContent) {

        if(StringUtils.isEmpty(emailTitle) | StringUtils.isEmpty(emailContent)) {
            return;
        }
        //内容一样的不再发送邮件
        String subContent = emailContent.length() > 42 ?emailContent.substring(0, emailContent.length() - 42):emailContent;

        if(lastContent.length() == 0 || !emailContent.contains(lastContent)){
            sendEmail("284160266@qq.com", emailTitle, emailContent);
            lastContent = subContent;
        }
    }

    /**
     * 邮件单发（自由编辑短信，并发送，适用于私信）
     *
     * @param toEmailAddress 收件箱地址
     * @param emailTitle 邮件主题
     * @param emailContent 邮件内容
     * @throws Exception
     */
    private static void sendEmail(String toEmailAddress, String emailTitle, String emailContent) {

        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "false");

        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");

        // 端口号
        props.put("mail.smtp.port", 465);

        // 设置邮件服务器主机名
        props.setProperty("mail.smtp.host", myEmailSMTPHost);

        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        try {
            /**SSL认证，注意腾讯邮箱是基于SSL加密的，所以需要开启才可以使用**/
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);

            //设置是否使用ssl安全连接（一般都使用）
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            //创建会话
            Session session = Session.getInstance(props);
            session.setDebug(false);
            //获取邮件对象
            //发送的消息，基于观察者模式进行设计的
            Message msg = new MimeMessage(session);

            //设置邮件标题
            msg.setSubject(emailTitle);

            //设置邮件内容
            //使用StringBuilder，因为StringBuilder加载速度会比String快，而且线程安全性也不错
            StringBuilder builder = new StringBuilder();

            //写入内容
            builder.append("\n" + emailContent);

            //设置显示的发件时间
            msg.setSentDate(new Date());

            //设置邮件内容
            msg.setText(builder.toString());

            //设置发件人邮箱
            // InternetAddress 的三个参数分别为: 发件人邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
            msg.setFrom(new InternetAddress(myEmailAccount, "我的工作站", "UTF-8"));

            //得到邮差对象
            Transport transport = session.getTransport();

            //连接自己的邮箱账户
            //密码不是自己QQ邮箱的密码，而是在开启SMTP服务时所获取到的授权码
            //connect(host, user, password)
            transport.connect(myEmailSMTPHost, myEmailAccount, myEmailPassword);

            //发送邮件
            transport.sendMessage(msg, new Address[]{new InternetAddress(toEmailAddress)});

            transport.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
