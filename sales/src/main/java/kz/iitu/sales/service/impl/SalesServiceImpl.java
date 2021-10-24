package kz.iitu.sales.service.impl;

import kz.iitu.sales.model.Category;
import kz.iitu.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SalesServiceImpl implements SalesService {

    @Override
    public Double getDiscountByMediicineId(Long id) {
        return new Double(10*id);
    }

    @Override
    public Double getDiscountByMediicineCategory(Category category) {
        System.out.println("getDiscountByMediicineCategory");
        switch (category) {
            case ALERGYPILLS:
                return 15.0;
            case SEDATIVE:
                return 5.0;
            case VITAMINS:
                return 20.0;
            case ANALGESIC:
                return 30.0;
            case HEARTPILLS:
                return 35.0;
            case ANTIBIOTICS:
                return 10.0;
        }
        return 0.0;
    }
}
