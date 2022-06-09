package com.moringaschool.cookie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    @BindView(R.id.recipesTextView) TextView mRecipesTextView;
    @BindView(R.id.listView) ListView mListView;
    String [] recipes = new String[] {"ugali", "nyama", "mala", "githeri", "mchele", "omena",
    "mayai", "chai", "maziwa", "wali", "pizza", "yoo", "juice", "matoke"};

    String [] sources = new String[] {"kin", "els", "per", "elna", "JAK", "chr", "sim",
    "sab", "sai", "GEO", "ole", "omu", "tankua", "wakesho"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        MyRecipesAdapter adapter = new MyRecipesAdapter(this, android.R.layout.simple_list_item_1, recipes, sources);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long l) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(RecipesActivity.this, recipe, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        mRecipesTextView.setText("Here are recipes that match your entry: " + ingredient);

    }

}