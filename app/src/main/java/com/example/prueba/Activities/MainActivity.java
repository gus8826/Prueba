package com.example.prueba.Activities;

import android.os.Bundle;

import com.example.prueba.Adapters.CellItemReportsAdapter;
import com.example.prueba.ArrayExample;
import com.example.prueba.Models.ItemData;
import com.example.prueba.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ItemData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewReports = findViewById(R.id.recyclerViewReports);
        recyclerViewReports.setHasFixedSize(true);
        recyclerViewReports.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();

        CellItemReportsAdapter cellItemReportsAdapter = new CellItemReportsAdapter(this, data);
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