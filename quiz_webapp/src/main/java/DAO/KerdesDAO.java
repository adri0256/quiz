package DAO;

import model.Kerdes;
import model.Valasz;

import java.util.List;

public interface KerdesDAO {
    List<Kerdes> findAllKerdesek();
    List<Valasz> findAllValasz();
}