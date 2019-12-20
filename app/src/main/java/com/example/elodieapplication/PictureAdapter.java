package com.example.elodieapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder> {
  private List<Picture> picturesList;
  private ItemClickListener itemClickListener;

  public void setPicturesList(List<Picture> picturesList) {
    this.picturesList = picturesList;
    notifyDataSetChanged();
  }

  public void setItemClickListener(ItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }

  @NonNull @Override public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_picture, viewGroup, false);
    return new PictureViewHolder(view);
  }

  @Override public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int i) {
    final Picture picture = picturesList.get(i);
    pictureViewHolder.nameTv.setText(picture.getTitle());

    Glide.with(pictureViewHolder.itemView).load(picture.getUrl()).centerCrop().into(pictureViewHolder.pictureImv);

    if (itemClickListener != null) {
      pictureViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          itemClickListener.onClick(picture);
        }
      });
    }
  }

  @Override public int getItemCount() {
    return picturesList != null ? picturesList.size() : 0;
  }

  class PictureViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_picture_imv) ImageView pictureImv;
    @BindView(R.id.item_picture_name_tv) TextView nameTv;

    public PictureViewHolder(@NonNull View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public interface ItemClickListener {
    void onClick(Picture picture);
  }
}
