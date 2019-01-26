package cn.itcast.bookStore.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginFilter extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Object user=invocation.getInvocationContext().getSession().get("user");
		if(user==null){
			return "login";
		}else{
			return invocation.invoke();
		}
		
	}

}
