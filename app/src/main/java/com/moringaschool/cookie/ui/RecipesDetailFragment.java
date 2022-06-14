package com.moringaschool.cookie.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.models.Hit;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipesDetailFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.recipeImageView)
    ImageView mImageView;
    @BindView(R.id.recipeNameTextView)
    TextView mNameLabel;
    @BindView(R.id.websiteTextView)
    TextView mWebsiteLabel;
    @BindView(R.id.saveRecipeButton)
    Button mSaveRecipeButton;
    @BindView(R.id.sourceTextView)
    TextView mSourceTextView;

    private Hit mRecipe;


    public RecipesDetailFragment() {

    }


    public static RecipesDetailFragment newInstance(Hit recipe) {
        RecipesDetailFragment recipeDetailFragment = new RecipesDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mRecipe.getRecipe().getImage()).into(mImageView);

        mNameLabel.setText(mRecipe.getRecipe().getLabel());
        mSourceTextView.setText("Source: " + mRecipe.getRecipe().getSource());
        mWebsiteLabel.setOnClickListener(this);

        mSaveRecipeButton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getRecipe().getUrl()));
            startActivity(webIntent);
        } if(v == mSaveRecipeButton) {
            DatabaseReference recipeRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_RECIPES);
            recipeRef.push().setValue(mRecipe);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}