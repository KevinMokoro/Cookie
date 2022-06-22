package com.moringaschool.cookie.ui;

import static com.moringaschool.cookie.Constants.EDAMAM_API_KEY;
import static com.moringaschool.cookie.Constants.EDAMAM_ID;
import static com.moringaschool.cookie.Constants.SEARCH_TYPE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import com.moringaschool.cookie.util.OnRecipeSelectedListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;

import org.parceler.Parcels;

public class RecipesListActivity extends AppCompatActivity implements OnRecipeSelectedListener {
    private Integer mPosition;
    List<Hit> mRecipes;
    String mSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        if (savedInstanceState != null) {

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                mPosition = savedInstanceState.getInt(Constants.EXTRA_KEY_POSITION);
                mRecipes = Parcels.unwrap(savedInstanceState.getParcelable(Constants.EXTRA_KEY_RECIPES));
                mSource = savedInstanceState.getString(Constants.KEY_SOURCE);

                if (mPosition != null && mRecipes != null) {
                    Intent intent = new Intent(this, RecipesDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                    intent.putExtra(Constants.EXTRA_KEY_RECIPES, Parcels.wrap(mRecipes));
                    intent.putExtra(Constants.KEY_SOURCE, mSource);
                    startActivity(intent);
                }

            }

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mPosition != null && mRecipes != null) {
            outState.putInt(Constants.EXTRA_KEY_POSITION, mPosition);
            outState.putParcelable(Constants.EXTRA_KEY_RECIPES, Parcels.wrap(mRecipes));
            outState.putString(Constants.KEY_SOURCE, mSource);
        }

    }

    @Override
    public void onRecipeSelected(Integer position, List<Hit> recipes, String source) {
        mPosition = position;
        mRecipes = recipes;
        mSource = source;
    }
}