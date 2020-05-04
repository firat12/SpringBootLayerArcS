package com.firatcapin.stok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing  // Jpa Denetimini etkinleştirmek için
@EnableTransactionManagement
public class StokApplication {

    public static void main(String[] args) {
        SpringApplication.run(StokApplication.class, args);
    }

}
