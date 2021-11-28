package io.github.xmu_android_basics.bmiapp_2021;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bmi_record")
public class BmiRecord {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "timestamp")
    public String timestamp;

    @NonNull
    @ColumnInfo(name = "weight")
    public double weight;

    @NonNull
    @ColumnInfo(name = "bmi_value")
    public double bmi;

    public BmiRecord(double weight, double bmi) {
        this.weight = weight;
        this.bmi = bmi;
        this.timestamp = String.valueOf(System.currentTimeMillis());


    }

    @Ignore
    public int type;

    public void setType(@Type int type) {
        this.type = type;
    }

    @IntDef({Type.NORMAL, Type.FEMALE, Type.CHILD})
    public @interface Type{
        int NORMAL = 1;
        int FEMALE = 2;
        int CHILD = 3;
    }
}
