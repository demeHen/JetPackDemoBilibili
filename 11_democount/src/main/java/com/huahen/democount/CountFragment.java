package com.huahen.democount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huahen.democount.databinding.FragmentCountBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountFragment extends Fragment {

    public CountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentCountBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_count, container, false);
        // Inflate the layout for this fragment
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());
        binding.btnCountPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewModel.pushTipStr()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("number", myViewModel.getNumber().getValue());
                    Navigation.findNavController(v).navigate(R.id.action_countFragment_to_endFragment, bundle);
                }
            }
        });
        return binding.getRoot();
    }


}
