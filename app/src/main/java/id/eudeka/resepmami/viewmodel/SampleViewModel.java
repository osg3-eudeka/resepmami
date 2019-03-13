package id.eudeka.resepmami.viewmodel;

import java.util.List;

import id.eudeka.resepmami.data.SampleDataSource;
import id.eudeka.resepmami.data.SampleRepository;
import id.eudeka.resepmami.model.SampleTable;
import id.eudeka.resepmami.view.main.MainNavigator;

public class SampleViewModel {
    private MainNavigator mainNavigator;
    private SampleRepository sampleRepository;

    public SampleViewModel(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public void setMainNavigator(MainNavigator mainNavigator) {
        this.mainNavigator = mainNavigator;
    }

    public void getListSample() {
        sampleRepository.getListSample(new SampleDataSource.GetSampleCallback() {
            @Override
            public void onSampleLoaded(List<SampleTable> data) {
                mainNavigator.showData();
            }

            @Override
            public void onDataSampleNotAvailable(String message) {
                mainNavigator.showMessage();
            }
        });
    }
}
