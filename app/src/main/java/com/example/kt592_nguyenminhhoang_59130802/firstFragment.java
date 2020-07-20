package com.example.kt592_nguyenminhhoang_59130802;

import android.app.Application;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;


public class firstFragment extends Fragment{

    NavController navController;
    Button btnOK, btnAdd;
    EditText edtDate, edtMV, edtBR;
    RadioButton rdTG, rdSJC, rdDOJC;
    ImageView imgDate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        addViews(view);
        addEvent(view);
        return view;

    }
    private void addEvent(View view) {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "  Đã thêm", Toast.LENGTH_SHORT).show();
            }
        });
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thietLapNgay();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key_1", getAllThongTin());
                navController.navigate(R.id.action_firstFragment_to_secondFragment,bundle);
            }
        });
    }

    private void addViews(View view) {
        btnOK = view.findViewById(R.id.btnOK);
        edtDate = view.findViewById(R.id.edtDate);
        edtBR = view.findViewById(R.id.edtBR);
        edtMV = view.findViewById(R.id.edtMV);
        btnAdd = view.findViewById(R.id.btnAdd);
        rdTG = view.findViewById(R.id.rdTG);
        rdSJC = view.findViewById(R.id.rdSJCn2);
        rdDOJC = view.findViewById(R.id.rdDOJI);
        imgDate = view.findViewById(R.id.imvDate);


        navController = NavHostFragment.findNavController(firstFragment.this);
        ((MainActivity)getActivity()).navController = navController;
    }
    private String Phuongthuc()
    {

        String text ="";
        if(rdTG.isChecked())
        {
            text =" thế giới";
            return text;
        }if(rdSJC.isChecked())
    {
        text =" SJC";
        return text;
    }if(rdDOJC.isChecked())
    {
        text =" DOJI";
        return text;
    }
        return text;
    }

    public  String getAllThongTin()
    {
        String tt= "";
        tt =  edtDate.getText().toString() + "\n" + Phuongthuc()
                + "\n Mua vào: " + edtMV.getText().toString() + "  Bán ra: " + edtBR.getText().toString();
        return tt;
    }
    private  void thietLapNgay(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                StringBuilder builder = new StringBuilder();
                builder.append(dayOfMonth)
                        .append("/")
                        .append(++month)
                        .append("/")
                        .append(year);
                edtDate.setText(builder.toString());
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}