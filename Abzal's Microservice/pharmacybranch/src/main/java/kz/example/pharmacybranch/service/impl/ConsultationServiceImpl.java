package kz.example.pharmacybranch.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.example.pharmacybranch.DB.ConsultationDB;
import kz.example.pharmacybranch.model.Information;
import kz.example.pharmacybranch.model.Medicine;
import kz.example.pharmacybranch.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
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
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Information getInfoById(long id) {
        return restTemplate.getForObject("http://consultation-service/information/" + id, Information.class);
        }
    public Information getInfoByIdFallback(Long id) {
        Information information = new Information();
        information.setId(0L);
        return information;
    }
    }




