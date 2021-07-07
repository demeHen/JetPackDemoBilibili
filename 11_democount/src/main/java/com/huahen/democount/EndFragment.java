package com.huahen.democount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huahen.democount.databinding.FragmentEndBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


/**
 * A simple {@link Fragment} subclass.
 */
public class EndFragment extends Fragment {

    public EndFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentEndBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_end, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());
        //写到这里，差不多意识到我应该理解错了viewModel的定义，在vm层加了太多逻辑。所以马上结束自己的项目。准备去看视频
        int number = 0;
        if (getArguments() != null) {
            number = getArguments().getInt("number");
        }
        if (number >= 10) {
            binding.imageView2.setImageResource(R.drawable.ic_mood_black_24dp);
            binding.tvResult.setText(getActivity().getString(R.string.challenge_result_success));
            if (number > myViewModel.getHighNumber().getValue()) {
                binding.tvTip.setText(getActivity().getString(R.string.tip_push) + number);
            } else {
                binding.tvTip.setText(getActivity().getString(R.string.tip_count) + number);
            }
        } else {
            binding.imageView2.setImageResource(R.drawable.ic_mood_bad_black_24dp);
            binding.tvResult.setText(getActivity().getString(R.string.challenge_result_fail));
            binding.tvTip.setText(getActivity().getString(R.string.tip_count) +number);
        }

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
