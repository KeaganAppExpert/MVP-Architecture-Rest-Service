package com.example.mvparchitecture.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvparchitecture.R;
import com.example.mvparchitecture.data.model.Result;
import com.example.mvparchitecture.data.utilities.ItemClickListener;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{
    private List<Result> mItems;
    private Context mContext;
    private int rowLayout;

    public MusicAdapter(List<Result> posts, int rowLayout, Context context) {
        this.mItems = posts;
        this.mContext = context;
        this.rowLayout = rowLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MusicAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Result music = mItems.get(position);
        holder.musicName.setText(music.getTrackName());
        Glide.with(mContext)
                .load(music.getArtworkUrl100())//changes made here=========================================
                .into(holder.musicImage);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(mContext, "#" + position + " - " + music.getArtistName() + " (Long click)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "#" + position + " - " + music.getArtistName(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        holder.price.setText("$" + music.getTrackPrice().toString());
        holder.artistName.setText(music.getArtistName());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView musicName;
        public TextView artistName;
        public TextView price;
        public ImageView musicImage;

        private ItemClickListener clickListener;


        public ViewHolder(View itemView) {
            super(itemView);
            musicName = (TextView) itemView.findViewById(R.id.name);
            musicImage = (ImageView)itemView.findViewById(R.id.img);
            price = (TextView) itemView.findViewById(R.id.price);
            artistName = (TextView) itemView.findViewById(R.id.artistName);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onClick(v, getPosition(), true);
            return true;
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void updateAnswers(List<Result> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Result getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}
