/* 만들거
 * 걸음 수마다 버튼 색깔 바꾸기 + 누를 수 있게
 * 걸음 수에 프로그레스 바 연동
 *
 * */

package com.cookandroid.upstair_alpha.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cookandroid.upstair_alpha.R;
import com.cookandroid.upstair_alpha.databinding.FragmentHomeBinding;
import com.cookandroid.upstair_alpha.ui.Coin.CoinViewModel;

public class HomeFragment extends Fragment {

    private final double C1000 = 0.01;
    private final double C5000 = 0.02;
    private final double C10000 = 0.05;

    private FragmentHomeBinding binding;
    HomeViewModel homeViewModel;
    CoinViewModel coinViewModel;

    Button btnGet1000, btnGet5000, btnGet10000;
    ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        coinViewModel = new ViewModelProvider(this).get(CoinViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        progressBar = binding.progressStair;
        progressBar.setProgress(Integer.parseInt(String.valueOf(homeViewModel.getCurSteps())));
        homeViewModel.getCurSteps().observe(getViewLifecycleOwner(), progressBar::setProgress);

        btnGet1000 = binding.btnGet1000;
        btnGet1000.setClickable(false);

        btnGet5000 = binding.btnGet5000;
        btnGet5000.setClickable(false);

        btnGet10000 = binding.btnGet10000;
        btnGet10000.setClickable(false);

        TextView textCurSteps = binding.textCurSteps;
        homeViewModel.getCurStepsToString().observe(getViewLifecycleOwner(), textCurSteps::setText);

        if (Integer.parseInt(String.valueOf(homeViewModel.getCurSteps())) >= 1000)
            btnGet1000.setClickable(true);
        if (Integer.parseInt(String.valueOf(homeViewModel.getCurSteps())) >= 5000)
            btnGet5000.setClickable(true);
        if (Integer.parseInt(String.valueOf(homeViewModel.getCurSteps())) >= 10000)
            btnGet10000.setClickable(true);

        btnGet1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGet1000.setBackgroundColor(Color.GRAY);
                btnGet1000.setClickable(false);
                coinViewModel.incCoin(C1000);
            }
        });

        btnGet5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGet5000.setBackgroundColor(Color.GRAY);
                btnGet5000.setClickable(false);
                coinViewModel.incCoin(C5000);
            }
        });

        btnGet10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGet10000.setBackgroundColor(Color.GRAY);
                btnGet10000.setClickable(false);
                coinViewModel.incCoin(C10000);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}