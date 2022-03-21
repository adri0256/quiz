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
public class Temakor implements Serializable{
    private int id;
    private String name;
}
