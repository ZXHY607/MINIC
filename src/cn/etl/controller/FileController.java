package cn.etl.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.etl.settting.Constant;
import cn.etl.util.FileUtil;

@Controller
@RequestMapping("/file")
public class FileController {
	@Resource 
	private ServletContext servletContext;
	public final static String[] fileCate={"exercise",//链接
			"courseware",//下载
			"video"};//观看
	final String basePath = "courseFile/";
	private  final String manageView="/admin/manageFile.jsp",
			listView="/listFile.jsp";
	
	@RequestMapping("/list")
	public ModelAndView list(Integer cate,Integer cId, Integer uIndex, String view)
	{
		String servletPath=toServletPath(cate, cId, uIndex);
		return list(servletPath, view);
	}
	ModelAndView list(String servletPath, String view)
	{
		if(servletPath==null) return illeageAccess("参数错误");
		File file=new File(toRealPath(servletPath));
		if(!file.exists()) file.mkdirs();
		File[] files=file.listFiles();
		if(view==null) view=listView;
		ModelAndView mav=new ModelAndView(view);
		mav.addObject("files",files);	
		mav.addObject("servletPath",servletPath);
		mav.addObject("view", view);
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(String servletPath, String [] fileNames,
			HttpServletRequest request,String view)
	{
		if(!isLegal(request)) return new ModelAndView(Constant.LOGIN).
				addObject("notice","请登录");
		String msg="路径错误";
		if(!validate(servletPath)) return illeageAccess(msg);
		String filePath =toRealPath(servletPath);
		if(filePath==null) return illeageAccess("参数错误");
		File file=new File(filePath);
		for(String name:fileNames)
			new File(file,name).delete();
		return list(servletPath,view);
	}
	@RequestMapping("/upload")
	public ModelAndView upload(String servletPath,String view,
			HttpServletRequest request,MultipartFile file)
	{
		if(!isLegal(request)) return new ModelAndView(Constant.LOGIN).
				addObject("notice","请登录");
		String msg="路径错误";
		if(!validate(servletPath)) return illeageAccess(msg);
		File uploadFile=FileUtil.renameFile(new File(toRealPath(servletPath),file.getOriginalFilename()));
		try(BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(uploadFile));
		BufferedInputStream bis=new BufferedInputStream(file.getInputStream()))
		{
			byte[] b=new byte[8*1024];
			while(bis.read(b)>0)
			{
				bos.write(b);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return list(servletPath,view);
	}
	@RequestMapping(value="/download")
	public ModelAndView download(HttpServletResponse response,String servletPath,
			String fileName,
			HttpServletRequest request)
	{
		if(!isLegal(request)) return new ModelAndView(Constant.LOGIN).
				addObject("notice","请登录");
		String msg="路径错误";
		if(!validate(servletPath)) return illeageAccess(msg);
		File file=new File(toRealPath(servletPath),fileName);
		if(!file.exists()||file.isDirectory()) return illeageAccess("要下载的文件不存在");
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition","attachment;filename="+
		file.getName());
		try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			OutputStream os = response.getOutputStream();
			BufferedOutputStream bos=new BufferedOutputStream(os)) 
		{
			
			byte[] bytes=new byte[8*1024];
			int i;
			while((i=bis.read(bytes))>0)
			{
				bos.write(bytes, 0, i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return null;
	}
	
	
	private ModelAndView illeageAccess(String msg)
	{
		ModelAndView mav =new ModelAndView(Constant.RESULT);
		mav.addObject("msg",msg);
		return mav;
	}
	private boolean isLegal(HttpServletRequest request)
	{
		return true;
	}
	String toRealPath(String servletPath)
	{
		return (servletContext.getRealPath("/")+servletPath).replace('\\', '/');
	}
	String toServletPath(Integer cate,Integer cId, Integer uIndex)
	{
		if(null == cate || null == cId) return null;
		if(cate<0||cate>=fileCate.length) return null;
		return basePath+cId+"/"+uIndex+"/"+fileCate[cate];
	}
	boolean validate(String servletPath)
	{
		
		if(servletPath.length()<basePath.length()||
				basePath.compareTo(servletPath.substring(0,basePath.length()))!=0)
				return false;
		return true;
	}
	 
}
