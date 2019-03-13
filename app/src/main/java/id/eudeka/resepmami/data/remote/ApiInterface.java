package id.eudeka.resepmami.data.remote;

import java.util.List;

import id.eudeka.resepmami.model.SampleTable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/sample")
    Call<List<SampleTable>> getSampleRemote(@Query("q") String query);
}
