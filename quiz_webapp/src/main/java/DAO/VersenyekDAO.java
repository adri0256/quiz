package DAO;

import model.Versenyek;

import java.util.List;

public interface VersenyekDAO {
    List<Versenyek> findAllVersenyek();

    Versenyek findVersenyByID(int id);

    void addVersenyek(Versenyek versenyek);
    void ModifyVersenyek(Versenyek updateVersenyek);
    void deleteVersenyek(String id);
}
