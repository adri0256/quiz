package controller;

import DAO.ForumDAO;
import DAO.ForumDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.ForumComment;
import model.ForumPost;
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

@WebServlet("/ForumController")
public class ForumController extends HttpServlet {
    ForumDAO forumDAO = new ForumDAOImpl();

    public ForumPost currentForumPost;

    public ForumController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ForumPost> allForumPost = forumDAO.findAllForumPost();
        List<ForumComment> allForumComment = forumDAO.findAllForumComment();

        req.setAttribute("allPost", allForumPost);

        req.setAttribute("allComment", allForumComment);

        if(req.getParameterMap().containsKey("id")){
            System.out.println(req.getParameter("id"));
            System.out.println(forumDAO.findPostById(Integer.parseInt(req.getParameter("id"))));
            System.out.println(forumDAO.findCurrentPostsComments(Integer.parseInt(req.getParameter("id"))));

            currentForumPost = forumDAO.findPostById(Integer.parseInt(req.getParameter("id")));

            req.setAttribute("currentPost", currentForumPost);
            req.setAttribute("currentPostsComments",forumDAO.findCurrentPostsComments(Integer.parseInt(req.getParameter("id"))));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();

        String comment = req.getParameter("commentText");

        HttpSession session = req.getSession();

        ForumComment forumComment = new ForumComment();
        forumComment.setPostId(currentForumPost.getId());
        forumComment.setCreatedDate(new Date(System.currentTimeMillis()));
        forumComment.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
        forumComment.setText(comment);


        forumDAO.createNewComment(forumComment);

        json.put("success", "yes");

        out.write(json.toString());
    }
}
