package com.tramquangvinh.appmonan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    // Arraylist
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater1;
    private Context context1;
    // Ham tao

    public MonAnAdapter( Context _context1, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context1 = _context1;
        this.layoutInflater1 = LayoutInflater.from(_context1);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // view hien hanh
        View viewhienhanh = view;
        // kiemtra
        if(viewhienhanh == null)
        {
            viewhienhanh = layoutInflater1.inflate(R.layout.item_monan,null);
        }
        // lay du lieu
        MonAn monanhientai = dsMonAn.get(i);
        // gan len cac dieu khien
        TextView txt_tenmon = (TextView) viewhienhanh.findViewById(R.id.txt_tenmonan); //
        TextView txt_dongia = (TextView) viewhienhanh.findViewById(R.id.txt_dongia);//
        TextView txt_mota = (TextView) viewhienhanh.findViewById(R.id.txt_mota);//
        ImageView img_anh =(ImageView) viewhienhanh.findViewById(R.id.imgAnhDaiDien);//
        // set up
        txt_tenmon.setText(monanhientai.getTenMonAn());
        txt_dongia.setText(String.valueOf(monanhientai.getDonGia()));
        txt_mota.setText(monanhientai.getMoTa());
        img_anh.setImageResource(monanhientai.getIdAnhMinhHoa());

        return viewhienhanh;
    }
}
