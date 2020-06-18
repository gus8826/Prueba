package com.example.prueba.Agenda.UI.Activities;

import android.os.Bundle;

import com.example.prueba.Agenda.UI.Adapters.DiaryOfUserAdapter;
import com.example.prueba.ArrayExample;
import com.example.prueba.Agenda.Models.DiaryOfUserModel;
import com.example.prueba.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiaryOfUserActivity extends AppCompatActivity {

    private ArrayList<DiaryOfUserModel> data;
    private RecyclerView recyclerViewReports;
    private LinearLayoutManager linearLayoutManager;
    private DiaryOfUserAdapter diaryOfUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_of_users);

        recyclerViewReports = findViewById(R.id.recyclerViewReports);

        llenarLista();

        /*diaryOfUserAdapter = new DiaryOfUserAdapter(data, R.layout.cell_item_reports_adapter, new DiaryOfUserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DiaryOfUserModel itemData, int position) {
                Toast.makeText(DiaryOfUserActivity.this, "click en: " + itemData.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/
        recyclerViewReports.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewReports.setLayoutManager(linearLayoutManager);
        recyclerViewReports.setAdapter(diaryOfUserAdapter);

    }

    public void llenarLista() {
        data = new ArrayList<>();
        for (int i = 0; i < ArrayExample.idReports.length; i++) {
            data.add(new DiaryOfUserModel(
                    ArrayExample.idReports[i],
                    ArrayExample.nameReports[i],
                    ArrayExample.nameAlias[i],
                    ArrayExample.imagenReports[i]
            ));
        }
    }
}