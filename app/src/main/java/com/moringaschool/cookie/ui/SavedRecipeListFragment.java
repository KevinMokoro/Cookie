package com.moringaschool.cookie.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.moringaschool.cookie.Constants;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.adapters.FirebaseRecipeListAdapter;
import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.util.OnStartDragListener;
import com.moringaschool.cookie.util.SimpleItemTouchHelperCallback;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SavedRecipeListFragment extends Fragment implements OnStartDragListener {


    private DatabaseReference mRecipeReference;
    private FirebaseRecipeListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    public SavedRecipeListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_recipe_list, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPES)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

        FirebaseRecyclerOptions<Hit> options =
                new FirebaseRecyclerOptions.Builder<Hit>()
                        .setQuery(query, Hit.class)
                        .build();

        hideProgressBar();

        mFirebaseAdapter = new FirebaseRecipeListAdapter(options, query,  this, getActivity());


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        mRecyclerView.setHasFixedSize(true);

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                mFirebaseAdapter.notifyDataSetChanged();
            }
        });

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }



    private void showRecipes() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }



}