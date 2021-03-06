package ru.startandroid.develop.firstproject.ui.screens.four;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ru.startandroid.develop.firstproject.R;

public class FragmentPhotos extends Fragment implements PhotosView {
    private PhotosPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.photos_view, container, false);
        presenter = new PhotosPresenter();
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(getContext(), R.raw.meow);
                player.start();
            }
        });

        return  view;

    }
    @Override
    public void onPause() {
        super.onPause();
        presenter.exitFromView();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.enterWithView(this);
    }


    @Override
    public void navigateToPhotos() {

    }

    @Override
    public void navigateToPhoto() {

    }
}

