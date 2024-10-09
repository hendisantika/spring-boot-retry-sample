package id.my.hendisantika.springbootretrysample.service;

import id.my.hendisantika.springbootretrysample.rest.client.MovieApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-retry-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/24
 * Time: 08.52
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieApiClient movieApiClient;
}
