package com.moringaschool.cookie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findRecipes) Button mFindRecipes;
    @BindView(R.id.ingredientEditText) EditText mIngredientEditText;
    @BindView(R.id.aboutButton) Button mAboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindRecipes.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mFindRecipes) {
            String ingredient = mIngredientEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
            intent.putExtra("ingredient",ingredient);
            startActivity(intent);
        } else if (v == mAboutButton){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }
}