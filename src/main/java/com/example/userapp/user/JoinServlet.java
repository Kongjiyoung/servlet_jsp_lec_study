package com.example.userapp.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/join")
public class JoinServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=utf-8"); //페이지의 한글깨짐을 고쳐줌
        //username=ssar&password=1234&email=ssar@nate.com

//        BufferedReader br =req.getReader();
//
//        String requestBody="";
//
//        while(true){
//            String line = br.readLine();
//
//            if (line == null) break;
//
//            requestBody = requestBody + line;
//        }
//        System.out.println(requestBody);
        //위 내용을 메서드를 톰캣이 지원해준다
        
        //1. 파싱
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println("username : "+username);
        System.out.println("password : "+password);
        System.out.println("email : "+email);
        
        //2. 유효성 검사(1000줄 됨)
        if(username.length()<3 || username.length() >10){
            resp.getWriter().println("<h1>username 글자수가 3~10 사이여야 합니다");
        }

        //3. DB 연결

        //4. DAO의 insert 메서드를 호출

        //5. 메인 페이지 그리기 //메인페이지 코드를 적게 되면 또 페이지 새로 생성하게 된다.(비효율적) -> mainservlet을 불러온다
//        String html = "<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//                "    <title>Document</title>\n" +
//                "</head>\n" +
//                "\n" +
//                "<body>\n" +
//                "    <h1>메인 페이지</h1>\n" +
//                "    <hr>\n" +
//                "</body>\n" +
//                "\n" +
//                "</html>";

        //6. 리다이렉트
        //resp.getWriter().println("/main");

        //위 메서드 표현
        resp.setStatus(302); //상태코드를 내가 설정하고 location을 지정 해줘서 main페이지로 넘어간다
        resp.setHeader("Location", "/main");
        resp.setHeader("clock", "12pm");
    }
}
