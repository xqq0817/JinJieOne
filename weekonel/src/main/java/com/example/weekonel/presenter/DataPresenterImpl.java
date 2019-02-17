package com.example.weekonel.presenter;

import com.example.weekonel.model.DataModelImpl;
import com.example.weekonel.utils.UtilsCallBack;
import com.example.weekonel.view.DataView;

import java.util.HashMap;

public class DataPresenterImpl implements DataPresenter{
    private DataView dataView;
    private DataModelImpl dataModel = new DataModelImpl();
    public DataPresenterImpl(DataView dataView) {
        this.dataView = dataView;
    }
    @Override
    public void setData(String url, HashMap<String, String> map) {
        dataModel.getData(url, map, new UtilsCallBack() {
            @Override
            public void success(Object result) {
                dataView.success(result);
            }

            @Override
            public void defeated(Object error) {
                dataView.defeated(error);
            }
        });
    }
}
