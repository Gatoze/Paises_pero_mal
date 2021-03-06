package com.spm.paises.placeholder;


import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import com.spm.paises.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Pais> PAISES = new ArrayList<Pais>();

    public PlaceholderContent(Resources resources,String packageName){
        if (PAISES.size() == 0){
            String[] countries = resources.getStringArray(R.array.paises);
            for (int i = 0; i < countries.length; i++) {
                PAISES.add(getItem(resources, packageName, countries[i], i));
            }
        }
    }

    public static Pais getItem(Resources resources, String packageName, String country, int id){
        String[] countryDetail = resources
                .getStringArray(resources.getIdentifier(country,"array",packageName));
        return new Pais (id+"",countryDetail[0], countryDetail[1], countryDetail[2]);
    }


    public static class Pais implements Parcelable {
        public final String id;
        public final String nombre;
        public final String detalles;
        public final String foto;

        public Pais(String id, String content, String details) {
            this.id = id;
            this.nombre = content;
            this.detalles = details;
            foto = null;
        }
        public Pais(String id, String content, String details, String foto) {
            this.id = id;
            this.nombre = content;
            this.detalles = details;
            this.foto   = foto;
        }

        protected Pais(Parcel in) {
            id = in.readString();
            nombre = in.readString();
            detalles = in.readString();
            foto = in.readString();
        }

        public static final Creator<Pais> CREATOR = new Creator<Pais>() {
            @Override
            public Pais createFromParcel(Parcel in) {
                return new Pais(in);
            }

            @Override
            public Pais[] newArray(int size) {
                return new Pais[size];
            }
        };

        @Override
        public String toString() {
            return nombre;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(nombre);
            parcel.writeString(detalles);
            parcel.writeString(foto);
        }
    }
}