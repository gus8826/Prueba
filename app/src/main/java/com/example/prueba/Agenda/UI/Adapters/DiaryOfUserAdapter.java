package com.example.prueba.Agenda.UI.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Agenda.Models.DiaryOfUserModel;
import com.example.prueba.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DiaryOfUserAdapter extends RecyclerView.Adapter<DiaryOfUserAdapter.DiaryOfUserHolder> {

    private List<DiaryOfUserModel> list;
    private int layout;
    private OnItemClickListener itemClickListener;

    public DiaryOfUserAdapter(ArrayList<DiaryOfUserModel> list, int layout, OnItemClickListener listener) {
        this.list = list;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public DiaryOfUserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new DiaryOfUserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryOfUserHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.bind(list.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DiaryOfUserHolder extends RecyclerView.ViewHolder {

        TextView textViewAliasReport;
        TextView textViewNameReport;
        ImageView imageViewReports;

        DiaryOfUserHolder(View itemView) {
            super(itemView);
            textViewAliasReport = itemView.findViewById(R.id.textViewAliasReport);
            textViewNameReport = itemView.findViewById(R.id.textViewNameReport);
            imageViewReports = itemView.findViewById(R.id.imageViewReports);

        }

        public void bind(final DiaryOfUserModel diaryOfUserModel, final OnItemClickListener listener) {
            textViewNameReport.setText(diaryOfUserModel.getName());
            textViewAliasReport.setText(diaryOfUserModel.getNameAlias());
            Picasso.get().load(diaryOfUserModel.getImage_()).fit().into(imageViewReports);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(diaryOfUserModel, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DiaryOfUserModel diaryOfUserModel, int position);
    }
}