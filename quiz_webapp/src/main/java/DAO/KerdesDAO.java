package DAO;

import model.Kerdes;
import model.Valasz;

import java.util.List;

public interface KerdesDAO {
    List<Kerdes> findAllKerdesek();
    List<Valasz> findAllValasz();

    Kerdes findKerdesViaID(int id);
    Valasz findValaszViaID(int id);

    void addKerdes(Kerdes kerdes);
    void addValasz(Valasz valasz);

    int getKerdesID(String szoveg);

}
