package kz.iitu.medicines.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.medicines.model.Category;
import kz.iitu.medicines.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getDiscountByMedicineCategoryFallback",
            threadPoolKey = "getDiscountByMedicineCategory",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public Double getDiscountByMedicineCategory(Category category) {
//        return restTemplate.getForObject("http://discount-service/medicines/discount/category/" + category, Double.class);
        String apiCredentials = "sales-client:sales";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://discount-service/medicines/discount/category/" + category,
                HttpMethod.GET, entity, Double.class).getBody();
    }

    public Double getDiscountByMedicineCategoryFallback(Category category) {
        return 0.0;
    }
}
