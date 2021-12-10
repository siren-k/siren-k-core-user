package com.sirenk.core.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.sirenk.core.user",
                "com.sirenk.core.common.util",
                "com.sirenk.core.common.http.intercepter",
                "com.sirenk.core.common.http.response",
        }
)
public class SirenKCoreUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SirenKCoreUserApplication.class, args);
    }

}
