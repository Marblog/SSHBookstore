package cn.itcast.bookStore.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bookStore.domain.Products;
import cn.itcast.bookStore.service.ProductService;
import cn.itcast.bookStore.utils.IdUtils;

public class ProductsAction extends ActionSupport implements ModelDriven<Products>{
	private ProductService pservice;

	public void setPservice(ProductService pservice) {
		this.pservice = pservice;
	}
	private Products p=new Products();
	@Override
	public Products getModel() {
		// TODO Auto-generated method stub
		return p;
	}
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String addProducts() throws Exception{
		p.setId(IdUtils.getUUID());
		if(upload!=null){
			InputStream is=new FileInputStream(upload);
			String uploadPath=ServletActionContext.getServletContext().getRealPath("/temp");
			File toFile=new File(uploadPath,this.getUploadFileName());
			OutputStream os=new FileOutputStream(toFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while(-1!=(length=is.read(buffer,0,buffer.length))){
				os.write(buffer);
			}
			is.close();
			os.close();
			p.setImgurl("/temp/"+this.getUploadFileName());
		}else{
			p.setImgurl(null);
		}
		pservice.addProduct(p);
		return "success";
	}
	public String delproducts() throws Exception{
		String id=p.getId();
		pservice.deleteProduct(id);
		return "success";
	}
	public String editProducts() throws Exception{
		System.out.println("upload="+upload);
		if(upload!=null){
			String imgurl=pservice.findProductById(p.getId()).getImgurl();
			int indexStart=imgurl.lastIndexOf("/");
			String imagename=imgurl.substring(indexStart+1);
			System.out.println(imagename);
			System.out.println("uploadFileName="+uploadFileName);
			if(!uploadFileName.equals(imagename)){
				InputStream is=new FileInputStream(upload);
				System.out.println("inputStream="+is);
				String uploadPath=ServletActionContext.getServletContext().getRealPath("/temp");
				File toFile=new File(uploadPath,this.getUploadFileName());
				OutputStream os=new FileOutputStream(toFile);
				byte[] buffer=new byte[1024];
				int length=0;
				while(-1!=(length=is.read(buffer,0,buffer.length))){
					os.write(buffer);
				}
				is.close();
				os.close();
				p.setImgurl("/temp/"+this.getUploadFileName());
			}
			else{
				p.setImgurl(pservice.findProductById(p.getId()).getImgurl());
			}
			pservice.editProduct(p);
			return "success";
		}
		return "success";
	
	}
	
	private String minprice;
	private String maxprice;

	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}
	public String findProductByManyConditions() throws Exception{
		List<Products> ps=pservice.findProductByManyCondition(p.getId(), p.getName(), p.getCategory(), minprice, maxprice);
		ServletActionContext.getRequest().setAttribute("ps", ps);
		return "success";
	}
	public String listProducts() throws Exception{
		List<Products> ps=pservice.listAll();
		ServletActionContext.getRequest().setAttribute("ps",ps);
		return "success";
		
	}
	public String findProductsById() throws Exception{
		System.out.println(p.getId());
		String id=p.getId();
		Products product =pservice.findProductById(id);
		ServletActionContext.getRequest().setAttribute("p",product);
		return "success";
	}

}
