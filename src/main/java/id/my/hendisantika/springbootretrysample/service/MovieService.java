package id.my.hendisantika.springbootretrysample.service;

import id.my.hendisantika.springbootretrysample.entity.Movie;
import id.my.hendisantika.springbootretrysample.rest.client.MovieApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

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

    @Retryable(
            retryFor = {HttpServerErrorException.class, HttpClientErrorException.class, ResourceAccessException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 5000))
    public Movie getMovieDetails(String movieId) throws ResourceAccessException {
        Movie movie = null;
        try {
            movie = movieApiClient.getMovieDetails(movieId);
        } catch (HttpServerErrorException httpServerErrorException) {
            System.out.println("Received HTTP server error exception while fetching the movie details. Error Message: " + httpServerErrorException.getMessage());
            throw httpServerErrorException;
        } catch (HttpClientErrorException httpClientErrorException) {
            System.out.println("Received HTTP client error exception while fetching the movie details. Error Message: " + httpClientErrorException.getMessage());
            throw httpClientErrorException;
        } catch (ResourceAccessException resourceAccessException) {
            System.out.println("Received Resource Access exception while fetching the movie details.");
            throw resourceAccessException;
        }
        return movie;
    }
}
