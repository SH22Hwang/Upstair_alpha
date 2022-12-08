package com.cookandroid.upstair_alpha.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

//    private final MutableLiveData<String> mText;
private MutableLiveData<String> curSteps;
private int CUR_STEPS = 0;

    public HomeViewModel() {
        curSteps = new MutableLiveData<>();
        curSteps.setValue(String.valueOf(CUR_STEPS));
    }

    public LiveData<String> getText() {
        return curSteps;
    }

    public void incCurSteps() {
        CUR_STEPS++;
    }
}