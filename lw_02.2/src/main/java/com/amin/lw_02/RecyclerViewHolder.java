package com.amin.lw_02;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

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

        _linearLayout   = (LinearLayout) itemView.findViewById(R.id.layoutItemId);
        _name = itemView.findViewById(R.id.nameId);
        _graphic = itemView.findViewById(R.id.graphicId);
    }

    void bind(int index) throws JSONException
    {
        JSONObject post = App.JsonArray.getJSONObject(index + 1);
        String url = post.getString("graphic");
        Glide.with(_itemView)
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/"+url)
                .centerCrop()
                .placeholder(R.drawable.graphic)
                .into(_graphic);
        _name.setText(post.getString("name") + " url:" + url);
    }
}
