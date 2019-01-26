package cn.itcast.bookStore.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.bookStore.domain.User;
import cn.itcast.bookStore.service.UserService;

public class UserAction extends ActionSupport{
	private UserService  userservice;
	private String loginName;
	private String loginPwd;
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String login() throws Exception{
		User u=userservice.login(loginName, loginPwd);
		if(u!=null){
			String role=u.getRole();
			if("≥¨º∂”√ªß".equals(role)){
				ServletActionContext.getRequest().getSession().setAttribute("user",u);
				return super.execute();
			}
		}
		return "error";
	}
	public String loginout() throws Exception{
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return super.execute();
	}
	}

