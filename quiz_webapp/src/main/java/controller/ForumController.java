package controller;

import DAO.ForumDAO;
import DAO.ForumDAOImpl;
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

        String type = req.getParameter("type");

        switch (type){
            case "create" -> {
                HttpSession session = req.getSession();

                ForumComment forumComment = new ForumComment();
                forumComment.setPostId(currentForumPost.getId());
                forumComment.setCreatedDate(new Date(System.currentTimeMillis()));
                forumComment.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
                forumComment.setText(req.getParameter("comment"));

                System.out.println(forumComment);

                forumDAO.createNewComment(forumComment);
            }
            case "delete" -> {
                HttpSession session = req.getSession();

                ForumComment forumComment = new ForumComment();

                forumComment.setId(Integer.parseInt(req.getParameter("commentId")));
                forumComment.setPostId(currentForumPost.getId());
                forumComment.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));

                forumDAO.deleteComment(forumComment);

                req.getParameter("commentId");
            }
            case "modify" -> {
                HttpSession session = req.getSession();

                ForumComment forumComment = new ForumComment();

                forumComment.setId(Integer.parseInt(req.getParameter("commentId")));
                forumComment.setPostId(currentForumPost.getId());
                forumComment.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
                forumComment.setText(req.getParameter("newComment"));
                forumComment.setCreatedDate(new Date(System.currentTimeMillis()));

                forumDAO.modifyComment(forumComment);
            }
            case "createPost" -> {
                ForumPost forumPost = new ForumPost();

                HttpSession session = req.getSession();

                forumPost.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
                forumPost.setTitle(req.getParameter("postTitle"));
                forumPost.setText(req.getParameter("postText"));
                forumPost.setCreatedDate(new Date(System.currentTimeMillis()));

                forumDAO.createNewPost(forumPost);
            }
            case "deletePost" -> {
                HttpSession session = req.getSession();

                ForumPost forumPost = new ForumPost();

                forumPost.setId(Integer.parseInt(req.getParameter("postId")));
                forumPost.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));

                forumDAO.deletePost(forumPost);
            }
            case "modifyPost" -> {
                HttpSession session = req.getSession();

                ForumPost forumPost = new ForumPost();

                forumPost.setId(Integer.parseInt(req.getParameter("postId")));
                forumPost.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
                forumPost.setTitle(req.getParameter("postTitle"));
                forumPost.setText(req.getParameter("postText"));

                forumDAO.modifyPost(forumPost);
            }
        }


        json.put("success", "yes");
        out.write(json.toString());
    }
}
