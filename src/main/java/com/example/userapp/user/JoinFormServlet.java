package com.example.userapp.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/join-Form")
public class JoinFormServlet extends HttpServlet { //프로토콜을 알기 위해서


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime now = LocalDateTime.now();

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" ; //+지우고 세미콜론쓰기

                for (int i = 0; i < 5; i++) {
                    html=html+"    <h1>"+i+"회원가입 페이지"+now+"</h1>\n" ;  //html사이에 자바(for문) 쓰는 법 순수html문으로는 쓸 수 없음

                }

                html = html+"    <hr>\n" +
                "    <form action=\"/join\" method=\"post\">\n" +
                "        <input type=\"text\" placeholder=\"username\" name=\"username\">\n" +
                "        <input type=\"text\" placeholder=\"password\" name=\"password\">\n" +
                "        <input type=\"text\" placeholder=\"email\" name=\"email\">\n" +
                "        <button>회원가입</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        resp.getWriter().println(html);

    }
}
