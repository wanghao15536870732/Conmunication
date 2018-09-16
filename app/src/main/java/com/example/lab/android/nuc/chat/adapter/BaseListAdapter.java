package com.example.lab.android.nuc.chat.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseListAdapter<E> extends BaseAdapter {



    public List<E> list;

    public Context mContext;

    public LayoutInflater mInflater;

    public List<E> getList(){
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void add(E e) {
        this.list.add(e);
        notifyDataSetChanged();
    }

    public void addAll(List<E> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        this.list.remove(position);
        notifyDataSetChanged();
    }

    public BaseListAdapter(Context context, List<E> list) {
        super();
        this.mContext = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = bindView( position,convertView,parent );
        addInternalClickListener( convertView,position,list.get( position ) );
        return convertView;
    }
    public abstract View bindView(int position, View convertView,
                                  ViewGroup parent);

    public Map<Integer, onInternalClickListener> canClickItem;
    private void addInternalClickListener(final View itemV, final Integer position,final Object valuesMap) {
        if (canClickItem != null) {
            for (Integer key : canClickItem.keySet()) {
                View inView = itemV.findViewById(key);
                final onInternalClickListener inviewListener = canClickItem.get(key);
                if (inView != null && inviewListener != null) {
                    inView.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            inviewListener.OnClickListener(itemV, v, position,
                                    valuesMap);
                        }
                    });
                }
            }
        }
    }
    public void setOnInViewClickListener(Integer key,
                                         onInternalClickListener onClickListener) {
        if (canClickItem == null)
            canClickItem = new HashMap<Integer,onInternalClickListener>() ;
        canClickItem.put(key, onClickListener);
    }
    public interface onInternalClickListener {
        public void OnClickListener(View parentV, View v, Integer position,
                                    Object values);
    }

    Toast mToast;

    public void ShowToast(final String text) {
        if (!TextUtils.isEmpty(text)) {
            //开启一个新的线程
            ((Activity) mContext).runOnUiThread( new Runnable() {
                @Override
                public void run() {
                    if (mToast == null) {
                        mToast = Toast.makeText(mContext, text,
                                Toast.LENGTH_SHORT);
                    } else {
                        mToast.setText(text);
                    }
                    mToast.show();
                }
            });

        }
    }
    public void ShowLog(String msg) {
        Toast.makeText( mContext, msg, Toast.LENGTH_SHORT ).show();
    }
}
