package com.arpit.UserManagementSystem.service;

import com.arpitj.UserManagementSystem.model.UMmodel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UMservice {
    private static List<UMmodel> model = new ArrayList<>();


    public List<UMmodel> getModel() {
        return model;
    }

    public void setModel(List<UMmodel> model) {
        UMservice.model = model;
    }

    static{ //populating
        model.add(new UMmodel(1,"Arpit", "AJ", "Bangalore", "93545"));
        model.add(new UMmodel(2,"Aniket", "AK", "Gujrat", "98500"));
        model.add(new UMmodel(3,"Sumit", "SP", "Bangaluru", "81490"));
    }


    public UMmodel getModelByID(int userid) {
        for (UMmodel mod: model) {
            if(mod.getUserId() == userid) return mod;
        }
        return new UMmodel(0,"Plz", "Enter", "Valid", "Data");
    }

    public void addUser(UMmodel mod) {
        model.add(new UMmodel(mod.getUserId(),mod.getName(), mod.getUserName(), mod.getAddress(), mod.getPhone_Number()));
    }

    public void update(UMmodel model, int id) {
        for(UMmodel mod: UMservice.model)
            if(mod.getUserId() == id) {
                mod.setName(model.getName());
                mod.setUserName(model.getUserName());
                mod.setAddress(model.getAddress());
                mod.setPhone_Number(model.getPhone_Number());
            }
    }

    public void delete(int id) {
        model.removeIf(model -> model.getUserId() == id);
    }
}
