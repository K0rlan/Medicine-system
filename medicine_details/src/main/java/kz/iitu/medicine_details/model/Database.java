package kz.iitu.medicine_details.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List<MedicineDetails> medicineList = new ArrayList<>();

    public Database() {
        medicineList.add(new MedicineDetails(1L, "Vitamin B", "2.5 ml", "Pharmaceuticals",
                Category.VITAMINS, 1500.0, 0.0,
                "These vitamins help the process your body uses to get or make energy from the food you eat. They also " +
                        "help form red blood cells. You can get B vitamins from proteins such as fish, poultry, meat, " +
                        "eggs, and dairy products. Leafy green vegetables, beans, and peas also have B vitamins.",
                "C₆₃H₈₈CoN₁₄O₁₄P", "Vitamin", 1355.365));
        medicineList.add(new MedicineDetails(2L, "Suprastin", "1.5 ml", "EGIS Pharmaceuticals", Category.ALERGYPILLS,
                5000.0, 0.0, "It has a mild sedative and antipruritic effect pronounced. It has antiemetic effect, " +
                "peripheral anticholinergic activity, moderate inflammatory properties. The therapeutic effect develops" +
                " within 15-30 minutes after ingestion, It reaches a maximum during the first hour after administration " +
                "and lasts for at least 3-6 no.", "C16H20ClN3", "ALERGYPILLS", 289.803));
        medicineList.add(new MedicineDetails(3L, "Vitamin E", "0.5 ml", "Pharma",
                Category.VITAMINS, 3000.0, 0.0, "A nutrient that the body needs in small amounts " +
                "to stay healthy and work the way it should. It is fat-soluble (can dissolve in fats and oils) and is " +
                "found in seeds, nuts, leafy green vegetables, and vegetable oils. Vitamin E boosts the immune system" +
                " and helps keep blood clots from forming.", "C29H50O2", "Vitamin", 430.71));
        medicineList.add(new MedicineDetails(4L, "Paracetamol", "2.5 ml", "Pharma",
                Category.ANTIBIOTICS, 5500.0, 0.0, "Paracetamol (acetaminophen) is a pain reliever" +
                " and a fever reducer. The exact mechanism of action of is not known. Paracetamol is used to treat many " +
                "conditions such as headache, muscle aches, arthritis, backache, toothaches, colds, and fevers.",
                "C8H9NO2", "ANTIBIOTICS", 151.163));
        medicineList.add(new MedicineDetails(1L, "Vitamin B", "2.5ml", "France",
                Category.VITAMINS, 1000.0, 0.0,
                "These vitamins help the process your body uses to get or make energy from the food you eat. They also " +
                        "help form red blood cells. You can get B vitamins from proteins such as fish, poultry, meat, " +
                        "eggs, and dairy products. Leafy green vegetables, beans, and peas also have B vitamins.",
                "C₆₃H₈₈CoN₁₄O₁₄P", "Vitamin", 1355.365));
        medicineList.add(new MedicineDetails(5L, "Valeriana", "2.5 ml", "EGIS Pharmaceuticals", Category.SEDATIVE, 1200.0, 0.0, "Paracetamol (acetaminophen) is a pain reliever" +
                " and a fever reducer. The exact mechanism of action of is not known. Paracetamol is used to treat many " +
                "conditions such as headache, muscle aches, arthritis, backache, toothaches, colds, and fevers.",
                "C8H9NO2", "ANTIBIOTICS", 151.163));
        medicineList.add(new MedicineDetails(6L, "Vitamin C", "1 ml", "EGIS Pharmaceuticals", Category.VITAMINS, 6000.0, 0.0,
                "These vitamins help the process your body uses to get or make energy from the food you eat. They also " +
                "help form red blood cells. You can get B vitamins from proteins such as fish, poultry, meat, " +
                "eggs, and dairy products. Leafy green vegetables, beans, and peas also have B vitamins.",
                "C₆₃H₈₈CoN₁₄O₁₄P", "Vitamin", 1355.365));
        medicineList.add(new MedicineDetails(1L, "Vitamin B", "2.5ml", "France",
                Category.VITAMINS, 1000.0, 0.0, "These vitamins help the process your body uses to get or make energy from the food you eat. They also " +
                "help form red blood cells. You can get B vitamins from proteins such as fish, poultry, meat, " +
                "eggs, and dairy products. Leafy green vegetables, beans, and peas also have B vitamins.",
                "C₆₃H₈₈CoN₁₄O₁₄P", "Vitamin", 1355.365));
        medicineList.add(new MedicineDetails(7L, "Vitamin B", "2.0 ml", "Ticals",
                Category.VITAMINS, 6500.0, 0.0, "These vitamins help the process your body " +
                "uses to get or make energy from the food you eat. They also " +
                "help form red blood cells. You can get B vitamins from proteins such as fish, poultry, meat, " +
                "eggs, and dairy products. Leafy green vegetables, beans, and peas also have B vitamins.",
                "C₆₃H₈₈CoN₁₄O₁₄P", "Vitamin", 1355.365));
        medicineList.add(new MedicineDetails(8L, "Paracetamol", "5 ml", "EGIS Pharmaceuticals", Category.ANTIBIOTICS, 2500.0, 0.0, "Paracetamol (acetaminophen) is a pain reliever" +
                " and a fever reducer. The exact mechanism of action of is not known. Paracetamol is used to treat many " +
                "conditions such as headache, muscle aches, arthritis, backache, toothaches, colds, and fevers.",
                "C8H9NO2", "ANTIBIOTICS", 151.163));
        medicineList.add(new MedicineDetails(9L, "Vitamin B", "1.0 ml", "AR Pharmaceuticals", Category.VITAMINS, 1500.0, 0.0, "These vitamins help the process your body uses to get or make energy from the food you eat. They also " +
                "help form red blood cells. You can get B vitamins from proteins such as fish, poultry, meat, " +
                "eggs, and dairy products. Leafy green vegetables, beans, and peas also have B vitamins.",
                "C₆₃H₈₈CoN₁₄O₁₄P", "Vitamin", 1355.365));
        medicineList.add(new MedicineDetails(10L, "Analgin", "2.0 ml", "IO Pharmaceuticals", Category.ANALGESIC, 1000.0, 0.0, "Paracetamol (acetaminophen) is a pain reliever" +
                " and a fever reducer. The exact mechanism of action of is not known. Paracetamol is used to treat many " +
                "conditions such as headache, muscle aches, arthritis, backache, toothaches, colds, and fevers.",
                "C8H9NO2", "ANTIBIOTICS", 151.163));
    }

    public MedicineDetails getMedicineById(Long id) {
        for (MedicineDetails medicine : medicineList) {
            if (medicine.getId().equals(id)) {
                return medicine;
            }
        }
        return null;
    }
}
