package com.neusoft.tulingservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.until.TuLintUntil;

/**
 * Servlet implementation class TuLingServlet
 */
@WebServlet("/TuLingServlet")
public class TuLingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理字符集乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取请求参数
		String message=request.getParameter("message");
		//实例化图灵工具
		TuLintUntil until=new TuLintUntil();
		//获取图灵答复结果
		String result=until.getResult(message);
		//将响应结果传给客户端（页面）
		PrintWriter writer=response.getWriter();
		writer.write(result);
		writer.flush();
		writer.close();
	}

}
