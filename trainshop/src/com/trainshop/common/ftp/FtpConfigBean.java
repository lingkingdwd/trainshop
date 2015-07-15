/**
 * 
 */
package com.trainshop.common.ftp;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import com.trainshop.common.util.Dom4jXmlUtil;

/**
 * TODO:
 * FTP配置文件Java Bean;
 */
public class FtpConfigBean {
	///ftp服务器所在ip地址
	private String hostIp;
	//ftp服务器端口号
	private String port;
	//登录ftp帐号
	private String userName;
	//登录ftp帐号密码
	private String password;
	//编码
	private String encode;
	//ftpClientConfig ftp服务器的环境，在window下值是WINDOWS;在linux下则配置为UNIX
	private String ftpClientConfig;
	//语言编码
	private String languageCode;
	//定义主动，被动模式 0 本地主动模式 1 本地被动模式
	private String enterLocalMode;
	//文件内容字符集
	private String contentCharSet;

	//要登录到ftp相对路径
	private String dirPath;
	//连接超时时间
	private int timeout;
	//自动重连时间间隔(单位：这毫秒)
	private long reConnSleep;
	///本地日志保存目录
	private String logPath;
	//读写权限，0表示可读写（此权限不对服务器上文件作删除或修改操作）;1表示只读（此权限不对服务器上文件作任何操作
	private String permission;
	//FTP服务器子目录生成时间格式（如果没有则为空）
	private String subDir;
	
	private static Logger logger = Logger.getLogger(FtpConfigBean.class);
	/**
	 * 构造子
	 */
	public FtpConfigBean() {
		// TODO Auto-generated constructor stub
	}

	private static List<FtpConfigBean> ftpConfigBeanList = new ArrayList<FtpConfigBean>();
	
	private HashMap<String,String> flagMappingChannelHash = new HashMap<String,String>();
	/**
	 * 给FTP列表赋值
	 * @param ftpList
	 */
	public void setFtpConfigBeanList(List<FtpConfigBean> ftpConfigBeanList) {
		this.ftpConfigBeanList = ftpConfigBeanList;
	}
	/**
	 * 读取FTP列表
	 * @return
	 */
	public static synchronized List<FtpConfigBean> getFtpBeanList() {
		Iterator it = getFtpConfigDoc().selectNodes("/Root/config").iterator();
		while(it.hasNext()){
			Element element = (Element) it.next();
			FtpConfigBean ftpConfigBean = new FtpConfigBean();
			ftpConfigBean.setHostIp(element.element("hostIp").getTextTrim());
			ftpConfigBean.setPort(element.element("port").getTextTrim());
			ftpConfigBean.setUserName(element.element("userName").getTextTrim());
			ftpConfigBean.setPassword(element.element("password").getTextTrim());
			ftpConfigBean.setDirPath(element.element("dirPath").getTextTrim());
			ftpConfigBean.setTimeout(Integer.parseInt(element.element("timeout").getTextTrim()));
			ftpConfigBean.setReConnSleep(Integer.parseInt(element.element("reConnSleep").getTextTrim()));
			ftpConfigBean.setLogPath(element.element("logPath").getTextTrim());
			ftpConfigBean.setPermission(element.element("permission").getTextTrim());
			ftpConfigBean.setSubDir(element.element("subDir").getTextTrim());
			ftpConfigBean.setEncode(element.element("encode").getTextTrim());
			ftpConfigBean.setFtpClientConfig(element.element("ftpClientConfig").getTextTrim());
			ftpConfigBean.setLanguageCode(element.element("languageCode").getTextTrim());
			ftpConfigBean.setContentCharSet(element.element("contentCharSet").getTextTrim());
			
			Element flagMappingElement = element.element("flagMappingChannel");
			if(flagMappingElement!=null){
				Iterator mappingIt = flagMappingElement.elementIterator("mapping");
				HashMap<String,String> flagMappingChannelHash = new HashMap<String,String>();
				while(mappingIt!=null && mappingIt.hasNext()){
					Element mappingElement = (Element) mappingIt.next();
					String mapping = mappingElement.getTextTrim();
					//String mapping = mappingElement.element("mapping")==null?"":mappingElement.element("mapping").getTextTrim();
					if(mapping!=null && !mapping.equals("")){
						String[] temp = mapping.split(":");
						try{
							flagMappingChannelHash.put(temp[0], temp[1]);
						}
						catch(Exception e){
							//e.printStackTrace();
							logger.error(e);
						}
					}
				}
				ftpConfigBean.setFlagMappingChannelHash(flagMappingChannelHash);
			}
			
			
			ftpConfigBeanList.add(ftpConfigBean);
		}
		return ftpConfigBeanList;
	}
	/**
	 * 加载一个xml文件
	 * @return
	 */
	private static Document getFtpConfigDoc(){
		String[] s_xmlpath = new String[] {"config/ftpConfig.xml"};
		Document doc = null;
		InputStream in = FtpConfigBean.class.getClassLoader().getResourceAsStream(s_xmlpath[0]);
		if(in != null){
			doc = Dom4jXmlUtil.load(in);
		}
		return doc;	
	}
	
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public long getReConnSleep() {
		return reConnSleep;
	}
	public void setReConnSleep(long reConnSleep) {
		this.reConnSleep = reConnSleep;
	}
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getSubDir() {
		return subDir;
	}
	public void setSubDir(String subDir) {
		this.subDir = subDir;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public String getFtpClientConfig() {
		return ftpClientConfig;
	}
	public void setFtpClientConfig(String ftpClientConfig) {
		this.ftpClientConfig = ftpClientConfig;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	public String getEnterLocalMode() {
		return enterLocalMode;
	}
	public void setEnterLocalMode(String enterLocalMode) {
		this.enterLocalMode = enterLocalMode;
	}
	
	public HashMap<String, String> getFlagMappingChannelHash() {
		return flagMappingChannelHash;
	}
	public void setFlagMappingChannelHash(
			HashMap<String, String> flagMappingChannelHash) {
		this.flagMappingChannelHash = flagMappingChannelHash;
	}
	
	public String getContentCharSet() {
		return contentCharSet;
	}
	public void setContentCharSet(String contentCharSet) {
		this.contentCharSet = contentCharSet;
	}
}
