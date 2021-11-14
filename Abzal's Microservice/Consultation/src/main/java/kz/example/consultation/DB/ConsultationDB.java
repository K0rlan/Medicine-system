package kz.example.consultation.DB;

import kz.example.consultation.model.Information;
import kz.example.consultation.model.Medicine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultationDB {
    public List<Information> informationList = new ArrayList<>();

    public ConsultationDB() {
        Information information1 = new Information(1L, new Medicine(), 10.5, Arrays.asList("Down", "Alzheimer", "Headache"));
        Information information2 = new Information(2L, new Medicine(), 11.2, Arrays.asList("Anxiety", "Personality", "Psychotic"));
        Information information3 = new Information(3L, new Medicine(), 15.6, Arrays.asList("Eating", "Trauma-related", "Substance abuse"));
        informationList.add(information1);
        informationList.add(information2);
        informationList.add(information3);
    }

    public Information getInfoById(long id) {
        for (Information item : informationList) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }
}
