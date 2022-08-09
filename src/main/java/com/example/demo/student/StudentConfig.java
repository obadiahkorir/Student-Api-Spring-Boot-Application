package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args ->
        {
            Student obadiah = new Student(
                    "Obadiah",
                    "Kipsang",
                    LocalDate.of(1995, Month.FEBRUARY, 23)
            );
            Student james = new Student(
                    "Jame",
                    "Opiyo",
                    LocalDate.of(1995, Month.FEBRUARY, 23)
            );
            Student isaac = new Student(
                    "Isoo",
                    "Kimani",
                    LocalDate.of(1995, Month.FEBRUARY, 23)
            );
            Student caleb = new Student(
                    "Caleb",
                    "Mburu",
                    LocalDate.of(1995, Month.FEBRUARY, 23)
            );
            Student vincent = new Student(
                    "Vincent",
                    "Karanja",
                    LocalDate.of(1995, Month.FEBRUARY, 23)
            );
            studentRepository.saveAll(
                    List.of(obadiah,james,isaac,vincent)
            );
        };
    }
}
