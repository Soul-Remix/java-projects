package com.example.textstatistics;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class HelloController {
    public TextArea textArea;
    public Label lettersCount;
    public Label wordsCount;
    public Label longestWord;

    public void onTextAreaChanged(KeyEvent keyEvent) {
        String text = textArea.getText();
        String[] words = text.split(" ");
        int lettersCount = text.length();
        int wordsCount = words.length;
        String longestWord = words[0];

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        this.lettersCount.setText(lettersCount + "");
        this.wordsCount.setText(wordsCount + "");
        this.longestWord.setText(longestWord);
    }
}