package com.moringaschool.cookie.ui;

import static com.moringaschool.cookie.Constants.EDAMAM_API_KEY;
import static com.moringaschool.cookie.Constants.EDAMAM_ID;
import static com.moringaschool.cookie.Constants.SEARCH_TYPE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.adapters.RecipeListAdapter;
import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.models.MyEdamamRecipeSearchResponse;
import com.moringaschool.cookie.network.EdamamApi;
import com.moringaschool.cookie.network.EdamamClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
public class RecipesListActivity extends AppCompatActivity {
//
//    private static final String TAG = RecipesListActivity.class.getSimpleName();
//
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;
//    private String mRecentRecipe;
//
//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
//    @BindView(R.id.errorTextView) TextView mErrorTextView;
//    @BindView(R.id.progressBar) ProgressBar mProgressBar;
//
//    private RecipeListAdapter mAdapter;
//    public List<Hit> recipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    //    ButterKnife.bind(this);


      //  Intent intent = getIntent();
    //    String ingredient = intent.getStringExtra("ingredient");

//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentRecipe = mSharedPreferences.getString(Constants.PREFERENCES_RECIPE_KEY, null);
//
//        if(mRecentRecipe != null){
//            fetchRecipes(mRecentRecipe);
//        }
    }

//
//    private void addToSharedPreferences(String recipe) {
//        mEditor.putString(Constants.PREFERENCES_RECIPE_KEY, recipe).apply();
//    }
//



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        ButterKnife.bind(this);
//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String recipe) {
//                addToSharedPreferences(recipe);
//                fetchRecipes(recipe);
//                return false;
//            }
//
//
//            @Override
//            public boolean onQueryTextChange(String recipe) {
//                return false;
//            }
//        });
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }

//    private void fetchRecipes( String recipe ) {
//
//        EdamamApi client = EdamamClient.getClient();
//        Call<MyEdamamRecipeSearchResponse> call = client.getRecipes(SEARCH_TYPE,recipe,EDAMAM_ID,EDAMAM_API_KEY);
//
//        call.enqueue(new Callback<MyEdamamRecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<MyEdamamRecipeSearchResponse> call, Response<MyEdamamRecipeSearchResponse> response) {
//
//                hideProgressBar();
//
//                if (true) {
//                    recipes = response.body().getHits();
//                    RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(RecipesListActivity.this);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setHasFixedSize(true);
//                    mAdapter = new RecipeListAdapter(RecipesListActivity.this, recipes);
//                    mRecyclerView.setAdapter(mAdapter);
//
//
//
//                    showRecipes();
//                } else {
//                    showUnsuccessfulMessage();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MyEdamamRecipeSearchResponse> call, Throwable t) {
//                Log.e("fail",t.getMessage());
//                hideProgressBar();
//                showFailureMessage();
//            }
//
//        });
//
//
//
//
//    }


//
//    private void showFailureMessage() {
//        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showUnsuccessfulMessage() {
//        mErrorTextView.setText("Something went wrong. Please try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showRecipes() {
//        mRecyclerView.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }


}