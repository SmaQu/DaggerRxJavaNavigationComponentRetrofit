package com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alastor.daggerrxjavanavigationcomponentretrofit.R;
import com.alastor.daggerrxjavanavigationcomponentretrofit.util.VerticalSpacingItemDecoration;
import com.alastor.daggerrxjavanavigationcomponentretrofit.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    private PostsViewModel postsViewModel;
    private RecyclerView recyclerView;

    @Inject
    VerticalSpacingItemDecoration verticalSpacingItemDecoration;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    PostsRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        postsViewModel = new ViewModelProvider(this, providerFactory).get(PostsViewModel.class);

        initRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers() {
        postsViewModel.observePosts().removeObservers(getViewLifecycleOwner());
        postsViewModel.observePosts().observe(getViewLifecycleOwner(), listResource -> {
            if (listResource != null) {
                switch (listResource.status) {
                    case LOADING:
                        Log.d(TAG, "subscribeObservers: LOADING...");
                        break;

                    case SUCCESS:
                        Log.d(TAG, "subscribeObservers: got posts...");
                        adapter.setPosts(listResource.data);
                        break;

                    case ERROR:
                        Log.e(TAG, "subscribeObservers: ERROR..." + listResource.message);
                        break;
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(verticalSpacingItemDecoration);
        recyclerView.setAdapter(adapter);
    }
}


