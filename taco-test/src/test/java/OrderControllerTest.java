import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.study.pcfdevcert.domain.Order;

@RunWith(SpringRunner.class)
public class OrderControllerTest {

    @TestConfiguration
    static class DesignControllerTestConfiguration {

    }

    @Before
    public void setup()
    {

    }

    @Test
    public void getAllOrdersTest(){
        RestTemplate rest = new RestTemplate();
        rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        TacoResource[] tacoList =  rest.getForObject("http://localhost:8080/design/recent", TacoResource[].class);
        Order[] orderList =  rest.getForObject("http://localhost:8080/orders", Order[].class);
    }

}
