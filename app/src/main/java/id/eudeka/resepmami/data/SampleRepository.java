package id.eudeka.resepmami.data;

import java.util.List;

import id.eudeka.resepmami.data.local.SampleLocalDataSource;
import id.eudeka.resepmami.data.remote.SampleRemoteDataSource;
import id.eudeka.resepmami.model.SampleTable;

public class SampleRepository implements SampleDataSource {
    private SampleLocalDataSource sampleLocalDataSource;
    private SampleRemoteDataSource sampleRemoteDataSource;

    public SampleRepository(SampleLocalDataSource sampleLocalDataSource, SampleRemoteDataSource sampleRemoteDataSource) {
        this.sampleLocalDataSource = sampleLocalDataSource;
        this.sampleRemoteDataSource = sampleRemoteDataSource;
    }

    @Override
    public void getListSample(final GetSampleCallback getSampleCallback) {
        sampleLocalDataSource.getListSample(new GetSampleCallback() {
            @Override
            public void onSampleLoaded(List<SampleTable> data) {
                getSampleCallback.onSampleLoaded(data);
            }

            @Override
            public void onDataSampleNotAvailable(String message) {
                getSampleFromRemoteDataSource(getSampleCallback);
            }
        });
    }

    private void getSampleFromRemoteDataSource(final GetSampleCallback getSampleCallback) {
        sampleRemoteDataSource.getListSample(new GetSampleCallback() {
            @Override
            public void onSampleLoaded(List<SampleTable> data) {
                sampleLocalDataSource.saveDataSample(data);
                getSampleCallback.onSampleLoaded(data);
            }

            @Override
            public void onDataSampleNotAvailable(String message) {
                getSampleCallback.onDataSampleNotAvailable(message);
            }
        });
    }
}
