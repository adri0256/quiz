package DAO;

import config.DatabaseConnection;
import model.ForumComment;
import model.ForumPost;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForumDAOImpl implements ForumDAO{
    private final Connection con;

    private final UserDAO userDAO = new UserDAOImpl();

    private final static String SELECT_FROM_FORUM_POST = "SELECT * FROM forum_post";
    private final static String SELECT_FROM_FORUM_COMMENT = "SELECT * FROM forum_comment";

    private final static String SELECT_FROM_FORUM_POST_BY_ID = "SELECT * FROM forum_post WHERE id = ?";

    private final static String SELECT_ALL_FORUM_COMMENT_WITH_POST_ID =
            "SELECT forum_comment.id, FORUM_COMMENT.user_id, FORUM_COMMENT.post_id, FORUM_COMMENT.created_date, FORUM_COMMENT.text " +
            "FROM forum_post, forum_comment " +
            "WHERE FORUM_COMMENT.POST_ID = FORUM_POST.ID AND FORUM_POST.ID = ?";

    private final static String INSERT_INTO_FORUM_POST = "INSERT INTO forum_post (user_id, created_date, title, text) VALUES(?, ?, ?, ?)";
    private final static String INSERT_INTO_FORUM_COMMENT = "INSERT INTO forum_comment (user_id, post_id, created_date, text) VALUES(?, ?, ?, ?)";
    private final static String UPDATE_FORUM_POST =
            "UPDATE forum_post " +
            "SET forum_post.title = ?, forum_post.text = ? " +
            "WHERE forum_post.id = ? AND forum_post.user_id = ( " +
                "SELECT MY_USERS.ID " +
                "FROM my_users " +
                "INNER JOIN forum_post ON forum_post.user_id = my_users.id " +
                "WHERE my_users.id = ?" +
            ")";

    private final static String updateForumComment =
            "UPDATE FORUM_COMMENT " +
            "SET text = ? " +
            "WHERE post_id = (" +
                "SELECT FORUM_POST.ID " +
                "FROM forum_post " +
                "INNER JOIN forum_comment on forum_comment.post_id = forum_post.id " +
                "WHERE forum_post.id = ? )" +
            "AND user_id = ( " +
                "SELECT MY_USERS.ID " +
                "FROM my_users " +
                "INNER JOIN forum_comment on forum_comment.user_id = my_users.id " +
                "WHERE my_users.id = ? " +
            ")";

    private final static String deleteForumPost =
            "DELETE ( " +
                "SELECT * " +
                "FROM forum_post " +
                "INNER JOIN MY_USERS ON forum_post.user_id = my_users.id " +
                "WHERE my_users.id = ? AND forum_post.id = ? " +
            ")";

    private final static String deleteForumComment =
            "DELETE ( " +
                "SELECT * " +
                "FROM forum_comment " +
                "INNER JOIN MY_USERS ON forum_comment.user_id = my_users.id " +
                "INNER JOIN forum_post ON forum_comment.post_id = forum_post.id " +
                "WHERE my_users.id = ? AND forum_post.id = ? AND forum_comment.id = ? " +
            ")";

    public ForumDAOImpl() { this.con = DatabaseConnection.getConnection(); }

    @Override
    public List<ForumPost> findAllForumPost() {
        List<ForumPost> allForumPost = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(SELECT_FROM_FORUM_POST);

            while (rs.next()) {
                ForumPost fp = new ForumPost();

                AddForumPostToRs(fp, rs);

                allForumPost.add(fp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allForumPost;
    }

    @Override
    public List<ForumComment> findAllForumComment() {
        List<ForumComment> allForumComment = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(SELECT_FROM_FORUM_COMMENT);

            addAllComments(allForumComment, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allForumComment;
    }

    @Override
    public ForumPost findPostById(int id) {
        ForumPost fp = new ForumPost();

        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_FROM_FORUM_POST_BY_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddForumPostToRs(fp, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fp;
    }

    @Override
    public List<ForumComment> findCurrentPostsComments(int postId) {
        List<ForumComment> forumComments = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_FORUM_COMMENT_WITH_POST_ID);

            stmt.setInt(1, postId);

            ResultSet rs = stmt.executeQuery();

            addAllComments(forumComments, rs);

        } catch (SQLException e){
            e.printStackTrace();
        }

        return forumComments;
    }

    @Override
    public int createNewPost(ForumPost forumPost) {
        int affectedRows = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_FORUM_POST);

            stmt.setInt(1, forumPost.getUserId());
            stmt.setDate(2, forumPost.getCreatedDate());
            stmt.setString(3, forumPost.getTitle());
            stmt.setString(4, forumPost.getText());

            affectedRows = stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return affectedRows;
    }

    @Override
    public int createNewComment(ForumComment forumComment) {
        int affectedRows = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_FORUM_COMMENT);

            stmt.setInt(1, forumComment.getUserId());
            stmt.setInt(2, forumComment.getPostId());
            stmt.setDate(3, forumComment.getCreatedDate());
            stmt.setString(4, forumComment.getText());

            affectedRows = stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return affectedRows;
    }

    @Override
    public int modifyPost(ForumPost forumPost) {
        int affectedRows = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(UPDATE_FORUM_POST);

            stmt.setString(1, forumPost.getTitle());
            stmt.setString(2, forumPost.getText());
            stmt.setInt(3, forumPost.getId());
            stmt.setInt(4, forumPost.getUserId());

            affectedRows = stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return affectedRows;
    }

    @Override
    public int modifyComment(ForumComment forumComment) {
        int affectedRows = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(updateForumComment);

            stmt.setString(1, forumComment.getText());
            stmt.setInt(2, forumComment.getPostId());
            stmt.setInt(3, forumComment.getUserId());

            affectedRows = stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return affectedRows;
    }

    @Override
    public int deletePost(ForumPost forumPost) {
        int row = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(deleteForumPost);

            stmt.setInt(1, forumPost.getUserId());
            stmt.setInt(2, forumPost.getId());

            row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public int deleteComment(ForumComment forumComment) {
        int row = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(deleteForumComment);

            stmt.setInt(1, forumComment.getUserId());
            stmt.setInt(2, forumComment.getPostId());
            stmt.setInt(3, forumComment.getId());

            row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    private void addAllComments(List<ForumComment> forumComments, ResultSet rs) throws SQLException {
        while (rs.next()) {
            ForumComment forumComment = new ForumComment();

            forumComment.setId(rs.getInt("id"));
            forumComment.setUserId(rs.getInt("user_id"));
            forumComment.setUserName(userDAO.findUserById(rs.getInt("user_id")).getUsername());
            forumComment.setPostId(rs.getInt("post_id"));
            forumComment.setCreatedDate(rs.getDate("created_date"));
            forumComment.setText(rs.getString("text"));

            forumComments.add(forumComment);
        }
    }

    private void AddForumPostToRs(ForumPost fp, ResultSet rs) throws SQLException {
        fp.setId(rs.getInt("id"));
        fp.setUserId(rs.getInt("user_id"));
        fp.setUserName(userDAO.findUserById(rs.getInt("user_id")).getUsername());
        fp.setCreatedDate(rs.getDate("created_date"));
        fp.setTitle(rs.getString("title"));
        fp.setText(rs.getString("text"));
    }
}
