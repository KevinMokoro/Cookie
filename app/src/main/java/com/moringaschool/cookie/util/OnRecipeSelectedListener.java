package com.moringaschool.cookie.util;

import com.moringaschool.cookie.models.Hit;

import java.util.List;

public interface OnRecipeSelectedListener {
    public void onRecipeSelected(Integer position, List<Hit> recipes);
}
