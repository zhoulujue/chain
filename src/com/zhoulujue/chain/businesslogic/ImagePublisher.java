package com.zhoulujue.chain.businesslogic;

import com.zhoulujue.chain.DerivedModel;
import com.zhoulujue.chain.IChainHandler;
import com.zhoulujue.chain.ModelOnChain;

public class ImagePublisher implements IChainHandler {
    @Override
    public ModelOnChain handle(Chain chain) {
        System.out.println("ImagePublisher is working.");
        ModelOnChain model = chain.model();
        if (model.getSomeProperty() == null) {
            return model;
        }

        model = someLogicThatWillChangeModel(model);
        return chain.proceed(model);
    }

    private DerivedModel someLogicThatWillChangeModel(ModelOnChain model) {
        return DerivedModel.process(model);
    }
}
