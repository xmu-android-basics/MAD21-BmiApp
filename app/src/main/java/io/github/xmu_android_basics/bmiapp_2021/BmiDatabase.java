package io.github.xmu_android_basics.bmiapp_2021;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BmiRecord.class}, version = 1)
public abstract class BmiDatabase extends RoomDatabase {

    private static volatile BmiDatabase INSTANCE;

    public static BmiDatabase getDatabase(Application application) {
        if (null == INSTANCE) {
            synchronized (BmiDatabase.class) {
                if (null == INSTANCE) {
                    INSTANCE =
                    Room.databaseBuilder(application,
                            BmiDatabase.class, "bmi_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract BmiDao bmiDao();
}
