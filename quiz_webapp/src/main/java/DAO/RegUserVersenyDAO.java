package DAO;

import model.RegUserVerseny;
import model.Versenyek;

import java.util.List;

public interface RegUserVersenyDAO {
    List<RegUserVerseny> findAllRegUserVerseny();
    RegUserVerseny findRegUserVersenyByRegID(int regid);

    void addRegUserVerseny(RegUserVerseny RUV);
    void ModifyRegUserVerseny(RegUserVerseny updateRegUserVerseny);
    void deleteRegUserVerseny(String regid);
}
