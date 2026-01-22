package edu.wgu.d387_sample_code.convertor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Component
public class Welcome {
    static ExecutorService messageExecutor= newFixedThreadPool(2);

    public String[] loadWelcome(String file) {
        String[] words = new String[2];
        CountDownLatch latch = new CountDownLatch(2);

        messageExecutor.execute(()-> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
                words[0] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        messageExecutor.execute(()-> {
            try {
                Properties properties = new Properties();
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
                words[1] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return words;
    }
}
