package kz.example.pharmacybranch.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.example.pharmacybranch.model.Information;
import kz.example.pharmacybranch.model.Medicine;
import kz.example.pharmacybranch.repository.PharmacyRepository;
import kz.example.pharmacybranch.service.ConsultationService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getInfoByIdFallback",
            threadPoolKey = "getInfoById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public Information getInfoById(long id) {
        String apiCredentials = "koko-client:koko";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        return restTemplate.exchange("http://consultation-service/information/" + id,
                HttpMethod.GET, entity, Information.class).getBody();
    }

    public Information getInfoByIdFallback(Long id) {
        Information information = new Information();
        information.setId(0L);
        return information;
    }
}




