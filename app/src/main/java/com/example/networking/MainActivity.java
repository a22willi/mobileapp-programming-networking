package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask( this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountains = gson.fromJson(json, type);

        for (Mountain m : listOfMountains) {
            Log.d("mountain", m.toString());
        }

        RecyclerView recyclerView = findViewById(R.id.mountainRecyclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, listOfMountains);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.notifyDataSetChanged();
    }
}
