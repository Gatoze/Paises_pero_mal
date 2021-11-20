package com.spm.paises;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spm.paises.databinding.FragmentPaisesBinding;
import com.spm.paises.placeholder.PlaceholderContent.Pais;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Pais}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPaisRecyclerViewAdapter extends RecyclerView.Adapter<MyPaisRecyclerViewAdapter.ViewHolder> {

    private final List<Pais> mValues;

    public MyPaisRecyclerViewAdapter(List<Pais> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPaisesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).nombre);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public final TextView mContentView;
        public Pais mItem;

        public ViewHolder(FragmentPaisesBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            Bundle args = new Bundle();
            args.putParcelable("pais",mItem);
            args.putString("tittle", mItem.nombre);

            Navigation.findNavController(v)
                    .navigate(R.id.action_paisFragment_to_detallePaisFragment, args);
        }
    }
}