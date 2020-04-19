package com.amin.lw_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewHolder>
{
    public interface OnClickListener
    {
        void onClick(int index);
    }

    private int _count;
    private OnClickListener _listener;
    public RecyclerViewAdapter(int count, OnClickListener listener)
    {
        _listener = listener;
        _count = count;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();

        int layout              = R.layout.item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view               = inflater.inflate(layout, parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position)
    {
        try
        {
            holder.bind(position);
            if (_listener != null)
            {
                holder.itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        _listener.onClick(position);
                    }
                });
            }
        }
        catch (JSONException e)
        {
            App.Error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() { return _count; }
}
