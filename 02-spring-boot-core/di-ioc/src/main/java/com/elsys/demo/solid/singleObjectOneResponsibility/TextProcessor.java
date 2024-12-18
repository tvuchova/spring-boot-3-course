package com.elsys.demo.solid.singleObjectOneResponsibility;

public class TextProcessor {
    public String replaceWordIbn(String text) {
        return text.replaceAll("ibn", "Ibn");
    }

    public boolean isWordInText(String text, String word) {
        return text.contains(word);
    }
}
