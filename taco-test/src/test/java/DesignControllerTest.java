import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.mvc.TypeReferences;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.study.pcfdevcert.domain.Taco;
import org.study.pcfdevcert.resource.TacoResource;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.PublicKey;
import java.util.Collection;

@RunWith(SpringRunner.class)
public class DesignControllerTest {

    private Traverson traverson;

    @Before
    public void beginTest() throws URISyntaxException {
        traverson  = new Traverson(new URI("http://localhost:8080/api"), MediaTypes.HAL_JSON);
    }


    @Test
    public void getRecentTacos() {
        ParameterizedTypeReference<Resources<Taco>> tacoType = new ParameterizedTypeReference<Resources<Taco>>() {};
        Resources<Taco> tacoResources= traverson.follow("tacos")
                .toObject(tacoType);
        Collection<Taco> tacos = tacoResources.getContent();
    }
}
