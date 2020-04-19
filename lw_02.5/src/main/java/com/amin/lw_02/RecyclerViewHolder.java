package com.amin.lw_02;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class RecyclerViewHolder  extends RecyclerView.ViewHolder
{
    private LinearLayout    _linearLayout;
    private TextView _name;
    private ImageView _graphic;

    private View _itemView;

    public RecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
        App.Log("new RecyclerViewHolder");
        _itemView = itemView;

        _linearLayout = (LinearLayout) itemView.findViewById(R.id.layoutItemId);
        _name = itemView.findViewById(R.id.nameId);
        _graphic = itemView.findViewById(R.id.graphicId);
    }

    void bind(int index)
    {
        Technologies t = App.TechnologiesGet(index);
        Glide.with(_itemView)
                .load(App.TechnologiesItemUrl(t.getGraphic()))
                //.centerCrop()
                .fitCenter()
                .placeholder(R.drawable.graphic)
                .into(_graphic);

        _name.setText("   " + t.getName());
        _linearLayout.setBackgroundColor(App.Colors[index % 2]);
    }
}
