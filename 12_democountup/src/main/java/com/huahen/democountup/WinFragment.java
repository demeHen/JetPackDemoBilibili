package com.huahen.democountup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huahen.democountup.databinding.FragmentWinBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class WinFragment extends Fragment {

    public WinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        FragmentWinBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_win,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_winFragment_to_titleFragment);
            }
        });
        return binding.getRoot();
    }
}
