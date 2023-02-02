package com.example.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView, CONTRACT> {
    public M m;
    private WeakReference<V> weakReference;

    //初始化，获取model
    public BasePresenter(){
       m = getModel();
    }

    public void bindView(V v){
        weakReference = new WeakReference<>(v);
    }

    public void unbindView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
            System.gc();
        }
    }

    public V getView(){
        if(weakReference != null){
            return weakReference.get();
        }
        return null;
    }

    public  abstract M getModel();

    public abstract CONTRACT getContract();
}
