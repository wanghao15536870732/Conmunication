package com.example.lab.android.nuc.chat.Base.JSON;

import java.util.ArrayList;
import java.util.List;

public class ReturnComment {
    List<GetComment> comments = new ArrayList<>();
    public void add(GetComment getComment){
        comments.add(getComment);
    }

    public List<GetComment> getComments() {
        return comments;
    }

    public void setComments(List<GetComment> comments) {
        this.comments = comments;
    }
}
