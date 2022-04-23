package DAO;

import model.ForumComment;
import model.ForumPost;

import java.util.List;

public interface ForumDAO {
    List<ForumPost> findAllForumPost();

    List<ForumComment> findAllForumComment();

    ForumPost findPostById(int id);

    List<ForumComment> findCurrentPostsComments(int postId);

    int createNewPost(ForumPost forumPost);
    int createNewComment(ForumComment forumComment);

    int modifyPost(ForumPost forumPost);
    int modifyComment(ForumComment forumComment);

    int deletePost(ForumPost forumPost);
    int deleteComment(ForumComment forumComment);
}
