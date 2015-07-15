package com.trainshop.common.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FtpUtil {
	//private static FTPClient ftpClient = new FTPClient();
	private static String encoding = System.getProperty("file.encoding");
	
	private static Logger logger = Logger.getLogger(FtpUtil.class);
	
	/**
	 * 登录FTP服务器
	 * 
	 * @param ftpConfigBean
	 * @return
	 */
	public static FTPClient login(FtpConfigBean ftpConfigBean) {
		FTPClient ftpClient = new FTPClient();
		try {
			
			logger.info("登录" + ftpConfigBean.getHostIp() + "FTP服务器");
			// server：FTP服务器的IP地址；port: FTP端口号; user:登录FTP服务器的用户名
			// password：登录FTP服务器的用户名的口令；path：FTP服务器上的路径
			ftpClient.connect(ftpConfigBean.getHostIp(),
					Integer.parseInt(ftpConfigBean.getPort()));
			// ftpClient.connect(ftpConfigBean.getHostIp());
			ftpClient.login(ftpConfigBean.getUserName(),
					ftpConfigBean.getPassword());
			ftpClient.setDataTimeout(ftpConfigBean.getTimeout());
			// 使用二进制上传或下载文件
			ftpClient.setControlEncoding(ftpConfigBean.getEncode());
			// 主动模式
			if (ftpConfigBean.getEnterLocalMode() != null
					&& ftpConfigBean.getEnterLocalMode().equals("0")) {
				ftpClient.enterLocalActiveMode();
			}
			// 被动模式
			else {
				ftpClient.enterLocalPassiveMode();
			}
			FTPClientConfig conf = new FTPClientConfig(
					ftpConfigBean.getFtpClientConfig());
			conf.setServerLanguageCode(ftpConfigBean.getLanguageCode());
		} catch (Exception ex) {
			//logger.error("登录" + ftpConfigBean.getHostIp() + "FTP服务器失败", ex);
			ftpClient = null;
		}
		return ftpClient;
	}

	/**
	 * Description: 向FTP服务器上传文件
	 * 
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录,如果是根目录则为“/”
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            本地文件输入流
	 * @return 成功返回true，否则返回false
	 */
	public static boolean uploadFile(String path, String filename, InputStream input) {
		boolean result = false;
		FTPClient ftpClient = login(FtpConfigBean.getFtpBeanList().get(0));
		try {
			int reply;
			
			// 检验是否连接成功
			reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				return result;
			}
			
//			if(ftpClient.){
//				
//			}
			ftpClient.makeDirectory(path);

			// 转移工作目录至指定目录下
			boolean change = ftpClient.changeWorkingDirectory(path);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			if (change) {
				result = ftpClient.storeFile(filename,
						input);
				if (result) {
				}
			}
			input.close();
			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ftpClient != null){
				if (ftpClient.isConnected()) {
					try {
						ftpClient.disconnect();
					} catch (IOException ioe) {
					}
				}
			}
		}
		return result;
	}

	/**
	 * Description: 从FTP服务器下载文件
	 * 
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static boolean downFile(FTPClient ftpClient, String remotePath, String fileName,
			String localPath) {
		boolean result = false;
		try {
			int reply;
			
			//login(FtpConfigBean.getFtpBeanList().get(0));
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return result;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath
					.getBytes(encoding), "iso-8859-1"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
			
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if (ftpClient.isConnected()) {
//				try {
//					ftpClient.disconnect();
//				} catch (IOException ioe) {
//				}
//			}
		}
		return result;
	}
	
	/**
	 * Description: 从FTP服务器下载文件
	 * 
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static InputStream downFile(FTPClient ftpClient, String fileName) {
		InputStream input = null;
		try {
			int reply;
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return input;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(fileName
					.getBytes(encoding), "iso-8859-1"));
			
			input = ftpClient.retrieveFileStream(fileName);   
			
			/*// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
				}*/
				
			//}

			//return input;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if (ftpClient.isConnected()) {
//				try {
//					ftpClient.disconnect();
//				} catch (IOException ioe) {
//				}
//			}
		}
		return input;
	}
	
	/**
	 * 关闭FTP服务器
	 * 
	 * @param ftpClient
	 * @return
	 */
	public static void closeServer(FTPClient ftpClient) {
		try {
			if (ftpClient != null) {
				ftpClient.logout();
				ftpClient.disconnect();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 将本地文件上传到FTP服务器上
	 * 
	 */
	public void testUpLoadFromDisk() {
		try {
			FileInputStream in = new FileInputStream(new File("E:/号码.txt"));
			boolean flag = uploadFile("/",
					"哈哈.txt", in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	}
}
