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

	       //���������֤��

	       public static String[] chars = new String[] { "a", "b","c", "d", "e", "f", "g", "h", "i", "j","k", "l", "m", "n", "o","p", "q", "r", "s", 
	           "t", "u", "v", "w","x", "y", "z", "0", "1","2", "3", "4", "5", 
	           "6", "7", "8", "9","A", "B", "C", "D", "E","F", "G", "H", "I", 
	           "J", "K", "L", "M","N", "O", "P", "Q", "R","S", "T", "U", "V", 
	           "W", "X", "Y", "Z" }; 
	       //�����˵� ���� �� ���루�滻Ϊ�Լ�����������룩

	       //PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��,

	       //���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��

	       public static String myEmailAccount = "xiao2kun742@163.com";

	       public static String myEmailPassword = "304058615";

	       //����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ:smtp.xxx.com
	       //����163����� SMTP ��������ַΪ: smtp.163.com
	       public static String myEmailSMTPHost = "smtp.163.com";

	       // from xiang.wang@xsintech.com  zihang.cheng@xsintech.com
	       // to  user1@xinstech.com user2@xinstech.com
	       public boolean SendMail(String receiveMailAccount,String from,String to,String title) throws Exception {
	              //1. ������������, ���������ʼ��������Ĳ�������
	              Properties props = new Properties(); // ��������
	              props.setProperty("mail.transport.protocol","smtp"); // ʹ�õ�Э�飨JavaMail�淶Ҫ��
	              props.setProperty("mail.smtp.host",myEmailSMTPHost); // �����˵������ SMTP
	                                                                                                                //��������ַ
	              props.setProperty("mail.smtp.auth","true"); // ��Ҫ������֤
	              //2. �������ô����Ự����, ���ں��ʼ�����������
	              Session session = Session.getDefaultInstance(props);
	              session.setDebug(true);// ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
	              //  ����һ���ʼ�
	              MimeMessage message = new MimeMessage(session);
     //  From: ������
	              message.setFrom(new InternetAddress(myEmailAccount, "�Ŵ��������޹�˾","UTF-8"));
	              //  To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	              message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMailAccount, "�װ����û�","UTF-8"));
	              //  Subject: �ʼ�����
	              message.setSubject(title, "UTF-8");
	              //  Content: �ʼ����ģ�����ʹ��html��ǩ��
	              RandomCode=generateShortUuid();
	              this.setMessageContent(message,"",RandomCode);
	              message.setSentDate(new Date());
	              //  ��������
	              message.saveChanges();
	              //4. ���� Session ��ȡ�ʼ��������
          Transport transport = session.getTransport();
	              //5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
	              transport.connect(myEmailAccount,myEmailPassword);
	              //6. �����ʼ�, �������е��ռ���ַ,message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���,
	              //������, ������
	              transport.sendMessage(message,message.getAllRecipients());
	              //8. �ر�����
	              transport.close();
	              return true;
	       }
	       /*
	       @Description�����ɰ�λ��֤��
	       */
	       public static String generateShortUuid() { 
	           StringBuffer shortBuffer = new StringBuffer(); 
	           String uuid =UUID.randomUUID().toString().replace("-", ""); 
	           for (int i = 0; i < 8; i++) { 
	               String str = uuid.substring(i * 4, i *4 + 4); 
	               int x = Integer.parseInt(str, 16); 
	               shortBuffer.append(chars[x %0x3E]); 
	           } 
	           return shortBuffer.toString(); 
	       }
	       /*
	       @����ʼ�������������
	       */
	       public void setMessageContent(Message message, String ContentType,String RandomCode)throws MessagingException {
	              String Content="�𾴵��û������ã�������֤���ǣ� "+RandomCode;
	              MimeMultipart mmt = new MimeMultipart();
	              MimeBodyPart mbp = new MimeBodyPart();
	              if(ContentType == null || ContentType.equals("")) // ContentTypeΪ�������ͣ���GBK��
	                     mbp.setText(Content);// ��JavaMail����������
	              else
	                     mbp.setContent(Content,ContentType); // ָ�������ʽ
	              mmt.addBodyPart(mbp);
	              message.setContent(mmt);
	       }

	}

	