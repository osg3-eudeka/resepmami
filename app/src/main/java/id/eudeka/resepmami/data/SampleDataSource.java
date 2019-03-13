package id.eudeka.resepmami.data;

import java.util.List;

import id.eudeka.resepmami.model.SampleTable;

public interface SampleDataSource {
    void getListSample(GetSampleCallback getSampleCallback);

    interface GetSampleCallback {
        void onSampleLoaded(List<SampleTable> data);

        void onDataSampleNotAvailable(String message);
    }
}
