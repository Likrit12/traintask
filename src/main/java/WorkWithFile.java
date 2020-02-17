package main.java;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class WorkWithFile {
    public static void copyFile(File copyFile) throws IOException {
        try (FileInputStream fin = new FileInputStream(copyFile);
             FileOutputStream fos = new FileOutputStream(new File("src\\main\\resource\\backup", copyFile.getName()))) {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.outfffffffffffffffffffffff.println(ex.getMessage());
        }
    }
    public static void fileWrite(File file,String stringWrite){
        try(FileWriter writer = new FileWriter(file, false))
        {
            writer.write(stringWrite);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String fileReader(File file) {
        String read = new String();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                read += (char) c;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return read;
    }

    public static String whitespaceDelete(String baseString)
    {
        ResourceBundle rb = ResourceBundle.getBundle("resources");
        Pattern CLEAR_PATTERN = Pattern.compile(rb.getString("whitespace"));
        String resultLine = CLEAR_PATTERN.matcher(baseString).replaceAll(" ").trim();
        return resultLine;
    }

    public static List<Word> extractWord(String baseString)
    {
        List<Word> extractedWords = new ArrayList<>();
        ResourceBundle rb = ResourceBundle.getBundle("resources");
        String[] words = baseString.split(rb.getString("word"));
        for (String word:words)
        {
            extractedWords.add(new Word(word));
        }
        return  extractedWords;
    }

    public static List<Sentence> extractSentence(String baseString)
    {
        List<Sentence> extractedSentence = new ArrayList<>();
        ResourceBundle rb = ResourceBundle.getBundle("resources");
        String[] sentences = baseString.split(rb.getString("sentence"));
        for (String sentence: sentences)
        {
            extractedSentence.add(new Sentence(sentence));
        }
        return  extractedSentence;
    }
}


