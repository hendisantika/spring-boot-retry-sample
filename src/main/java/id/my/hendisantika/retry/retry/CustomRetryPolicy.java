package id.my.hendisantika.retry.retry;

import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.context.RetryContextSupport;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-retry-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/24
 * Time: 09.12
 * To change this template use File | Settings | File Templates.
 */
public class CustomRetryPolicy implements RetryPolicy {

    private final int maxAttempts;

    public CustomRetryPolicy(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public boolean canRetry(RetryContext context) {
        int attempts = context.getRetryCount();
        return attempts < maxAttempts;
    }

    @Override
    public RetryContext open(RetryContext parent) {
        return new RetryContextSupport(parent);
    }

    @Override
    public void close(RetryContext context) {
        // Do nothing
    }

    @Override
    public void registerThrowable(RetryContext context, Throwable throwable) {
        RetryContextSupport retryContext = (RetryContextSupport) context;
        retryContext.registerThrowable(throwable);
    }

    @Override
    public String toString() {
        return "CustomRetryPolicy [maxAttempts=" + maxAttempts + "]";
    }
}
