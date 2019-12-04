package com.zhoulujue.chain.businesslogic;

import com.zhoulujue.chain.IChainHandler;
import com.zhoulujue.chain.ModelOnChain;

public class VideoPublisher implements IChainHandler {
    @Override
    public ModelOnChain handle(Chain chain) {
        System.out.println("VideoPublisher is working.");
        chain.proceed(chain.model());
        return chain.model();
    }
}
