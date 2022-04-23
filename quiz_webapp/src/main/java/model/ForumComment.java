package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ForumComment implements Serializable {
    private int id;
    private int userId;
    private String userName;
    private int postId;
    private Date createdDate;
    private String text;
}
