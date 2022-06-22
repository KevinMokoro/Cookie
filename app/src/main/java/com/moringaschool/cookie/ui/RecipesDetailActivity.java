package com.moringaschool.cookie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.adapters.RecipePagerAdapter;
import com.moringaschool.cookie.models.Hit;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;

    private RecipePagerAdapter adapterViewPager;

    List<Hit> mRecipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_detail);
        ButterKnife.bind(this);


        mRecipes = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_KEY_RECIPES));
        int startingPosition = getIntent().getIntExtra(Constants.EXTRA_KEY_POSITION, 0);


        adapterViewPager = new RecipePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mRecipes);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}