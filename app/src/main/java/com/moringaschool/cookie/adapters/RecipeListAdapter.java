package com.moringaschool.cookie.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.models.Recipe;
import com.moringaschool.cookie.ui.RecipesDetailActivity;
import com.moringaschool.cookie.ui.RecipesDetailFragment;
import com.moringaschool.cookie.util.OnRecipeSelectedListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    private OnRecipeSelectedListener mOnRecipeSelectedListener;
    private List<Hit> mRecipes;
    private Context mContext;


    public RecipeListAdapter(Context context, List<Hit> recipes, OnRecipeSelectedListener recipeSelectedListener) {
        mContext = context;
        mRecipes = recipes;
        mOnRecipeSelectedListener = recipeSelectedListener;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view, mRecipes, mOnRecipeSelectedListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.bindRecipe(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mNameTextView;


        private Context mContext;
        private int mOrientation;
        private OnRecipeSelectedListener mRecipeSelectedListener;
        private List<Hit> mRecipes;

        public RecipeViewHolder(View itemView, List<Hit> recipes, OnRecipeSelectedListener recipeSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            mOrientation = itemView.getResources().getConfiguration().orientation;
            mRecipes = recipes;
            mRecipeSelectedListener = recipeSelectedListener;

            if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                createDetailFragment(0);
            }
            itemView.setOnClickListener(this);
        }

        private void createDetailFragment(int position) {
            RecipesDetailFragment detailFragment = RecipesDetailFragment.newInstance(mRecipes, position, Constants.SOURCE_FIND);
            FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.recipeDetailContainer, detailFragment);
            ft.commit();
        }

        public void bindRecipe(Hit recipe) {
            Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);
            mNameTextView.setText(recipe.getRecipe().getLabel());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            mRecipeSelectedListener.onRecipeSelected(itemPosition, mRecipes, Constants.SOURCE_FIND);
            if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                createDetailFragment(itemPosition);
            } else {
                Intent intent = new Intent(mContext, RecipesDetailActivity.class);
                intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
                intent.putExtra(Constants.EXTRA_KEY_RECIPES, Parcels.wrap(mRecipes));
                intent.putExtra(Constants.KEY_SOURCE, Constants.SOURCE_FIND);
                mContext.startActivity(intent);
            }
        }
    }
}

