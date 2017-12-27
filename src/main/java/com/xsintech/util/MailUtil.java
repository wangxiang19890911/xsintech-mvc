package com.xsintech.util;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import java.util.Date;

import java.util.Properties;

import java.util.UUID;

public class MailUtil {

	public static String RandomCode;

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	public static String myEmailAccount = "xiao2kun742@163.com";

	public static String myEmailPassword = "304058615";

	public static String myEmailSMTPHost = "smtp.163.com";

	public boolean SendMail(String receiveMailAccount, String from, String to, String title) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(myEmailAccount, "�Ŵ��������޹�˾", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO,
				new InternetAddress(receiveMailAccount, "�װ����û�", "UTF-8"));
		message.setSubject(title, "UTF-8");
		RandomCode = generateShortUuid();
		this.setMessageContent(message, "", RandomCode);
		message.setSentDate(new Date());
		message.saveChanges();
		Transport transport = session.getTransport();
		transport.connect(myEmailAccount, myEmailPassword);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		return true;
	}

	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	public void setMessageContent(Message message, String ContentType, String RandomCode) throws MessagingException {
		String Content = "内容" + RandomCode;
		MimeMultipart mmt = new MimeMultipart();
		MimeBodyPart mbp = new MimeBodyPart();
		if (ContentType == null || ContentType.equals(""))
			mbp.setText(Content);
		else
			mbp.setContent(Content, ContentType);
		mmt.addBodyPart(mbp);
		message.setContent(mmt);
	}

}
