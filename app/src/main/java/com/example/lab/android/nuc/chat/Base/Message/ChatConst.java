package com.example.lab.android.nuc.chat.Base.Message;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatConst {
    public static final String LISTVIEW_DATABASE_NAME = "listview.db";
    public static final String RECYCLER_DATABASE_NAME = "recycler.db";
    public static final int SENDING = 0;
    public static final int COMPLETED = 1;
    public static final int SENDERROR = 2;


    @IntDef({SENDING, COMPLETED, SENDERROR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SendState {

    }
}
