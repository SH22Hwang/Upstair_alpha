/* 만들 거
 * 이미지 누르면 카메라 실행 및 업로드
 * 글쓰고 작성
 * 캘린더
 * */

package com.cookandroid.upstair_alpha.ui.Management;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cookandroid.upstair_alpha.databinding.FragmentManagementBinding;

public class ManagementFragment extends Fragment {

    private FragmentManagementBinding binding;

    Button btnCalendar, btnWrite;
    DatePicker datePicker;
    ImageView imageView;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ManagementViewModel managementViewModel =
                new ViewModelProvider(this).get(ManagementViewModel.class);

        binding = FragmentManagementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}