package DAO;

import model.Temakor;

import java.util.List;

public interface TemakorDAO {
    List<Temakor> findAllTemakor();
    Temakor findTemakorViaID(int id);
}
