package com.spm.paises;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spm.paises.databinding.FragmentDetallePaisBinding;
import com.spm.paises.placeholder.PlaceholderContent;
public class PaisFragment extends Fragment {

    private FragmentDetallePaisBinding binding;
    private PlaceholderContent.Pais mPais;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPais = getArguments().getParcelable("pais");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallePaisBinding.inflate(inflater, container, false);

        ImageView iv = binding.foto;
        iv.setImageResource(getImageId(mPais.foto));
        TextView tv = binding.descripciN;
        tv.setText(mPais.detalles);

        return binding.getRoot();
    }

    private int getImageId(String imagePath){
        String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1, imagePath.lastIndexOf("."));
        return getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
    }
}