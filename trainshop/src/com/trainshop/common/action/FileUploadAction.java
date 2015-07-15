package com.trainshop.common.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.trainshop.common.ftp.BusinessType;
import com.trainshop.common.ftp.FtpUtil;

/***
 * 文件上传控制类
 * 
 * @author
 * 
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadAction{

	// 通过Spring的autowired注解获取spring默认配置的request
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String addUser() {
		return "Demo/fileUpload";
	}

	@ResponseBody
	@RequestMapping(value = "files", method = RequestMethod.POST, produces = { "text/html;charset=UTF-8" })
	public String filesUpload(@RequestParam("files") MultipartFile[] files,
			HttpServletRequest request, HttpSession session) {
		
		int businessType = new Integer(request.getParameter("businessType"));
		String businessId = request.getParameter("businessId");
		
		String fileName = request.getParameter("fileName");
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (MultipartFile file : files) {
				if (file.isEmpty()) {
					
				} else {
					try {
						String filePath = "/" + BusinessType.getString(BusinessType.parse(businessType));

						//fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
						String saveFileName = System.currentTimeMillis() + "_"
								+ new String(fileName.getBytes("UTF-8"),"iso-8859-1");
						FtpUtil.uploadFile(filePath, saveFileName,
								file.getInputStream());

						StringBuffer inputXml = new StringBuffer();
						inputXml.append("<?xml version=\"1.0\" ?>"
								+ "<DATA><item>");
						inputXml.append("<GUID></GUID>");
						inputXml.append("<FILTYP>" + file.getContentType()
								+ "</FILTYP>");
						inputXml.append("<FILSIZ>" + file.getSize()
								+ "</FILSIZ>");
						inputXml.append("<S_FILENAME>"
								+ fileName + "</S_FILENAME>");
						inputXml.append("<FILENAME>" + saveFileName
								+ "</FILENAME>");
						inputXml.append("<PTHNAM>" + filePath + "/"
								+ saveFileName + "</PTHNAM>");
						inputXml.append("<VOART>" + businessType + "</VOART>");
						inputXml.append("<DOCNM>" + businessId + "</DOCNM>");
						inputXml.append("</item></DATA>");

						String result = super.exec("fileUploadService",
								"saveFile", inputXml.toString(), session);
						return result;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "fileList", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String getFileListByBusiness(HttpServletRequest request,
			HttpSession session) {
		String result = "";

		int businessType = new Integer(request.getParameter("businessType"));
		String businessId = request.getParameter("businessId");

		StringBuffer inputXml = new StringBuffer();
		inputXml.append("<?xml version=\"1.0\" ?>" + "<DATA>");
		inputXml.append("<VOART>" + businessType + "</VOART>");
		inputXml.append("<DOCNM>" + businessId + "</DOCNM>");
		inputXml.append("</DATA>");

		result = super.exec("fileUploadService", "readFile",
				inputXml.toString(), session);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "deleteFile", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String deleteFileListByBusiness(HttpServletRequest request,
			HttpSession session) {
		String result = "";

		String docNM = request.getParameter("docNM");

		StringBuffer inputXml = new StringBuffer();
		inputXml.append("<?xml version=\"1.0\" ?>" + "<DATA><item>");
		inputXml.append("<SIGN>I</SIGN><OPTION>EQ</OPTION><LOW>" + docNM + "</LOW><HIGH/>");
		inputXml.append("</item></DATA>");

		result = super.exec("fileUploadService", "deleteFile",
				inputXml.toString(), session);
		return result;
	}

	@ResponseBody
	@RequestMapping("/download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String fileName = URLDecoder.decode(
				new String(request.getParameter("fileName").getBytes(
						"iso8859-1"), "UTF-8"), "UTF-8");
		String fileLength = request.getParameter("fileLength");

		FTPClient ftpClient = null;

		try {
			response.setContentType("application/x-download; charset=UTF-8");
			response.setHeader("Content-disposition", "attachment; filename="
					+ URLEncoder.encode(URLDecoder.decode(request.getParameter("s_fileName"), "UTF-8"), "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(fileLength));

			ftpClient = FtpUtil.login(FtpConfigBean.getFtpBeanList().get(0));

			bis = new BufferedInputStream(FtpUtil.downFile(ftpClient, fileName));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}

			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	/***
	 * 保存文件
	 * 
	 * @param file
	 * @return
	 */
	private boolean saveFile(MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {

				// 文件保存路径
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "upload/" + file.getOriginalFilename();
				// 转存文件
				file.transferTo(new File(filePath));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/***
	 * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "file", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 文件保存路径
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "upload/" + file.getOriginalFilename();
				// 转存文件
				file.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 重定向
		return "redirect:/list.html";
	}
}
