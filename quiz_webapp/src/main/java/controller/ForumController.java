package controller;

import DAO.ForumDAO;
import DAO.ForumDAOImpl;
import model.ForumComment;
import model.ForumPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ForumController")
public class ForumController extends HttpServlet {
    ForumDAO forumDAO = new ForumDAOImpl();

    public ForumController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ForumPost> allForumPost = forumDAO.findAllForumPost();
        List<ForumComment> allForumComment = forumDAO.findAllForumComment();

        req.setAttribute("allPost", allForumPost);

        req.setAttribute("allComment", allForumComment);

    }
}
