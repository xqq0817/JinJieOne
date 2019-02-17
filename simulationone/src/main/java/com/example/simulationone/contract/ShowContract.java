package com.example.simulationone.contract;

import com.example.simulationone.entity.ShowBean;
import com.example.simulationone.model.ShowModel;

import java.util.HashMap;
import java.util.List;

public interface ShowContract {
    /**
     * p
     */
    public abstract class ShowPresenter{
        public abstract void getShow(HashMap<String,String> params);
    }
    public interface IShowModel{
        void getShow(HashMap<String,String> params, ShowModel.ShowModelCallback showModelCallback);
    }
    public interface IShowView{
        void success(ShowBean showBean);
        void failure(String error);
    }
}
