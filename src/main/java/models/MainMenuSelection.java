package models;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MainMenuSelection {

    private String choice;

    public MainMenuSelection(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        setChoice();
        return choice;
    }

    public void setChoice() {
        this.choice = choice;
    }
}
