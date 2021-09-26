package kz.iitu.sales.service.impl;

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
}
