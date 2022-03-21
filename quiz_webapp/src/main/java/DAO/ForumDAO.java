package DAO;

import model.ForumComment;
import model.ForumPost;

import java.util.List;

public interface ForumDAO {
    List<ForumPost> findAllForumPost();

    List<ForumComment> findAllForumComment();
}
