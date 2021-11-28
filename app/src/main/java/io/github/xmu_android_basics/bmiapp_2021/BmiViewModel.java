package io.github.xmu_android_basics.bmiapp_2021;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class BmiViewModel extends AndroidViewModel {

    private BmiRepo bmiRepo;

    private final LiveData<List<BmiRecord>> _bmiRecordsData;

    public BmiViewModel(@NonNull Application application) {
        super(application);
        bmiRepo = new BmiRepo(application);
        _bmiRecordsData = bmiRepo.getAllBmiRecords();
    }

    public LiveData<List<BmiRecord>> getBmiRecord() {
        return _bmiRecordsData;
    }

    public void addBmiRecord(BmiRecord bmi) {
        bmiRepo.insert(bmi);
    }
}
