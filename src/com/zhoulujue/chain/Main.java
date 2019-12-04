package com.zhoulujue.chain;

import com.zhoulujue.chain.businesslogic.ChainManager;

public class Main {

    public static void main(String[] args) {
        // common use case: after user input, upload a video.
        ModelOnChain model = new ModelOnChain("original data", 1);
        ChainManager.getInstance().process(model);

        // chained customized procedure.
        ChainManager myManager = new ChainManager();
        myManager.addChainHandler(new IChainHandler() {
            @Override
            public ModelOnChain handle(Chain chain) {
                // do something
                System.out.println("Customized handler is handling.");
                return chain.model();
            }
        });
        myManager.process(model);

    }
}
