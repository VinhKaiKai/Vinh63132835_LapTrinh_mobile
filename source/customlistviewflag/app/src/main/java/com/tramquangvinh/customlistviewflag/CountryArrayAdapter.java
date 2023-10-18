package com.tramquangvinh.customlistviewflag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {
    // nguon du lieu
    List<Country> lst_dataSouece;
    private LayoutInflater inflater;
    private Context context;
    //ham tao

    public CountryArrayAdapter(List<Country> lst_dataSouece, Context context) {
        this.lst_dataSouece = lst_dataSouece;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    class CountryItemViewHolder{
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }

    @Override
    public int getCount() {
        return lst_dataSouece.size();
    }

    @Override
    public Object getItem(int i) {
        return lst_dataSouece.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CountryItemViewHolder itemViewHolder ;
        if(view == null)
        {
            view = inflater.inflate(R.layout.customlistviewitem,null);// gan cai layout vao
            // get
            itemViewHolder = new CountryItemViewHolder();
            itemViewHolder.flagView = view.findViewById(R.id.imganh);
            itemViewHolder.countryNameView = view.findViewById(R.id.txtten);
            itemViewHolder.populationView = view.findViewById(R.id.txtmota);
            view.setTag(itemViewHolder);
        }
        else{

            itemViewHolder = (CountryItemViewHolder) view.getTag();
        }
        // set data item
        Country currentCountryItem = lst_dataSouece.get(i);
        itemViewHolder.countryNameView.setText(currentCountryItem.getCountryName());
        itemViewHolder.populationView.setText("Population :"+ currentCountryItem.getPopulation());
        // img data
        int flagId = getImgidbyResName(currentCountryItem.getCountryFlag());
        itemViewHolder.flagView.setImageResource(flagId);
        return view;

    }
    // end off getview
    // my own funtion for reading images
    public int getImgidbyResName(String resName){
        String packageName = context.getPackageName();
        int imgID = context.getResources().getIdentifier(resName,"mipmap",packageName);
        return imgID;
    }
}
