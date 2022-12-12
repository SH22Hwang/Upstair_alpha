/* 만들 거
* 코인은 포기
* */


package com.cookandroid.upstair_alpha.ui.Coin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cookandroid.upstair_alpha.databinding.FragmentCoinBinding;

public class CoinFragment extends Fragment {

    private FragmentCoinBinding binding;
    TextView textHoldingCoin;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoinViewModel coinViewModel =
                new ViewModelProvider(this).get(CoinViewModel.class);

        binding = FragmentCoinBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textHoldingCoin = binding.textHoldingCoin;
        coinViewModel.getCurCoinToString().observe(getViewLifecycleOwner(), textHoldingCoin::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}