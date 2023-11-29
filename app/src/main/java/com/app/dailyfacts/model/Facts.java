package com.app.dailyfacts.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Facts {
    public List<String> getFacts() {
        return facts;
    }

    public void setFacts(List<String> facts) {
        this.facts = facts;
    }

    @SerializedName("facts")
    public List<String> facts = new ArrayList<>();

}
