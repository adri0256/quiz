package DAO;

import config.DatabaseConnection;
import model.ForumComment;
import model.ForumPost;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ForumDAOImpl implements ForumDAO{
    private Connection con;

    private final static String selectAllForumPost = "SELECT * FROM forum_post";
    private final static String selectAllForumComment = "SELECT * FROM forum_comment";

    public ForumDAOImpl() { this.con = DatabaseConnection.getConnection(); }

    @Override
    public List<ForumPost> findAllForumPost() {
        List<ForumPost> allForumPost = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllForumPost);

            while (rs.next()) {
                ForumPost fp = new ForumPost();

                fp.setId(rs.getInt("id"));
                fp.setUserId(rs.getInt("user_id"));
                fp.setCreatedDate(rs.getDate("created_date"));
                fp.setTitle(rs.getString("title"));
                fp.setText(rs.getString("text"));

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

            ResultSet rs = stmt.executeQuery(selectAllForumComment);

            while (rs.next()) {
                ForumComment fc = new ForumComment();

                fc.setId(rs.getInt("id"));
                fc.setUserId(rs.getInt("user_id"));
                fc.setPostId(rs.getInt("post_id"));
                fc.setCreatedDate(rs.getDate("created_date"));
                fc.setText(rs.getString("text"));

                allForumComment.add(fc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allForumComment;
    }
}
