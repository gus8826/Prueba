package com.example.prueba.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.Models.ItemData;
import com.example.prueba.R;

import java.util.ArrayList;
import java.util.List;

public class CellItemReportsAdapter extends RecyclerView.Adapter<CellItemReportsAdapter.ViewReports> {

    private Activity activity;
    private List<ItemData> list;
    private LayoutInflater inflater;

    public CellItemReportsAdapter(Activity activity, ArrayList<ItemData> list) {
        this.activity = activity;
        this.list = list;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public CellItemReportsAdapter.ViewReports onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cell_item_reports_adapter, parent, false);
        return new ViewReports(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CellItemReportsAdapter.ViewReports viewCategory, @SuppressLint("RecyclerView") final int position) {
        viewCategory.textViewAliasReport.setText(list.get(position).getNameAlias());
        viewCategory.textViewNameReport.setText(list.get(position).getName());
        viewCategory.imageViewReports.setImageResource(list.get(position).getImage_());
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
    }
}