package com.example.prueba.Agenda.UI.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.prueba.Agenda.UI.Adapters.UsersAdapter;
import com.example.prueba.Agenda.Models.Users;
import com.example.prueba.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DiaryOfUserActivity extends AppCompatActivity {

    private List<Users> user;
    private RecyclerView recyclerViewReports;
    private LinearLayoutManager linearLayoutManager;
    private UsersAdapter usersAdapter;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_of_users);

        user = this.getListUser();

        recyclerViewReports = findViewById(R.id.recyclerViewReports);
        linearLayoutManager = new LinearLayoutManager(this);

        usersAdapter = new UsersAdapter(user, R.layout.cell_item_reports_adapter, this, new UsersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Users itemData, int position) {
                Toast.makeText(DiaryOfUserActivity.this, "click en: " + itemData.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewReports.setHasFixedSize(true);
        recyclerViewReports.setItemAnimator(new DefaultItemAnimator());

        recyclerViewReports.setLayoutManager(linearLayoutManager);
        recyclerViewReports.setAdapter(usersAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_fruit:
                int position = user.size();
                user.add(position, new Users("" + (++counter), "usuario" + (++counter), "alias", R.drawable.ic_launcher_background));
                usersAdapter.notifyItemInserted(position);
                linearLayoutManager.scrollToPosition(position);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private List<Users> getListUser() {
        return new ArrayList<Users>() {{
            add(new Users("0", "ALejandro", "alex", R.drawable.image_1));
            add(new Users("1", "Jesús", "jisus", R.drawable.image_2));
            add(new Users("2", "Erik", "rick", R.drawable.image_3));
            add(new Users("3", "Ricardo", "richar", R.drawable.image_4));
            add(new Users("4", "Diego", "xD", R.drawable.image_1));
            add(new Users("5", "Sofia", "sofy", R.drawable.image_3));
            add(new Users("6", "Quetzalli", "quetzal", R.drawable.image_4));
            add(new Users("7", "Martha", "mars", R.drawable.image_1));
            add(new Users("8", "Adriana", "adris", R.drawable.image_2));
            add(new Users("9", "Ana", "anita", R.drawable.image_3));
        }};
    }

    private void addUser(int position) {
        user.add(position, new Users("" + (++counter), "usuario" + (++counter), "alias", R.drawable.ic_launcher_background));
        usersAdapter.notifyItemInserted(position);
        linearLayoutManager.scrollToPosition(position);
    }

    private void removeUser(int position) {
        user.remove(position);
        usersAdapter.notifyItemRemoved(position);
    }

}