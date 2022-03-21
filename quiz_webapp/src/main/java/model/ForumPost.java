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
public class ForumPost implements Serializable {
    private int id;
    private int userId;
    private Date createdDate;
    private String title;
    private String text;
}
