package id.eudeka.resepmami.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Sample POJO Schema yang dijadikan entitas table DAO
 */
@Entity(tableName = "sample")
public class SampleTable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name = "sample_column")
    private String sampleColumn;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSampleColumn() {
        return sampleColumn;
    }

    public void setSampleColumn(String sampleColumn) {
        this.sampleColumn = sampleColumn;
    }
}
