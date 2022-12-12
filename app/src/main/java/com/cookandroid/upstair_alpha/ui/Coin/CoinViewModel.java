package com.cookandroid.upstair_alpha.ui.Coin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CoinViewModel extends ViewModel {

    private final MutableLiveData<Double> curCoin;
    private final MutableLiveData<String> curCoinToString;

    private double COIN = 0.0;

    public CoinViewModel() {
        curCoin = new MutableLiveData<>();
        curCoinToString = new MutableLiveData<>();
        curCoin.setValue(0.0);
    }

    public void incCoin(double c) {
        COIN += c;
        curCoin.setValue(COIN);
    }

    public LiveData<Double> getCurCoin() {
        return curCoin;
    }

    public LiveData<String> getCurCoinToString() {
        curCoinToString.setValue(Double.toString(COIN));
        return curCoinToString;
    }

}