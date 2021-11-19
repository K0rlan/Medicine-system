package kz.iitu.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.order.model.Medicine;
import kz.iitu.order.service.MedicineService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getMedicineByIdFallback",
            threadPoolKey = "getMedicineById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public Medicine getMedicineById(Long id) {
//        return restTemplate.getForObject("http://medicines-service/medicines/" + id, Medicine.class);

        String apiCredentials = "koko-client:koko";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        return restTemplate.exchange("http://medicines-service/medicines/" + id,
                HttpMethod.GET, entity, Medicine.class).getBody();
    }

    public Medicine getMedicineByIdFallback(Long id) {
        Medicine medicine = new Medicine();
        medicine.setId(0L);
        medicine.setName("Medicine is not available: Service Unavailable");
        return medicine;
    }
}
