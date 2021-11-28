package io.github.xmu_android_basics.bmiapp_2021;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BmiRepo {

    ExecutorService taskExecutor = Executors.newFixedThreadPool(4);
    private LiveData<List<BmiRecord>> allRecords;

    private BmiDao dao;


    public BmiRepo(Application application) {
        BmiDatabase db = BmiDatabase.getDatabase(application);
        dao = db.bmiDao();
        allRecords = dao.getAllBmiRecords();
    }


    public LiveData<List<BmiRecord>> getAllBmiRecords() {
        return allRecords;
    }

    public void insert(BmiRecord bmi) {
        taskExecutor.execute(() -> {
            dao.insert(bmi);
        });
    }
}
