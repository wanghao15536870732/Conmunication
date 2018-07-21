package com.example.lab.android.nuc.chat.Base.Contacts;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ContactList  {

    //创建联系人列表
    private static ContactList sContactList;

    private List<Contact> mContacts;


    //创建构造器返回联系人列表的数组
    private ContactList(Context context){
        mContacts = new ArrayList<Contact>();
    }

    //获取联系人列表
    public static ContactList get(Context context){
        if (sContactList == null){
            //实例化ContactList对象
            sContactList = new ContactList(context);
        }
        return sContactList;
    }

    //创建列表用于返回联系人列表破
    public List<Contact> getContacts(){
        return mContacts;
    }

}
