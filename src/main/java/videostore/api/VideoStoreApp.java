package videostore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by victor on 6/3/17.
 */
@SpringBootApplication
public class VideoStoreApp extends WebMvcConfigurerAdapter{
    public static void main (String[] args) {
        SpringApplication.run(VideoStoreApp.class, args);
    }
}
