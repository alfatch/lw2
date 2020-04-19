package com.amin.lw_02;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

public class RecyclerViewHolder  extends RecyclerView.ViewHolder
{
    private LinearLayout    _linearLayout;
    private TextView _name;
    private TextView _helptext;

    public RecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);

        _linearLayout   = (LinearLayout) itemView.findViewById(R.id.layoutItemId);
        _name = itemView.findViewById(R.id.nameId);
        _helptext = itemView.findViewById(R.id.nameId);
    }

    void bind(int index) throws JSONException
    {
        JSONObject post = App.JsonArray.getJSONObject(index + 1);
        _name.setText(post.getString("name"));
        _helptext.setText(post.getString("helptext"));
    }
}
