package controller;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import config.PasswordUtils;
import model.User;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/UsersController")
public class UsersController extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    public UsersController() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userDAO.findAllUsers();

        req.setAttribute("users", allUsers);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();

        String type = req.getParameter("type");

        System.out.println("Login or Reg: " + type);

        if (type.equals("Login")){
            System.out.println("Start of Login section");

            User byEmail = userDAO.findUser(req.getParameter("loginEmail"));

            boolean success = PasswordUtils.verifyUserPassword(req.getParameter("loginPwd"),byEmail.getPassword(), byEmail.getSalt());

            System.out.println("ret user: " + byEmail);

            if(success){
                json.put("loginSuccess", "yes");

                HttpSession session = req.getSession();
                session.setAttribute("loggedIn", true);
                session.setAttribute("userId", byEmail.getId());
                session.setAttribute("userEmail", byEmail.getEmail());
            } else {
                json.put("loginSuccess", "no");
            }

        } else if (type.equals("Registration")) {
            System.out.println("Start of Reg section");
            User user = new User();

            user.setUsername(req.getParameter("regUsname"));
            user.setEmail(req.getParameter("regEmail"));

            String salt = PasswordUtils.getSalt(30);

            user.setPassword(PasswordUtils.generateSecurePassword(req.getParameter("regPwd"), salt));
            user.setSalt(salt);
            user.setBirthdate(Date.valueOf(req.getParameter("regBirthDate")));

            System.out.println("sent user: " + user);

            int ret = userDAO.register(user);

            System.out.println("affected rows: " + ret);

            if(ret == 0){
                json.put("regSuccess", "no");
            } else if (ret == 1) {
                json.put("regSuccess", "yes");
            }
        } else if (type.equals("Logout")){
            HttpSession session = req.getSession();
            session.invalidate();
            json.put("logoutSuccess", true);
        }

        out.write(json.toString());
    }
}
