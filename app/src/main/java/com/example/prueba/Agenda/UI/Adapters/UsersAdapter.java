package com.example.prueba.Agenda.UI.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Agenda.Models.Users;
import com.example.prueba.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.DiaryOfUserHolder> {

    private List<Users> list;
    private int layout;
    private OnItemClickListener itemClickListener;

    public UsersAdapter(List<Users> list, int layout, OnItemClickListener listener) {
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

        public void bind(final Users users, final OnItemClickListener listener) {
            textViewNameReport.setText(users.getName());
            textViewAliasReport.setText(users.getNameAlias());
            Picasso.get().load(users.getImage_()).fit().into(imageViewReports);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(users, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Users users, int position);
    }
}