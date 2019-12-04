package com.zhoulujue.chain;

public class DerivedModel extends ModelOnChain {

    String someSophisticatedData;

    public DerivedModel(String someProperty, int anotherProperty) {
        super(someProperty, anotherProperty);
    }

    public static DerivedModel process(ModelOnChain model) {
        DerivedModel derivedModel = new DerivedModel(model.someProperty, model.anotherProperty);
        derivedModel.someSophisticatedData = "processed data after basic model on chain";
        return derivedModel;
    }
}
