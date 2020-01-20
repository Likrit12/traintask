package main.java;

public class Sentence {
    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    private String sentence;
    public Sentence(String sentence){
        this.sentence = sentence;
    }
}
