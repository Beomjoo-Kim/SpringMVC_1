package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //jsp 파일이 WEB-INF 내에 있다면, 외부에서 직접 jsp 를 호출하지 못한다.(url 에 해당 파일의 경로를 입력하는 방식으로 호출 불가)
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //이동할 위치 지정.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //이동한다. 서버 내부에서 다시 호출이 발생한다.
        //redirect 가 아니라 서버 내부에서 해당하는 path 를 호출하는 것.
        //redirect 는 한번 client 에 이동한 후 url 이 변경된 것으로 다시 호출한다. 이 경우 client 에서 해당 동작을 확인할 수 있다.
        //forward 의 경우엔 서버 내부에서 호출이 일어나기 때문에 client 를 거치지 않아 client 에서 해당 동작을 확인할 수 없다.
        dispatcher.forward(request, response);
    }
}
