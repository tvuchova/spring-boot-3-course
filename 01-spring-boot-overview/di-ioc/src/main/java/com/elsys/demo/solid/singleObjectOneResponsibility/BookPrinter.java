package com.elsys.demo.solid.singleObjectOneResponsibility;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@Slf4j
public class BookPrinter {
    public void printBookToConsole(Book book) {
        log.info(getFormattedBookDetails(book));
    }

    public void printBookToFile(Book book, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(getFormattedBookDetails(book));
        } catch (IOException e) {
            log.error("Error writing book to file: " + e.getMessage());
        }
    }

    private String getFormattedBookDetails(Book book) {
        return String.format("Book Name: %s%nAuthor: %s%nText:%n%s",
                book.getName(),
                book.getAuthor(),
                book.getText());
    }
}