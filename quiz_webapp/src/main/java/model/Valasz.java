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

public class Valasz implements Serializable{
    private int id;
    private int kerdesID;
    private String valaszName;
}
