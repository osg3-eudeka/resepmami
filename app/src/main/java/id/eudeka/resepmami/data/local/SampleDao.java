package id.eudeka.resepmami.data.local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import id.eudeka.resepmami.model.SampleTable;

@Dao
public interface SampleDao {
    @Query("SELECT * FROM sample")
    List<SampleTable> getSample();

    @Insert
    void insertSample(List<SampleTable> data);
}
