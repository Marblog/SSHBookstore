package cn.itcast.bookStore.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bookStore.domain.Notice;
import cn.itcast.bookStore.service.NoticeService;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice>{
	private NoticeService noticeService;

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	Notice bean=new Notice();
	
	public Notice getModel(){
	return bean;
	}
	public String addNotice() throws Exception{
		noticeService.addNotice(bean);
		return "success";
	}
	private String id;

	public void setId(String id) {
		this.id = id;
	}
	public String delNotice() throws Exception{
		noticeService.deleteNotice(this.id);
		return "success";
	}
	public String listNotice() throws Exception{
		List<Notice> notices=noticeService.getAllNotices();
		ServletActionContext.getRequest().setAttribute("notices",notices);
		return "success";
		
	}
	public String findNoticeById() throws Exception{
		Notice notice=noticeService.findNoticeById(id);
		ServletActionContext.getRequest().setAttribute("n", notice);
		return "success";
	}
	public String editNotice() throws Exception{
		System.out.println(bean);
		noticeService.updateNotice(bean);
		return "success";
	}
}
