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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }
}