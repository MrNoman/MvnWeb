package servlet;

import main.log.LoggerInitializer;
import main.service.HelloService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(HelloServlet.class.getPackage().getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoggerInitializer.getInstance();
        PrintWriter out = resp.getWriter();
        BufferedReader input = req.getReader();
        String postReq = input.readLine();
        log.log(Level.WARNING, "Incomming POST-request with: request = '" + postReq+"'");
        input.close();

        if (postReq.trim().isEmpty()){
            HelloService.getInstance().getStartPageContext();
        } else {
            HelloService.getInstance().saveToStorage(postReq);
            String response = HelloService.getInstance().getReturnString();
            log.log(Level.WARNING, "Outcomming POST-response with: response = '" + response + "'");
            out.println(response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       LoggerInitializer.getInstance();
       PrintWriter out = resp.getWriter();
       log.log(Level.WARNING, "Incomming GET-request.");
       String outputString = HelloService.getInstance().getStartPageContext();
       out.println(outputString.isEmpty() ? "Hello world!" : outputString);
       out.println("GET-method is not allowed");
       log.log(Level.WARNING, "Start-page returned by GET-request");
    }
}
