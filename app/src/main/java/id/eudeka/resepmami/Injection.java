package id.eudeka.resepmami;

import android.content.Context;

import id.eudeka.resepmami.data.SampleRepository;
import id.eudeka.resepmami.data.local.SampleLocalDataSource;
import id.eudeka.resepmami.data.remote.SampleRemoteDataSource;

public class Injection {
    public static SampleRepository provideSampleRepository(Context context) {
        return new SampleRepository(new SampleLocalDataSource(context), new SampleRemoteDataSource());
    }
}
