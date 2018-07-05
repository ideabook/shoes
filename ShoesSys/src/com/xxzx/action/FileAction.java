package com.xxzx.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Fileinfo;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.FileuploadService;

public class FileAction extends ActionSupport implements ModelDriven<Fileinfo> {

	/**
	 * 
	 */
	private Fileinfo fileinfo = new Fileinfo();
	private static final long serialVersionUID = 1L;
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	private List<String> dataUrl;
	private FileuploadService fileuploadService;
	private String cid;
	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(List<String> dataUrl) {
		this.dataUrl = dataUrl;
	}

	@Override
	public Fileinfo getModel() {
		// TODO Auto-generated method stub
		return fileinfo;
	}
	public String toadd(){
		cid=(String)ServletActionContext.getRequest().getParameter(
				"cid");
		ActionContext.getContext().getValueStack().set("cid", cid);
		
		return "toadd";
	}
	public String upload() {
		cid=(String)ServletActionContext.getRequest().getParameter(
				"cid");
		//System.out.println("cid2="+cid);

		dataUrl = new ArrayList<String>();
		List<String> filenames=new ArrayList<String>();
		String path2 = ServletActionContext.getServletContext()
				.getRealPath("/");
		System.out.println("filepath:---" + path2);
		String imgpath = "upload/";
		System.out.println("file size="+file.size());
		if (file != null && file.size() > 0) {
			for (int i = 0; i < file.size(); ++i) {
				InputStream is = null;
				try {
					is = new FileInputStream(file.get(i));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String path = ServletActionContext.getServletContext()
						.getRealPath("/");
				System.out.println("filepath:---" + path);
				// String root = "D:\\";
				 String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			        String[] s=this.getFileFileName().get(i).split("\\.");
			        str=s[0]+"-"+str+"."+s[1];
			        System.out.println(str);
			    filenames.add(str);
				dataUrl.add(imgpath + str);
				File destFile = new File(path + imgpath, str);
				System.out.println("destFile="+destFile);
				
				OutputStream os = null;

				try {
					os = new FileOutputStream(destFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				byte[] buffer = new byte[400];

				int length = 0;

				try {
					while ((length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					is.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		for(int i=0;i<dataUrl.size();i++){
			System.out.println("dataUrl="+dataUrl.get(i));
			fileinfo.setFilename(filenames.get(i));
			fileinfo.setFilepath(dataUrl.get(i));
			//fileinfo.setCid(cid);
			fileinfo.setFileuptime(new Date());
			fileuploadService.saveFileinfo(fileinfo); 
		}
		return "ok";
	}

	public FileuploadService getFileuploadService() {
		return fileuploadService;
	}

	public void setFileuploadService(FileuploadService fileuploadService) {
		this.fileuploadService = fileuploadService;
	}

}
