package com.zhoulujue.chain;

public interface IChainHandler {
    ModelOnChain handle(Chain chain);

    interface Chain {
        ModelOnChain model();
        ModelOnChain proceed(ModelOnChain model);
    }
}
