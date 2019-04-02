package id.eudeka.resepmami.view.main;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.eudeka.resepmami.Injection;
import id.eudeka.resepmami.R;
import id.eudeka.resepmami.model.SampleRecipe;
import id.eudeka.resepmami.view.base.listener.RecyclerViewItemClickListener;
import id.eudeka.resepmami.viewmodel.SampleViewModel;

public class MainActivity extends AppCompatActivity implements MainNavigator, RecyclerViewItemClickListener<SampleRecipe> {
    @BindView(R.id.rv_recipes)
    RecyclerView rvRecipes;

    private RecipeAdapter adapter = new RecipeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recipe);
        ButterKnife.bind(this);

        //Dummy Data
        List<SampleRecipe> listDummy= new ArrayList<SampleRecipe>();
        listDummy.add(new SampleRecipe("https://www.themealdb.com/images/media/meals/1550442508.jpg", "This is Category", "This is Recipe Name"));
        listDummy.add(new SampleRecipe("https://www.themealdb.com/images/media/meals/1550442508.jpg", "This is Category", "This is Recipe Name"));
        listDummy.add(new SampleRecipe("https://www.themealdb.com/images/media/meals/1550442508.jpg", "This is Category", "This is Recipe Name"));
        listDummy.add(new SampleRecipe("https://www.themealdb.com/images/media/meals/1550442508.jpg", "This is Category", "This is Recipe Name"));
        listDummy.add(new SampleRecipe("https://www.themealdb.com/images/media/meals/1550442508.jpg", "This is Category", "This is Recipe Name"));

        adapter.list = listDummy;
        adapter.setListener(this);
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
        rvRecipes.setAdapter(adapter);

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

    @Override
    public void itemClick(int position, SampleRecipe item, int view) {

    }
}
