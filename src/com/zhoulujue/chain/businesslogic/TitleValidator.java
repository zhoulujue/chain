package com.zhoulujue.chain.businesslogic;

import com.zhoulujue.chain.IChainHandler;
import com.zhoulujue.chain.ModelOnChain;

public class TitleValidator implements IChainHandler {

    @Override
    public ModelOnChain handle(Chain chain) {
        ModelOnChain model = chain.model();
        asyncValidate(chain, model);
        return model;
    }

    private void asyncValidate(final Chain chain, final ModelOnChain model) {
        new Thread(() -> {
            // after a http request.
            System.out.println("TitleValidator is working in async mode.");
            if (model.getAnotherProperty() < 0) {
                return;
            }
            chain.proceed(model);
        }).start();
    }
}
