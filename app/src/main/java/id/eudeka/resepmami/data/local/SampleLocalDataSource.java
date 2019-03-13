package id.eudeka.resepmami.data.local;

import android.content.Context;

import java.util.List;

import id.eudeka.resepmami.data.SampleDataSource;
import id.eudeka.resepmami.model.SampleTable;

public class SampleLocalDataSource implements SampleDataSource {
    private SampleDao sampleDao;

    public SampleLocalDataSource(Context context) {
        sampleDao = ResepMamiDatabase.getInstance(context).sampleDao();
    }

    @Override
    public void getListSample(final GetSampleCallback getSampleCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (sampleDao != null) {
                    if (sampleDao.getSample().isEmpty()) {
                        getSampleCallback.onDataSampleNotAvailable("Data in DB empty!");
                    } else {
                        getSampleCallback.onSampleLoaded(sampleDao.getSample());
                    }
                }
            }
        }).start();
    }

    public void saveDataSample(final List<SampleTable> data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (sampleDao != null) {
                    sampleDao.insertSample(data);
                }
            }
        }).start();
    }
}
