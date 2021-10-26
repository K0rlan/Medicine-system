package kz.iitu.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.order.model.Medicine;
import kz.iitu.order.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getMedicineByIdFallback",
            threadPoolKey = "getMedicineById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Medicine getMedicineById(Long id)  {
        return restTemplate.getForObject("http://medicines-service/medicines/" + id, Medicine.class);
    }

    public Medicine getMedicineByIdFallback(Long id) {
        Medicine medicine = new Medicine();
        medicine.setId(0L);
        medicine.setName("Medicine is not available: Service Unavailable");
        return medicine;
    }
}
