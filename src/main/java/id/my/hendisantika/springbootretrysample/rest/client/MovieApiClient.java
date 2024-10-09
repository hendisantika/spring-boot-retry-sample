package id.my.hendisantika.springbootretrysample.rest.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-retry-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/24
 * Time: 08.51
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class MovieApiClient {

    private final RestTemplate restTemplate;
}
