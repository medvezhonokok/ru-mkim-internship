package ru.internship.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskCredentials {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16)
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 65000)
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
