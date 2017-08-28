package com.xsintech.email;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Main {
		    // �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
		    // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��, 
		    //     ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
		    public static String myEmailusername = "zihang.chen@xsintech.com";
		    public static String myEmailPassword = "Aa18636557889";

		    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
		    // ����163����� SMTP ��������ַΪ: smtp.163.com
		    public static String myEmailSMTPHost = "smtp.mxhichina.com";

		    // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
		    public static String receiveMailAccount = "421804261@qq.com";
		    public static void main(String[] args) throws Exception {
		        // 1. ������������, ���������ʼ��������Ĳ�������
		        Properties props = new Properties();                    // ��������
		        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
		        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
		        props.setProperty("mail.smtp.auth", "true"); 
	        // 1. ����һ���ʼ�
//	        Properties props = new Properties();                // ���������ʼ��������Ĳ������ã������ʼ�ʱ����Ҫ�õ���
//	        Session session= Session.getDefaultInstance(props); // ���ݲ������ã������Ự����Ϊ�˷����ʼ�׼���ģ�
//	        MimeMessage message = new MimeMessage(session);     // �����ʼ�����

	        /*
	         * Ҳ���Ը������е�eml�ʼ��ļ����� MimeMessage ����
	         * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
	         */
	        final String smtpPort = "25";
	        props.setProperty("mail.smtp.port", smtpPort);
	        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.setProperty("mail.smtp.socketFactory.fallback", "ture");
	        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

	        // 2. �������ô����Ự����, ���ں��ʼ�����������
	        Session session = Session.getDefaultInstance(props);
	        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

	        // 3. ����һ���ʼ�
	        MimeMessage message = createMimeMessage(session,myEmailusername, receiveMailAccount);

	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();

	        // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
	        // 
	        //    PS_01: �ɰܵ��жϹؼ��ڴ�һ��, ������ӷ�����ʧ��, �����ڿ���̨�����Ӧʧ��ԭ��� log,
	        //           ��ϸ�鿴ʧ��ԭ��, ��Щ����������᷵�ش������鿴�������͵�����, ���ݸ����Ĵ���
	        //           ���͵���Ӧ�ʼ��������İ�����վ�ϲ鿴����ʧ��ԭ��
	        //
	        //    PS_02: ����ʧ�ܵ�ԭ��ͨ��Ϊ���¼���, ��ϸ������:
	        //           (1) ����û�п��� SMTP ����;
	        //           (2) �����������, ����ĳЩ���俪���˶�������;
	        //           (3) ���������Ҫ�����Ҫʹ�� SSL ��ȫ����;
	        //           (4) �������Ƶ��������ԭ��, ���ʼ��������ܾ�����;
	        //           (5) ������ϼ��㶼ȷ������, ���ʼ���������վ���Ұ�����
	        //
	        //    PS_03: ��ϸ��log, ���濴log, ����log, ����ԭ����log��˵����
	        transport.connect(myEmailusername, myEmailPassword);

	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());

	        // 7. �ر�����
	        transport.close();
	    }
		    /**
		     * ����һ��ֻ�����ı��ļ��ʼ�
		     *
		     * @param session �ͷ����������ĻỰ
		     * @param sendMail ����������
		     * @param receiveMail �ռ�������
		     * @return
		     * @throws Exception
		     */
		    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		        // 1. ����һ���ʼ�
		        MimeMessage message = new MimeMessage(session);

		        // 2. From: ������
		        message.setFrom(new InternetAddress(sendMail, "ĳ����", "UTF-8"));

		        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
		        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX�û�", "UTF-8"));

		        // 4. Subject: �ʼ�����
		        message.setSubject("zxczxc", "UTF-8");

		        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
		        message.setContent("asdasdsadsad", "text/html;charset=UTF-8");

		        // 6. ���÷���ʱ��
		        message.setSentDate(new Date());

		        // 7. ��������
		        message.saveChanges();

		        return message;
		    }
		       /*

		       @����ʼ�������������

		       */

		       public void setMessageContent(Message message, String ContentType,String RandomCode)throws MessagingException {
		              String Content="�𾴵��û������ã�������֤���ǣ� "+RandomCode;
		              MimeMultipart mmt = new MimeMultipart();
		              MimeBodyPart mbp = new MimeBodyPart();
		              if(ContentType == null || ContentType.equals("")) {// ContentTypeΪ�������ͣ���GBK��
		                     mbp.setText(Content);// ��JavaMail����������
		              } else{
		            	  mbp.setContent(Content,ContentType); // ָ�������ʽ		            
		            	  mmt.addBodyPart(mbp);
		            	  message.setContent(mmt);

		       }

		       }
}
