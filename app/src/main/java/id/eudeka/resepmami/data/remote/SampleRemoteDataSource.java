package id.eudeka.resepmami.data.remote;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import id.eudeka.resepmami.data.SampleDataSource;
import id.eudeka.resepmami.model.SampleTable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SampleRemoteDataSource implements SampleDataSource, Callback<List<SampleTable>> {
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    private GetSampleCallback getSampleCallback;

    @Override
    public void getListSample(GetSampleCallback getSampleCallback) {
        this.getSampleCallback = getSampleCallback;
        Call<List<SampleTable>> call = apiInterface.getSampleRemote("sample");
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<List<SampleTable>> call, @Nullable Response<List<SampleTable>> response) {
        if (response != null && response.body() != null) {
            getSampleCallback.onSampleLoaded(response.body());
        }
    }

    @Override
    public void onFailure(@NonNull Call<List<SampleTable>> call, @NonNull Throwable t) {
        getSampleCallback.onDataSampleNotAvailable(t.getLocalizedMessage());
    }
}
