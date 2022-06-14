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


  //  private DatabaseReference mSearchedRecipeReference;

    @BindView(R.id.findRecipes) Button mFindRecipes;
    @BindView(R.id.ingredientEditText) EditText mIngredientEditText;
    @BindView(R.id.aboutButton) Button mAboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

      //  mSearchedRecipeReference = FirebaseDatabase
      //          .getInstance()
       //         .getReference()
      //          .child(Constants.FIREBASE_CHILD_SEARCHED_RECIPE);

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

         //   saveRecipeToFirebase(ingredient);

            Intent intent = new Intent(MainActivity.this, RecipesListActivity.class);
            intent.putExtra("ingredient",ingredient);
            startActivity(intent);
        } else if (v == mAboutButton){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }
  //  public void saveRecipeToFirebase(String recipe) {
  //      mSearchedRecipeReference.setValue(recipe);
 //   }
}