package kz.example.pharmacybranch.DB;

import kz.example.pharmacybranch.model.Information;
import kz.example.pharmacybranch.model.Pharmacy;
import kz.example.pharmacybranch.model.Specialist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultationDB {
    public List<Pharmacy> pharmacyList = new ArrayList<>();
    List<Specialist> specialistList = new ArrayList<>();

    public ConsultationDB() {
        Specialist specialist1 = new Specialist(1L, "Abzal");
        Specialist specialist2 = new Specialist(2L, "Assem");
        Specialist specialist3 = new Specialist(3L, "Korlan");
        specialistList.add(specialist1);
        specialistList.add(specialist2);
        specialistList.add(specialist3);

        Pharmacy pharmacy1 = new Pharmacy(1L, "Biosfera", "Nazarbaev 6A", 4.7, specialistList.get(0), new Information());
        Pharmacy pharmacy2 = new Pharmacy(2L, "Europharma", "Abai 72", 4.9, specialistList.get(1), new Information());
        Pharmacy pharmacy3 = new Pharmacy(4L, "Apteka24", "Al-Farabi 34", 4.4, specialistList.get(2), new Information());
        pharmacyList.add(pharmacy1);
        pharmacyList.add(pharmacy2);
        pharmacyList.add(pharmacy3);
    }

    public Pharmacy getPharmacyById(long id) {
        for (Pharmacy item : pharmacyList) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }
}
