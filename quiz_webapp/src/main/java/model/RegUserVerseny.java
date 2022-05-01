package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

public class RegUserVerseny implements Serializable {
    private int regID;
    private int userID;
    private int versenyID;
}
