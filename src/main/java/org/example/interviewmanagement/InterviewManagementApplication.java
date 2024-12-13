package org.example.interviewmanagement;

import org.example.interviewmanagement.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class InterviewManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewManagementApplication.class, args);
    }

}
