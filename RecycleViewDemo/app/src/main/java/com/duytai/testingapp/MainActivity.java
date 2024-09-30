package com.duytai.testingapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;

    List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        items.add(new Item(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "name1"));
        items.add(new Item(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "name2"));
        items.add(new Item(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "name3"));
        items.add(new Item(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "name4"));

        rvMain = (RecyclerView) findViewById(R.id.rv_main);
        rvMain.setAdapter(new ItemAdapter(items));
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }
}