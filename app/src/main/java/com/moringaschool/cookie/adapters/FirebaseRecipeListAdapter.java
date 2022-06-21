package com.moringaschool.cookie.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.moringaschool.cookie.R;
import com.moringaschool.cookie.models.Hit;
import com.moringaschool.cookie.util.ItemTouchHelperAdapter;
import com.moringaschool.cookie.util.OnStartDragListener;

public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<Hit, FirebaseRecipeViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;



    public FirebaseRecipeListAdapter(FirebaseRecyclerOptions<Hit> options,
                                     DatabaseReference ref,
                                     OnStartDragListener onStartDragListener,
                                     Context context){
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder firebaseRecipeViewHolder, int position, @NonNull Hit recipe) {
        firebaseRecipeViewHolder.bindRecipe(recipe);
        firebaseRecipeViewHolder.mRecipeImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(firebaseRecipeViewHolder);
                }
                return false;
            }
        });
    }

    @NonNull
    @Override
    public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_drag, parent, false);
        return new FirebaseRecipeViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        return false;
    }

    @Override
    public void onItemDismiss(int position){

    }

}