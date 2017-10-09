package com.example.BookStore.storedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStore.storedemo.domain.Book;
import com.example.BookStore.storedemo.domain.BookRepository;
import com.example.BookStore.storedemo.domain.User;
import com.example.BookStore.storedemo.domain.UserRepository;


@SpringBootApplication
public class BookStoreDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(BookStoreDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreDemoApplication.class, args);
	}


	@Bean
    public CommandLineRunner book(BookRepository repository, UserRepository urepository) {
	    return (args) -> {
	        log.info("add books!");
	        repository.save(new Book("LOTR 1", "JRR Tolkien", 1950, "123456789-1234", 30.00));
            repository.save(new Book("LOTR 2", "JRR Tolkien", 1960, "123456789-1235", 30.00));
            repository.save(new Book("LOTR 3", "JRR Tolkien", 1970, "123456789-1236", 30.00));

            User user1 = new User("user",
                    "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin",
                    "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);


            log.info("retrieve booklist");
	        for (Book book : repository.findAll()){
	                log.info(book.toString());
            }
            log.info("");
	    };

    }

}