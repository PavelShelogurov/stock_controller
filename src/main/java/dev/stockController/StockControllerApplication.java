package dev.stockController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@Configuration

@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:secret.properties"),
		@PropertySource("classpath:messages_test_ru.properties")
})
public class StockControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockControllerApplication.class, args);
	}

}
