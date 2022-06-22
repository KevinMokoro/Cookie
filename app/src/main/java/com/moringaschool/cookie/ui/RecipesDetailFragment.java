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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.models.Hit;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

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
    private List<Hit> mRecipes;
    private int mPosition;
    private String mSource;


    public RecipesDetailFragment() {

    }


    public static RecipesDetailFragment newInstance(List<Hit> recipe, Integer position, String source) {
        RecipesDetailFragment recipeDetailFragment = new RecipesDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.EXTRA_KEY_RECIPES, Parcels.wrap(recipe));
        args.putInt(Constants.EXTRA_KEY_POSITION, position);
        args.putString(Constants.KEY_SOURCE, source);
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mRecipes = Parcels.unwrap(getArguments().getParcelable(Constants.EXTRA_KEY_RECIPES));
        mPosition = getArguments().getInt(Constants.EXTRA_KEY_POSITION);
        mRecipe = mRecipes.get(mPosition);
        mSource = getArguments().getString(Constants.KEY_SOURCE);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mRecipe.getRecipe().getImage()).into(mImageView);

        mNameLabel.setText(mRecipe.getRecipe().getLabel());
        mSourceTextView.setText("Source: " + mRecipe.getRecipe().getSource());
        mWebsiteLabel.setOnClickListener(this);

        if(mSource.equals(Constants.SOURCE_SAVED)) {
            mSaveRecipeButton.setVisibility(View.GONE);
        } else {
            mSaveRecipeButton.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getRecipe().getUrl()));
            startActivity(webIntent);
        } if(v == mSaveRecipeButton) {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference recipeRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_RECIPES)
                            .child(uid);

            DatabaseReference pushRef = recipeRef.push();
            String pushId = pushRef.getKey();
            mRecipe.setPushId(pushId);
            pushRef.setValue(mRecipe);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}