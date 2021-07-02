package com.huahen.navigation.navui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huahen.navigation.R;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class NavUiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_ui, container, false);
            view.findViewById(R.id.btnMenuInActionBar).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navUiFragment_to_menuActivity));
            view.findViewById(R.id.btnDrawerLayout).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navUiFragment_to_drawerLayoutActivity));
            view.findViewById(R.id.btnBottomNavigationBar).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navUiFragment_to_bottomNavigationBarActivity));
        return view;
    }
}
