package com.example.ammar.alberah.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ammar.alberah.CardModel;
import com.example.ammar.alberah.R;
import com.example.ammar.alberah.helpers.OnRecyclerViewItemClickListener;
import com.example.ammar.alberah.helpers.PaletteManager;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private List<CardModel> items;
    private OnRecyclerViewItemClickListener<CardModel> itemClickListener;
    private int itemLayout;
    private PaletteManager paletteManager = new PaletteManager();

    public MyRecyclerAdapter(List<CardModel> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final CardModel item = items.get(position);
        holder.itemView.setTag(item);
        holder.text.setText(item.getText());
        Picasso.get().load(item.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View view) {
        if (itemClickListener != null) {
            CardModel model = (CardModel) view.getTag();
            itemClickListener.onItemClick(view, model);
        }
    }

    public void add(CardModel item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(CardModel item) {
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<CardModel> listener) {
        this.itemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }

        public void updatePalette(PaletteManager paletteManager) {
            String imageString = ((CardModel) itemView.getTag()).getImage();
            // Picasso.get().load(imageString).into(image);
//            paletteManager.getPalette(key, bitmap, new PaletteManager.Callback() {
//                @Override
//                public void onPaletteReady(Palette palette) {
//                    int bgColor = palette.getDarkVibrantColor(0x7DD1FF);
//                    text.setBackgroundColor(setColorAlpha(bgColor, 192));
//                    text.setTextColor(palette.getLightMutedColor(0x7DD1FF));
//                }
//            });
        }
    }
}