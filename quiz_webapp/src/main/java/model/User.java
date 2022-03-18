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
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private Date birthdate;
    private UserLevel userLevel;
}
