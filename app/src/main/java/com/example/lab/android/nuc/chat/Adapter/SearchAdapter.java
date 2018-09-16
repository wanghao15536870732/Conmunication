package com.example.lab.android.nuc.chat.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lab.android.nuc.chat.base.Search.SearchTag;
import com.example.lab.android.nuc.chat.view.fragment.MessageFragment;
import com.example.lab.android.nuc.chat.R;
import com.example.lab.android.nuc.chat.chatUI.activity.ServiceChatActivity;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> implements View.OnClickListener{

    private Context mContext;
    private ArrayList<SearchTag> mArrayList;
    private MessageFragment.OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener = null;

    public SearchAdapter(ArrayList<SearchTag> arrayList, MessageFragment.OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener) {
        this.mArrayList = arrayList;
        this.mOnRecyclerviewItemClickListener = mOnRecyclerviewItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_message_item, parent, false);
        final ViewHolder imageViewHolder = new ViewHolder(view);
        imageViewHolder.message_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = imageViewHolder.getAdapterPosition();
                SearchTag searchTag = mArrayList.get(position);
                Intent intent = new Intent(mContext, ServiceChatActivity.class);
                intent.putExtra(ServiceChatActivity.CONTACT_NAME, searchTag.title);
                intent.putExtra( "contact_image_uri",searchTag.imageUri );
                mContext.startActivity(intent);
            }
        });
        view.setOnClickListener(this);
        return imageViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.message_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchTag searchTag = mArrayList.get(position);
                Intent intent = new Intent(mContext, ServiceChatActivity.class);
                intent.putExtra(ServiceChatActivity.CONTACT_NAME, searchTag.title);
                intent.putExtra( "contact_image_uri",searchTag.imageUri );
                mContext.startActivity(intent);
            }
        });
        Glide.with(mContext).load(mArrayList.get( position ).imageUri).into(((ViewHolder) holder).message_image);
//                ((ViewHolder) holder).message_image.setImageResource(mArrayList.get(position).photo);
        holder.message_name.setText(mArrayList.get(position).title);
        holder.soontext.setText(mArrayList.get(position).about);
        holder.message_time.setText(mArrayList.get(position).time);
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onClick(View v) {
        mOnRecyclerviewItemClickListener.onItemClickListaner(v, ((int) v.getTag()));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView soontext;
        ImageView message_image;
        TextView message_name;
        TextView message_time;
        RelativeLayout message_item;

        public ViewHolder(View itemView) {
            super(itemView);
            message_item = (RelativeLayout) itemView.findViewById(R.id.message_item);
            message_image = (ImageView) itemView.findViewById(R.id.friend_icon);
            soontext = (TextView) itemView.findViewById(R.id.soonText);
            message_name = (TextView) itemView.findViewById(R.id.friend_name);
            message_time = (TextView) itemView.findViewById(R.id.time);
        }
    }

    public void setFilter(ArrayList<SearchTag> FilteredDataList) {
        mArrayList = FilteredDataList;
        notifyDataSetChanged();
    }

}
