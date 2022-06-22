package com.moringaschool.cookie.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.ui.RecipesDetailFragment;

import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private List<Hit> mRecipes;

    public RecipePagerAdapter (@NonNull FragmentManager fm, int behavior, List<Hit> recipes) {
        super(fm, behavior);
        mRecipes = recipes;
    }

    @Override
    public RecipesDetailFragment getItem(int position) {
        return RecipesDetailFragment.newInstance(mRecipes, position);
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
