package DAO;

import model.Temakor;

import java.util.List;

public interface TemakorDAO {
    List<Temakor> findAllTemakor();
    Temakor findTemakorViaID(int id);
    Temakor findTemakorViaName(String name);

    void addTemakor(Temakor temakor);
    void addTemakorKerdes(int kerdesId, int temakorId);
    void deleteTemakor(String id);
    void ModifyTemakor(Temakor temakor);
}
