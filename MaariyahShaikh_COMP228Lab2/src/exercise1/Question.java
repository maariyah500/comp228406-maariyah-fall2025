package exercise1;

public class Question {
    String prompt;

    String options;

    int answerKey;

    public Question(String prompt, String options, int answerKey) {
        this.prompt = prompt;
        this.options = options;
        this.answerKey = answerKey;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(int answerKey) {
        this.answerKey = answerKey;
    }
}