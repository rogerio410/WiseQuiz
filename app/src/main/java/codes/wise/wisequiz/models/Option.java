package codes.wise.wisequiz.models;

import java.io.Serializable;

/**
 * Created by rogermac on 01/05/17.
 */

public class Option implements Serializable{

    private String text;

    public Option(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

