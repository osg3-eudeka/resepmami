package id.eudeka.resepmami.view.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import id.eudeka.resepmami.Injection;
import id.eudeka.resepmami.R;
import id.eudeka.resepmami.viewmodel.SampleViewModel;

public class MainActivity extends AppCompatActivity implements MainNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleViewModel sampleViewModel = new SampleViewModel(Injection.provideSampleRepository(this));
        sampleViewModel.setMainNavigator(this);
        sampleViewModel.getListSample();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void showMessage() {

    }
}
