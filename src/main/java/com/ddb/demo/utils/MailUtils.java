package com.ddb.demo.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 使用SMTP协议发送电子邮件
 */
public class MailUtils {

	// 邮件发送协议
	private final static String PROTOCOL = "smtp";

	// SMTP邮件服务器
	private final static String HOST = "smtp.163.com";

	// SMTP邮件服务器默认端口
	private final static String PORT = "25";

	// 是否要求身份认证
	private final static String IS_AUTH = "true";

	// 是否启用调试模式（启用调试模式可打印客户端与服务器交互过程时一问一答的响应消息）
	private final static String IS_ENABLED_DEBUG_MOD = "true";

	// 发件人
	private static String from = "itbiaoyang@163.com";

	// 收件人
	private static String to = "1593917333@qq.com";

	// 初始化连接邮件服务器的会话信息
	private static Properties props = null;

	static {
		props = new Properties();
		props.setProperty("mail.transport.protocol", PROTOCOL);
		props.setProperty("mail.smtp.host", HOST);
		props.setProperty("mail.smtp.port", PORT);
		props.setProperty("mail.smtp.auth", IS_AUTH);
		props.setProperty("mail.debug", IS_ENABLED_DEBUG_MOD);
	}

	/**
	 * 发送简单的文本邮件
	 */
	public static boolean sendTextEmail(String to) throws Exception {
		try {
			// 创建Session实例对象
			Session session1 = Session.getDefaultInstance(props);

			// 创建MimeMessage实例对象
			MimeMessage message = new MimeMessage(session1);
			// 设置发件人
			message.setFrom(new InternetAddress(from));
			// 设置邮件主题
			message.setSubject("内燃机注册验证码");
			// 设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置发送时间
			message.setSentDate(new Date());
			// 设置纯文本内容为邮件正文
			
			message.setText("您的验证码是:!验证码有效期是10分钟，过期后请重新获取！" + "中国内燃机学会");
			// 保存并生成最终的邮件内容
			message.saveChanges();

			// 获得Transport实例对象
			Transport transport = session1.getTransport();
			// 打开连接
			transport.connect(from, "密码");//////////////////////////////////////记得输入密码
			// 将message对象传递给transport对象，将邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			// 关闭连接
			transport.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		sendTextEmail(to);
	}
}

