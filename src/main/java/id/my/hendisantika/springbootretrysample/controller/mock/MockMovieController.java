package id.my.hendisantika.springbootretrysample.controller.mock;

import id.my.hendisantika.springbootretrysample.entity.Movie;
import id.my.hendisantika.springbootretrysample.exception.MovieNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-retry-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/24
 * Time: 08.54
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/mock/movies")
public class MockMovieController {

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        if (id.equals("1")) {
            return new Movie("1", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8.7);
        } else if (id.equals("2")) {
            return new Movie("2", "Inception", "Christopher Nolan", 8.8);
        } else {
            throw new MovieNotFoundException("Movie with id " + id + " not found.");
        }
    }
}
