package id.eudeka.resepmami.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.eudeka.resepmami.R;
import id.eudeka.resepmami.model.SampleRecipe;
import id.eudeka.resepmami.view.base.adapter.BaseAdapter;
import id.eudeka.resepmami.view.base.adapter.BaseHolder;
import id.eudeka.resepmami.view.base.listener.RecyclerViewItemClickListener;

public class RecipeAdapter extends BaseAdapter<SampleRecipe, RecipeAdapter.ViewHolder> {

    class ViewHolder extends BaseHolder<SampleRecipe> {
        @BindView(R.id.iv_thumbnail)
        ImageView ivThumbnail;
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_recipe_name)
        TextView tvRecipeName;

        public ViewHolder(RecyclerViewItemClickListener<SampleRecipe> listener, View itemView) {
            super(listener, itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind() {
            SampleRecipe data = getItemData();

            if (data != null) {
                Picasso.get().load(data.getThumbnail()).into(ivThumbnail);
                tvCategory.setText(data.getCategoryName());
                tvRecipeName.setText(data.getRecipeName());
            }
        }
    }

    @Override
    protected void bindViewHolder(ViewHolder holder, SampleRecipe data) {
        holder.bind();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(listener, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe,
                parent, false));
    }
}
