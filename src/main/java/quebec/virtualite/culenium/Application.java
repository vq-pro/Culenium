package quebec.virtualite.culenium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"quebec.virtualite.*"})
@Slf4j
public class Application
{
    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
