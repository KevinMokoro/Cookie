package com.moringaschool.cookie.ui;

import static com.moringaschool.cookie.Constants.EDAMAM_API_KEY;
import static com.moringaschool.cookie.Constants.EDAMAM_ID;
import static com.moringaschool.cookie.Constants.SEARCH_TYPE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.cookie.MyRecipesAdapter;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.adapters.RecipeListAdapter;
import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.models.MyEdamamRecipeSearchResponse;
import com.moringaschool.cookie.models.Recipe;
import com.moringaschool.cookie.network.EdamamApi;
import com.moringaschool.cookie.network.EdamamClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
public class RecipesActivity extends AppCompatActivity {
    private static final String TAG = RecipesActivity.class.getSimpleName();
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private RecipeListAdapter mAdapter;
    public List<Hit> recipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");

        EdamamApi client = EdamamClient.getClient();
        Call<MyEdamamRecipeSearchResponse> call = client.getRecipes(SEARCH_TYPE,ingredient,EDAMAM_ID,EDAMAM_API_KEY);

        call.enqueue(new Callback<MyEdamamRecipeSearchResponse>() {
            @Override
            public void onResponse(Call<MyEdamamRecipeSearchResponse> call, Response<MyEdamamRecipeSearchResponse> response) {

                hideProgressBar();

                if (response.isSuccessful()) {
                    recipes = response.body().getHits();
                    mAdapter = new RecipeListAdapter(RecipesActivity.this, recipes);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(RecipesActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

//                    Log.e(TAG,String.valueOf(recipe));
                    showRecipes();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<MyEdamamRecipeSearchResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });


    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRecipes() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }


}