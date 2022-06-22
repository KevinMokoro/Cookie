package com.moringaschool.cookie.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.ui.RecipesDetailFragment;

import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private List<Hit> mRecipes;
    private String mSource;

    public RecipePagerAdapter (@NonNull FragmentManager fm, int behavior, List<Hit> recipes, String source) {
        super(fm, behavior);
        mRecipes = recipes;
        mSource = source;
    }

    @Override
    public RecipesDetailFragment getItem(int position) {
        return RecipesDetailFragment.newInstance(mRecipes, position, mSource);
    }

    @Override
    public int getCount (){
        return mRecipes.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mRecipes.get(position).getRecipe().getLabel();
    }


}
