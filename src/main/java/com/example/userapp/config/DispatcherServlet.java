package com.example.userapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//FrontController
@WebServlet("*.do") //  /*은 모든요청을 받아서 무한반복된다..?
public class DispatcherServlet extends HttpServlet {

    // 아이피포트/user.do?cmd=join request.getparameter로 받음
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=utf-8"); //페이지의 한글깨짐을 고쳐줌


        //1. 공통로직
        System.out.println("common logic~~~~~~");

        //2. 분기
        String uri = req.getRequestURI(); //포트번호뒤에있는걸 파싱해줌 /user.do
        System.out.println(uri);

        if(uri.equals("/join-form.do")){
            resp.sendRedirect("/user/join-form.jsp");
        }
        else if(uri.equals("/join.do")){
            resp.sendRedirect("/user/joinjsp");
        }
        else if(uri.equals("/main.do")){
            resp.sendRedirect("/user/main.jsp");
        }
        else{
            resp.setStatus(404);
            resp.getWriter().println("잘못된 페이지를 요청하셨습니다");
        }
    }
}
