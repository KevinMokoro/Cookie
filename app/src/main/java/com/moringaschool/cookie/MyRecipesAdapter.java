package com.moringaschool.cookie;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRecipesAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;
    private String[] mSources;

    public MyRecipesAdapter(Context mContext, int resource, String[] mRecipes, String[] mSources) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        this.mSources = mSources;
    }

    @Override
    public Object getItem(int position) {
        String recipe = mRecipes[position];
        String source = mSources[position];
        return String.format("Recipe Name: %s \nSource: Person/Hotel:  %s", recipe, source);
    }
    @Override
    public int getCount(){
        return mRecipes.length;
    }

}
