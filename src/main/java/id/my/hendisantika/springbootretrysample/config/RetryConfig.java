package id.my.hendisantika.springbootretrysample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-retry-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/24
 * Time: 09.11
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RetryConfig {

    @Value("${retry.maxAttempts:3}")
    private int maxAttempts;

    @Value("${retry.backoffInMillis:2000}")
    private long backoffInMillis;
}
