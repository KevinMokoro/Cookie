package com.moringaschool.cookie.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.findRecipes) Button mFindRecipes;
    @BindView(R.id.aboutButton) Button mAboutButton;
    @BindView(R.id.savedRecipesButton) Button mSavedRecipesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindRecipes.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
        mSavedRecipesButton.setOnClickListener(this);




    }
    @Override
    public void onClick(View v){
        if(v == mFindRecipes) {
            Intent intent = new Intent(MainActivity.this, RecipesListActivity.class);
            startActivity(intent);
        } if (v == mAboutButton){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }if (v == mSavedRecipesButton) {
            Intent intent = new Intent(MainActivity.this, SavedRecipeListActivity.class);
            startActivity(intent);
        }
    }
}