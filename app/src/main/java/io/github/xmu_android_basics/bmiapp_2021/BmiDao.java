package io.github.xmu_android_basics.bmiapp_2021;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BmiDao {

    @Query("SELECT * FROM bmi_record ORDER BY timestamp DESC")
    LiveData<List<BmiRecord>> getAllBmiRecords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(BmiRecord record);

    @Query("DELETE FROM bmi_record")
    void deleteAll();

}
