package com.example.Controller;

import com.example.Module.info;

import java.util.ArrayList;
import java.util.List;

public class ControllerAdd implements IControllerAdd{
    List<info> listinfo =  new ArrayList<>();
    public ControllerAdd(){
            listinfo.add(new info(1, "06-08-1999","Thế Giới","4999","4999"));
            listinfo.add(new info(2, "07-08-1999","Thế Giới","4999","4999"));
            listinfo.add(new info(3, "08-08-1999","ssss","4999","4999"));
    }
    public List<info> getAllContact() {
        return listinfo;
    }


    @Override
    public List<info> getAllInfo() {
        return listinfo;
    }

    @Override
    public void add(info info) {

    }
}
