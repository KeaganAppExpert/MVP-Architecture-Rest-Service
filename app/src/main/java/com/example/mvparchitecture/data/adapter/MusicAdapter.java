package com.example.mvparchitecture.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvparchitecture.data.model.Result;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{
    private List<Result> mItems;
    private Context mContext;
    private PostItemListener mItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleTv;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(android.R.id.text1);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Result music = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(music.getTrackId());// count value on clickning hereeeeeeee

            notifyDataSetChanged();
        }
    }

    public MusicAdapter(Context context, List<Result> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MusicAdapter.ViewHolder holder, int position) {
        Result music = mItems.get(position);
        TextView textView = holder.titleTv;
        textView.setText(music.getTrackName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
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
