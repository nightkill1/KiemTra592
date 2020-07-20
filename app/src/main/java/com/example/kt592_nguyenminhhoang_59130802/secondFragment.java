package com.example.kt592_nguyenminhhoang_59130802;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Controller.IControllerAdd;
import com.example.Module.info;

import java.util.ArrayList;
import java.util.List;


public class secondFragment extends Fragment {

    TextView txt;
    RecyclerView recyclerView;
    NavController navController;
    Button btnExit;
    List<info> listinfo = new ArrayList<>();
    IControllerAdd iControllerAdd ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(secondFragment.this);
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_second, container, false);

        txt = view.findViewById(R.id.txt);
        Bundle bundle = getArguments();
        txt.setText(bundle.getString("key_1"));
        addViews(view);
        acctionClick(view);
        return view;
    }

    private void acctionClick(View view) {
        btnExit = view.findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigateUp();
            }
        });
    }

    private void addViews(View view) {
        recyclerView = view.findViewById(R.id.rcview);
        //iControllerAdd = (IControllerAdd) ((MainActivity)getActivity()).getApplication();
        btnExit = view.findViewById(R.id.btnExit);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.thoat)
        {
            navController.navigate(R.id.action_firstFragment_to_secondFragment);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

}
