package com.tramquangvinh.sothich;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edthoten, edtcmnd, edtbosung;
    Button btgui;
    RadioGroup idgroup;
    CheckBox chkdocsach, chkchoigame, chkcode, chkar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        edthoten = findViewById(R.id.edt_hoten);
        edtcmnd = findViewById(R.id.edtcmnd);
        edtbosung = findViewById(R.id.edtbosung);
        btgui = findViewById(R.id.btngui);
        idgroup = findViewById(R.id.idgroup);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkchoigame = findViewById(R.id.chkchoigame);
        chkcode = findViewById(R.id.chkcode);
        chkar = findViewById(R.id.chkhocandroid);
        // xu ly
        btgui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lay thong tin ho ten
                String hoten = edthoten.getText().toString();
                if(hoten.length()< 4)
                {
                    Toast.makeText(MainActivity.this, "Họ tên phải >= 4 ký tự", Toast.LENGTH_SHORT).show();
                    // Đưa con trỏ về hàng nhập sai
                    edthoten.requestFocus();
                    // bôi đen
                    edthoten.selectAll();
                    //chờ người dùng nhập tiếp chứ không xuống hàng
                    return;
                }
                // lay thong tin cmnd
                String cmnd = edtcmnd.getText().toString();
                if(hoten.length()< 9)
                {
                    Toast.makeText(MainActivity.this, "CMND/CCCD Phải >=9", Toast.LENGTH_SHORT).show();
                    // Đưa con trỏ về hàng nhập sai
                    edthoten.requestFocus();
                    // bôi đen
                    edthoten.selectAll();
                    //chờ người dùng nhập tiếp chứ không xuống hàng
                    return;
                }
                // lay thong tin bằng cấp trong radio group
                int idselect = idgroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String bangcap = radselect.getText().toString();

                // lay thong tin bằng cấp trong check box
                String chuoi=" ";
                if(chkdocsach.isChecked())
                {
                    chuoi = chuoi + chkdocsach.getText().toString() +", ";
                }
                if(chkchoigame.isChecked()){
                    chuoi = chuoi + chkchoigame.getText().toString() +", ";
                }
                if(chkcode.isChecked()){
                    chuoi = chuoi + chkcode.getText().toString() +", ";
                }
                if(chkar.isChecked()){
                    chuoi = chuoi + chkar.getText().toString() +", ";
                }

                // get add information
                String bosung = edtbosung.getText().toString();

                // ket hop cac thong tin lai 1 chuoi
                String tonghop = " ";
                tonghop = tonghop + "Họ tên: "+hoten+ "\n"
                                    +"CMND/CCCD: "+cmnd+"\n"
                                    +"Bằng cấp: "+bangcap+"\n"
                                    +"Sở thích: "+chuoi+"\n \n"
                                    +"----Thông tin bổ sung thêm---- "
                                    +"\n"+bosung+"\n";
                // tạo dialog cho nó hiện lên information
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("THÔNG TIN CÁ NHÂN CỦA "+hoten);
                mydialog.setMessage(tonghop);
                mydialog.setPositiveButton("Close message !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                    }
                });
                mydialog.create().show();

            }

        });
    }
}