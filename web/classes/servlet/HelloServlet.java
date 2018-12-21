package servlet;

import main.service.HelloService;
import org.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        BufferedReader input = req.getReader();
        String postReq = input.readLine();
        input.close();

        HelloService.getInstance().save(postReq);
        out.println(HelloService.getInstance().getReturnString());
        //JSONObject postData = new JSONObject();

        //postData.put("name",req.getReader());
        //out.println(postData.get("name"));

        //HelloService.getInstance().save(postData);
        //out.println(HelloService.getInstance().getReturnString());


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // doPost(req,resp);
        PrintWriter out = resp.getWriter();
        out.println("GET-method is not allowed");
    }
}
