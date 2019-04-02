package id.eudeka.resepmami.view.base.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.eudeka.resepmami.view.base.listener.RecyclerViewItemClickListener;

public abstract class BaseAdapter<S, T extends BaseHolder<S>> extends RecyclerView.Adapter<T> {

    public RecyclerViewItemClickListener<S> listener;
    public List<S> list;

    public void setListener(RecyclerViewItemClickListener<S> listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        S data = getItem(position);
        holder.bindData(position, data);
        bindViewHolder(holder, data);
    }

    void add(S data) {
        list.add(data);
        notifyItemInserted(list.size());
    }

    void addAll(List<S> list) {
        for (S item : list) {
            add(item);
        }
    }

    void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    S getItem(int position) {
        if (position < list.size()) return list.get(position);
        else return null;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected abstract void bindViewHolder(T holder, S data);
}
