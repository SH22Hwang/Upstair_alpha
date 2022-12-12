package com.cookandroid.upstair_alpha.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<Integer> curSteps;
    private final MutableLiveData<String> curStepsToString;

    private int CUR_STEPS = 0;

    public HomeViewModel() {
        curSteps = new MutableLiveData<>();
        curStepsToString = new MutableLiveData<>();
        curSteps.setValue(0);
    }

    public void incCurSteps() {
        CUR_STEPS++;
        curSteps.setValue(CUR_STEPS);
    }

    public LiveData<Integer> getCurSteps() {
        return curSteps;
    }

    public LiveData<String> getCurStepsToString() {
        curStepsToString.setValue(Integer.toString(CUR_STEPS));
        return curStepsToString;
    }
}