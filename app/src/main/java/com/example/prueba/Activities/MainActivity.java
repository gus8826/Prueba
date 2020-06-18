package com.example.prueba.Activities;

import android.os.Bundle;
import android.widget.Toast;

import com.example.prueba.Adapters.CellItemReportsAdapter;
import com.example.prueba.ArrayExample;
import com.example.prueba.Models.ItemData;
import com.example.prueba.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ItemData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewReports = findViewById(R.id.recyclerViewReports);

        llenarLista();

        CellItemReportsAdapter cellItemReportsAdapter = new CellItemReportsAdapter(data, R.layout.cell_item_reports_adapter, new CellItemReportsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemData itemData, int position) {
                Toast.makeText(MainActivity.this, "click en: "+ itemData.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewReports.setHasFixedSize(true);
        recyclerViewReports.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewReports.setAdapter(cellItemReportsAdapter);

    }

    public void llenarLista() {
        data = new ArrayList<>();
        for (int i = 0; i < ArrayExample.idReports.length; i++) {
            data.add(new ItemData(
                    ArrayExample.idReports[i],
                    ArrayExample.nameReports[i],
                    ArrayExample.nameAlias[i],
                    ArrayExample.imagenReports[i]
            ));
        }
    }
}