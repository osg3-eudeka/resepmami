package id.eudeka.resepmami.view.base.listener;

import androidx.annotation.IdRes;

public interface RecyclerViewItemClickListener<T> {

    void itemClick(int position, T item, @IdRes int view);
}
