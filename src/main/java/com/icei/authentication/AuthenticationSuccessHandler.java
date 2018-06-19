package com.icei.authentication;

/**
 * 认证成功处理器
 * @author:LordMasterKing
 * @date:2018年4月26日
 */
/*@Component*/
public class AuthenticationSuccessHandler {
/*	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("登录成功！！！！");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername() + "-" + user.getPassword() + "-" + user.getRole().getFlag());
		request.getSession().setAttribute("user", user);
		response.sendRedirect("hello");
	}
*/
}
