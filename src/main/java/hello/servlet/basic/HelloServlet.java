package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //intellij shortcut -> ctrl+o
    //service 중 접근제한자가 protected 인 것을 생성해야 한다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet 이 호출되면 해당 service method 가 실행된다.

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //query parameter 의 값을 가져온다
        String userName = request.getParameter("username");
        System.out.println("userName = " + userName);

        //header
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //content
        response.getWriter().write("hello " + userName);

        //HTTP 요청에는 임시 저장소 기능이 포함되어있다.
//        request.setAttribute("name", "value");
        //세션관리 기능 또한 존재한다.
//        request.getSession();
    }
}
