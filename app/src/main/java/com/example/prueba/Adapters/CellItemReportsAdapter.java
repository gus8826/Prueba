package com.example.prueba.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Models.ItemData;
import com.example.prueba.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CellItemReportsAdapter extends RecyclerView.Adapter<CellItemReportsAdapter.ViewReports> {

    private List<ItemData> list;
    private int layout;
    private OnItemClickListener itemClickListener;

    public CellItemReportsAdapter(ArrayList<ItemData> list, int layout, OnItemClickListener listener) {
        this.list = list;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public CellItemReportsAdapter.ViewReports onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewReports(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CellItemReportsAdapter.ViewReports holder, @SuppressLint("RecyclerView") final int position) {
        holder.bind(list.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewReports extends RecyclerView.ViewHolder {

        TextView textViewAliasReport;
        TextView textViewNameReport;
        ImageView imageViewReports;

        ViewReports(View itemView) {
            super(itemView);
            textViewAliasReport = itemView.findViewById(R.id.textViewAliasReport);
            textViewNameReport = itemView.findViewById(R.id.textViewNameReport);
            imageViewReports = itemView.findViewById(R.id.imageViewReports);

        }

        public void bind(final ItemData itemData, final OnItemClickListener listener) {
            textViewNameReport.setText(itemData.getName());
            textViewAliasReport.setText(itemData.getNameAlias());
            Picasso.get().load(itemData.getImage_()).fit().into(imageViewReports);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(itemData, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ItemData itemData, int position);
    }
}