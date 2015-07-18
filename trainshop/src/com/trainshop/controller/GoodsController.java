package com.trainshop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.trainshop.common.util.JsonPluginsUtil;
import com.trainshop.model.Goods;
import com.trainshop.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	@Resource(name = "goodsService")
	private IGoodsService goodsService;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/goods/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public String publish(HttpServletRequest request, HttpSession session) {
		try {
			return "shop/goods/publish";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
	}

	@ResponseBody
	@RequestMapping(value = "goodsCount", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String goodssCount() {

		int count = goodsService.findAll().size();

		return super.returnData(count);
	}

	/**
	 * 获取商品列表
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getlist", method = RequestMethod.GET, produces = { "text/json;charset=UTF-8" })
	public String getlist(HttpServletRequest request, HttpSession session) {
		String result = null;

		List<Goods> list = goodsService.findAll();

		result = JsonPluginsUtil.beanListToJson(list);

		return super.returnData(result);
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String create(HttpServletRequest request, HttpSession session) {
		String result = "";
		String data = request.getParameter("data");
		Goods entity = JsonPluginsUtil.jsonToBean(data, Goods.class);

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> goodsThumb = multipartRequest.getFiles("goodsThumb");
		List<MultipartFile> goodsImg = multipartRequest.getFiles("goodsImg");
		List<MultipartFile> originalImg = multipartRequest.getFiles("originalImg");
		
		String path = request.getSession().getServletContext().getRealPath("upload");  

		if (goodsThumb != null && goodsThumb.size() > 0) {
			// 循环获取file数组中得文件
			for (MultipartFile file : goodsThumb) {
				if (file.isEmpty()) {
				} else {
					try {
						//拿到输出流，同时重命名上传的文件 
						String filePath = path + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
						entity.setGoodsThumb(filePath);
	                    FileOutputStream os = new FileOutputStream(filePath);  
	                    //拿到上传文件的输入流  
	                    FileInputStream in = (FileInputStream) file.getInputStream();  
	                      
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){  
	                        os.write(b);  
	                    }  
	                    os.flush();  
	                    os.close();  
	                    in.close();  
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if (goodsImg != null && goodsImg.size() > 0) {
			// 循环获取file数组中得文件
			for (MultipartFile file : goodsImg) {
				if (file.isEmpty()) {
				} else {
					try {
						//拿到输出流，同时重命名上传的文件 
						String filePath = path + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
						entity.setGoodsImg(filePath);
	                    FileOutputStream os = new FileOutputStream(filePath);  
	                    //拿到上传文件的输入流  
	                    FileInputStream in = (FileInputStream) file.getInputStream();  
	                      
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){  
	                        os.write(b);  
	                    }  
	                    os.flush();  
	                    os.close();  
	                    in.close();  
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if (originalImg != null && originalImg.size() > 0) {
			// 循环获取file数组中得文件
			for (MultipartFile file : originalImg) {
				if (file.isEmpty()) {
				} else {
					try {
						//拿到输出流，同时重命名上传的文件 
						String filePath = path + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
						entity.setOriginalImg(filePath);
	                    FileOutputStream os = new FileOutputStream(filePath);  
	                    //拿到上传文件的输入流  
	                    FileInputStream in = (FileInputStream) file.getInputStream();  
	                      
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){  
	                        os.write(b);  
	                    }  
	                    os.flush();  
	                    os.close();  
	                    in.close();  
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		entity.setIsDelete(0);
		goodsService.create(entity);

		return super.returnData(result);
	}

	@RequestMapping(value = { "/saveOrUpdate" }, method = RequestMethod.POST)
	public String saveOrUpdate(@RequestParam("photo") MultipartFile file,
			HttpServletRequest request) throws IOException {
		if (!file.isEmpty()) {
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/upload"); // 设定文件保存的目录

			String filename = file.getOriginalFilename(); // 得到上传时的文件名
			// FileUtils.writeByteArrayToFile(new File(dir,filename),
			// file.getBytes());

			// p.setPhotoPath("/upload" + filename); //设置图片所在路径

			System.out.println("upload over. " + filename);
		}
		// ps.saveOrUpdate(p);
		return "redirect:/person/list.action"; // 重定向
	}
	
	/**
	 * 删除商品
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteGood", method = RequestMethod.POST, produces = { "text/json;charset=UTF-8" })
	public String deleteGood(HttpServletRequest request, HttpSession session) {
		String result = "";
		
		String id = request.getParameter("id");
		
		goodsService.deleteById(Long.parseLong(id));

		return super.returnSucess(result);
	}
}
