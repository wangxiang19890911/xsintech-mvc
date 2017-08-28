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

	       //生成随机验证码

	       public static String[] chars = new String[] { "a", "b","c", "d", "e", "f", "g", "h", "i", "j","k", "l", "m", "n", "o","p", "q", "r", "s", 
	           "t", "u", "v", "w","x", "y", "z", "0", "1","2", "3", "4", "5", 
	           "6", "7", "8", "9","A", "B", "C", "D", "E","F", "G", "H", "I", 
	           "J", "K", "L", "M","N", "O", "P", "Q", "R","S", "T", "U", "V", 
	           "W", "X", "Y", "Z" }; 
	       //发件人的 邮箱 和 密码（替换为自己的邮箱和密码）

	       //PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,

	       //对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。

	       public static String myEmailAccount = "xiao2kun742@163.com";

	       public static String myEmailPassword = "304058615";

	       //发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为:smtp.xxx.com
	       //网易163邮箱的 SMTP 服务器地址为: smtp.163.com
	       public static String myEmailSMTPHost = "smtp.163.com";

	       // from xiang.wang@xsintech.com  zihang.cheng@xsintech.com
	       // to  user1@xinstech.com user2@xinstech.com
	       public boolean SendMail(String receiveMailAccount,String from,String to,String title) throws Exception {
	              //1. 创建参数配置, 用于连接邮件服务器的参数配置
	              Properties props = new Properties(); // 参数配置
	              props.setProperty("mail.transport.protocol","smtp"); // 使用的协议（JavaMail规范要求）
	              props.setProperty("mail.smtp.host",myEmailSMTPHost); // 发件人的邮箱的 SMTP
	                                                                                                                //服务器地址
	              props.setProperty("mail.smtp.auth","true"); // 需要请求认证
	              //2. 根据配置创建会话对象, 用于和邮件服务器交互
	              Session session = Session.getDefaultInstance(props);
	              session.setDebug(true);// 设置为debug模式, 可以查看详细的发送 log
	              //  创建一封邮件
	              MimeMessage message = new MimeMessage(session);
     //  From: 发件人
	              message.setFrom(new InternetAddress(myEmailAccount, "信达联创有限公司","UTF-8"));
	              //  To: 收件人（可以增加多个收件人、抄送、密送）
	              message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMailAccount, "亲爱的用户","UTF-8"));
	              //  Subject: 邮件主题
	              message.setSubject(title, "UTF-8");
	              //  Content: 邮件正文（可以使用html标签）
	              RandomCode=generateShortUuid();
	              this.setMessageContent(message,"",RandomCode);
	              message.setSentDate(new Date());
	              //  保存设置
	              message.saveChanges();
	              //4. 根据 Session 获取邮件传输对象
          Transport transport = session.getTransport();
	              //5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
	              transport.connect(myEmailAccount,myEmailPassword);
	              //6. 发送邮件, 发到所有的收件地址,message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人,
	              //抄送人, 密送人
	              transport.sendMessage(message,message.getAllRecipients());
	              //8. 关闭连接
	              transport.close();
	              return true;
	       }
	       /*
	       @Description：生成八位验证码
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
	       @解决邮件正文乱码问题
	       */
	       public void setMessageContent(Message message, String ContentType,String RandomCode)throws MessagingException {
	              String Content="尊敬的用户，您好！您的验证码是： "+RandomCode;
	              MimeMultipart mmt = new MimeMultipart();
	              MimeBodyPart mbp = new MimeBodyPart();
	              if(ContentType == null || ContentType.equals("")) // ContentType为编码类型，如GBK等
	                     mbp.setText(Content);// 由JavaMail来决定编码
	              else
	                     mbp.setContent(Content,ContentType); // 指定编码格式
	              mmt.addBodyPart(mbp);
	              message.setContent(mmt);
	       }

	}

	