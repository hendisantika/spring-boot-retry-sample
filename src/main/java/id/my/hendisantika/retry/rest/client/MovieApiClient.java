package id.my.hendisantika.retry.rest.client;

import id.my.hendisantika.retry.entity.Movie;
import id.my.hendisantika.retry.exception.MovieNotFoundException;
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

    public Movie getMovieDetails(String movieId) {
        String url = "http://localhost:8080/mock/movies/" + movieId;
        Movie movie = restTemplate.getForObject(url, Movie.class);
        if (movie == null) {
            throw new MovieNotFoundException("Movie with id " + movieId + " not found.");
        }
        return movie;
    }
}
