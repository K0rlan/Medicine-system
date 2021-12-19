package kz.iitu.medicine_details.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.medicine_details.model.Category;
import kz.iitu.medicine_details.services.SalesService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public Double getDiscountByMedicineCategory(Category category) {
        String apiCredentials = "sales-client:sales";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://discount-service/discount/category/" + category,
                HttpMethod.GET, entity, Double.class).getBody();
    }

    public Double getDiscountByMedicineCategoryFallback(Category category) {
        return 1.0;
    }
}

