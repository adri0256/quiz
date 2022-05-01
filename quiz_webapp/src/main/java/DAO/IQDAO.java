package DAO;

import model.IQ;

import java.util.List;

public interface IQDAO {
    List<IQ> findAllIQ();

    IQ findIQByID(int id);

    void addIQ(IQ IQ);
    void ModifyIQ(IQ updateIQ);
    void deleteIQ(String id);
}
