package servlet;

import main.service.HelloService;
import main.storage.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(Storage.class.getPackage().getName());

    private void loggerInit(){
        try
        {
            LogManager.getLogManager().readConfiguration(Storage.class.getResourceAsStream("/logger.properties"));
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loggerInit();
        PrintWriter out = resp.getWriter();
        BufferedReader input = req.getReader();
        String postReq = input.readLine();
        log.log(Level.INFO, "Incomming POST-request with: request = '" + input.readLine()+"'");
        input.close();
        HelloService.getInstance().saveToStorage(postReq);
        String response = HelloService.getInstance().getReturnString();
        log.log(Level.INFO, "Outcomming POST-response with: response = '" +response+"'"  );
        out.println(response);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       loggerInit();
       PrintWriter out = resp.getWriter();
       log.log(Level.INFO, "Incomming GET-request.");
       String outputString = HelloService.getInstance().getStartPageContext();
       out.println(outputString.isEmpty() ? "Hello world!" : outputString);
       out.println("GET-method is not allowed");
       log.log(Level.INFO, "Start-page returned by GET-request");

    }
}
