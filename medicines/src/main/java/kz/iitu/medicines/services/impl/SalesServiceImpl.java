package kz.iitu.medicines.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getDiscountByMedicineCategoryFallback",
            threadPoolKey = "getDiscountByMedicineCategory",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Double getDiscountByMedicineCategory(Category category) {
        return restTemplate.getForObject("http://discount-service/medicines/discount/category/" + category, Double.class);
    }

    public Double getDiscountByMedicineCategoryFallback(Category category) {
        return 0.0;
    }
}
