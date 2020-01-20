package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src\\main\\resource\\original","book.txt");
        WorkWithFile.copyFile(file);
        String baseString = WorkWithFile.fileReader(file);
        WorkWithFile.fileWrite(file,WorkWithFile.whitespaceDelete(baseString));
        List<Word> extractedWord = WorkWithFile.extractWord(baseString);
        List<Sentence> extractedSentence = WorkWithFile.extractSentence(baseString);
        for (Word word: extractedWord)
        {
            System.out.println(word.getWord());
        }
        for (Sentence sentence: extractedSentence)
        {
            System.out.println(sentence.getSentence());
        }
    }
}
