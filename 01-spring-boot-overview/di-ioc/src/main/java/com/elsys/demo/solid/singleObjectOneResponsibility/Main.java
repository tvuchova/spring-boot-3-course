package com.elsys.demo.solid.singleObjectOneResponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Book book = new Book(
                "The Adventures of Sherlock Holmes",
                "Arthur Conan Doyle",
                "To Sherlock Holmes she is always the woman.a"
        );

        TextProcessor textProcessor = new TextProcessor();


        String updatedText = textProcessor.replaceWordIbn(book.getText());

        log.info("Updated Text: {}", updatedText);

        // Check if "world" exists in the book's text
        boolean containsWorld = textProcessor.isWordInText(book.getText(), "world");
        log.info("Contains 'world': {}", containsWorld);
        BookPrinter bookPrinter = new BookPrinter();

        // Print book details to console
        bookPrinter.printBookToConsole(book);

        // Save book details to a file
        String filePath = "book_details.txt";
        bookPrinter.printBookToFile(book, filePath);

        log.info("Book details saved to file: {}", filePath);
    }

}
