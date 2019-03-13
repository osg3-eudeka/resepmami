package id.eudeka.resepmami.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import id.eudeka.resepmami.model.SampleTable;

@Database(entities = {SampleTable.class}, version = 1)
public abstract class ResepMamiDatabase extends RoomDatabase {
    private static ResepMamiDatabase INSTANCE = null;

    static ResepMamiDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ResepMamiDatabase.class) {
                INSTANCE = Room.databaseBuilder(context, ResepMamiDatabase.class, "resepmami.db").build();
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    abstract SampleDao sampleDao();
}
