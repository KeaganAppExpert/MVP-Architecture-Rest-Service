package com.example.mvparchitecture.data.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvparchitecture.MainActivity;
import com.example.mvparchitecture.MusicDetailsFragment;
import com.example.mvparchitecture.MusicListDetailsActivity;
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
        String myString = "";
        String test = "";

        myString = music.getTrackName();
        if(myString!=null) {
            holder.musicName.setText(myString);
        } else {
            holder.musicName.setText("Unavailable");
        }


        Glide.with(mContext)
                .load(music.getArtworkUrl100())
                .into(holder.musicImage);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(mContext, "#" + position + " - " + music.getArtistName() + " (Long click)", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(mContext, "#" + position + " - " + music.getArtistName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MusicListDetailsActivity.class);
                    if(intent!=null && music.getTrackPrice()!=null && music.getArtistName()!=null) {
                        intent.putExtra(MusicListDetailsActivity.ARTIST_NAME, music.getArtistName());
                        intent.putExtra(MusicListDetailsActivity.TRACK_NAME, music.getTrackName());
                        intent.putExtra(MusicListDetailsActivity.TRACK_PRICE, music.getTrackPrice().toString());
                        intent.putExtra(MusicListDetailsActivity.COLLECTION_NAME, music.getCollectionName());
                        intent.putExtra(MusicListDetailsActivity.TRACK_URL, music.getArtworkUrl100());
                        intent.putExtra(MusicListDetailsActivity.RATING, music.getContentAdvisoryRating());
                        intent.putExtra(MusicListDetailsActivity.COLLECTION_ARTIST_URL, music.getCollectionArtistViewUrl());
                        intent.putExtra(MusicListDetailsActivity.RELEASE_DATE, music.getReleaseDate());
                        intent.putExtra(MusicListDetailsActivity.PRIMARY_GENRE_RELEASE, music.getPrimaryGenreName());
                        intent.putExtra(MusicListDetailsActivity.TRACK_EXPLICITNESS, music.getTrackExplicitness());
                        intent.putExtra(MusicListDetailsActivity.TRACK_NUMBER, music.getTrackNumber());
                        mContext.startActivity(intent);
                    }
                }
            }
        });


        if(music.getTrackPrice()!=null) {
            test = "$" + (music.getTrackPrice());
            holder.price.setText(test);
        } else {
            test = "N/A";
            holder.price.setText(test);
        }
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
}
