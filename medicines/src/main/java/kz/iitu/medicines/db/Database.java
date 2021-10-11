package kz.iitu.medicines.db;

import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.model.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List<Medicine> medicineList = new ArrayList<>();

    public Database() {
        medicineList.add(new Medicine(1L, "Vitamin B", "2.5 ml", "Pharmaceuticals", Category.VITAMINS, 1500.0, 0.0));
        medicineList.add(new Medicine(2L, "Suprastin", "1.5 ml", "EGIS Pharmaceuticals", Category.ALERGYPILLS, 5000.0, 0.0));
        medicineList.add(new Medicine(3L, "Vitamin E", "0.5 ml", "Pharma", Category.VITAMINS, 3000.0, 0.0));
        medicineList.add(new Medicine(4L, "Paracetamol", "2.5 ml", "Pharma", Category.ANTIBIOTICS, 5500.0, 0.0));medicineList.add(new Medicine(1L, "Vitamin B", "2.5ml", "France", Category.VITAMINS, 1000.0, 0.0));
        medicineList.add(new Medicine(5L, "Valeriana", "2.5 ml", "EGIS Pharmaceuticals", Category.SEDATIVE, 1200.0, 0.0));
        medicineList.add(new Medicine(6L, "Vitamin C", "1 ml", "EGIS Pharmaceuticals", Category.VITAMINS, 6000.0, 0.0));medicineList.add(new Medicine(1L, "Vitamin B", "2.5ml", "France", Category.VITAMINS, 1000.0, 0.0));
        medicineList.add(new Medicine(7L, "Vitamin B", "2.0 ml", "Ticals", Category.VITAMINS, 6500.0, 0.0));
        medicineList.add(new Medicine(8L, "Paracetamol", "5 ml", "EGIS Pharmaceuticals", Category.ANTIBIOTICS, 2500.0, 0.0));
        medicineList.add(new Medicine(9L, "Vitamin B", "1.0 ml", "AR Pharmaceuticals", Category.VITAMINS, 1500.0, 0.0));
        medicineList.add(new Medicine(10L, "Analgin", "2.0 ml", "IO Pharmaceuticals", Category.ANALGESIC, 1000.0, 0.0));
    }

    public List<Medicine> getFullMedicineList() {
        return  medicineList;
    }

    public Medicine getMedicineById(Long id) {
        for (Medicine medicine : medicineList) {
            if (medicine.getId().equals(id)) {
                return medicine;
            }
        }
        return null;
    }

    public List<Medicine> getMedicineByCategory(Category category) {
        List<Medicine> filteredList = new ArrayList<>();
        for (Medicine medicine : medicineList) {
            if (medicine.getCategory().equals(category)) {
                filteredList.add(medicine);
            }
        }
        return filteredList;
    }
}
