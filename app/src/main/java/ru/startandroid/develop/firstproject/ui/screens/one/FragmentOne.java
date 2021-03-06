package ru.startandroid.develop.firstproject.ui.screens.one;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.startandroid.develop.firstproject.R;
import ru.startandroid.develop.firstproject.ui.screens.two.FragmentTwo;

public class FragmentOne extends Fragment  implements  OneView{

    OnePresenter presenter;

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_one, container, false);
        presenter = new  OnePresenter();
        final Button loginB = view.findViewById(R.id.loginButton);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_) {
                EditText number = view.findViewById(R.id.phoneNumberET);
                String field1 = number.getText().toString();
                EditText number2 = view.findViewById(R.id.passwordET);
                String field2 = number2.getText().toString();

                presenter.onLoginButtonClicked(field1, field2);
            }
        });
        return view;
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
    public void onNavigateToTwo() {
        Fragment fragment = FragmentTwo.newInstance();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.mainContainer,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onCredentialsWrong() {
        Toast.makeText(getActivity(), "МЕНЕ ПІДСТАВИЛИ", Toast.LENGTH_LONG).show();
    }


    @Override
    public void navigateToPhoto() {

    }
}