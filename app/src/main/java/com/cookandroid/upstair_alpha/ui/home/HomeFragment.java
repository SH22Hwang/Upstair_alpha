package com.cookandroid.upstair_alpha.ui.home;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cookandroid.upstair_alpha.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        // 센서 정보 받기 위해 센서 리스너 객체 생성
        SensorEventListener mListener = new SensorEventListener() { // tlqkf 이걸 어떻게 알아 리스너 등록 해야함
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                // 걸음 센서 이벤트 발생시
                if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
                    if (sensorEvent.values[0] == 1.0f) {
                        // 센서 이벤트 발생, 걸음 수 증가
                        homeViewModel.incCurSteps();
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
                // ?
            }
        };

        final TextView textCurSteps = binding.textCurSteps;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textCurSteps::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}