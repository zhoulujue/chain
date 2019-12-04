package com.zhoulujue.chain;

public class ModelOnChain {
    String someProperty;
    int anotherProperty;

    public ModelOnChain(String someProperty, int anotherProperty) {
        this.someProperty = someProperty;
        this.anotherProperty = anotherProperty;
    }

    public String getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }

    public int getAnotherProperty() {
        return anotherProperty;
    }

    public void setAnotherProperty(int anotherProperty) {
        this.anotherProperty = anotherProperty;
    }
}
