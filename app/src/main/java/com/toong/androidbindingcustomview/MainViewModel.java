package com.toong.androidbindingcustomview;

import android.databinding.BaseObservable;
import android.util.Log;

/**
 * Created by PhanVanLinh on 18/07/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class MainViewModel extends BaseObservable {

    public void viewModelListenerMethod(int number) {
        Log.i("MainViewModel", "viewModelListenerMethod");
    }
}
