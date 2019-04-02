package id.eudeka.resepmami.view.base.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import id.eudeka.resepmami.view.base.listener.RecyclerViewItemClickListener;

public abstract class BaseHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private RecyclerViewItemClickListener<T> listener;
    private View itemView;
    private int itemPosition = 0;
    private T itemData = null;

    public BaseHolder(RecyclerViewItemClickListener<T> listener, View itemView) {
        super(itemView);
        this.listener = listener;
        this.itemView = itemView;
    }

    @Override
    public void onClick(View v) {
        listener.itemClick(itemPosition, itemData, itemView.getId());
    }

    void bindData(int position, T data) {
        itemPosition = position;
        itemData = data;
    }

    public int getItemPosition() {
        return itemPosition;
    }

    public T getItemData() {
        return itemData;
    }
}
