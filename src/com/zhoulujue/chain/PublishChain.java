package com.zhoulujue.chain;

import java.util.List;

public class PublishChain implements IChainHandler.Chain {

    private static final int MAX_CHAIN_HANDLER_COUNT = 10;

    private List<IChainHandler> mHandlersOnChain;
    private ModelOnChain mDataBeingProcessed;
    private int mIndex;
    private int mDepth;

    public PublishChain(List<IChainHandler> mHandlersOnChain, ModelOnChain mDataBeingProcessed, int mIndex) {
        this.mHandlersOnChain = mHandlersOnChain;
        this.mDataBeingProcessed = mDataBeingProcessed;
        this.mIndex = mIndex;
    }

    @Override
    public ModelOnChain model() {
        return mDataBeingProcessed;
    }

    @Override
    public ModelOnChain proceed(ModelOnChain model) {
        if (mIndex >= mHandlersOnChain.size() || mDepth >= MAX_CHAIN_HANDLER_COUNT) {
            return model;
        }

        mDepth++;

        PublishChain next = new PublishChain(mHandlersOnChain, mDataBeingProcessed, mIndex + 1);
        IChainHandler handler = mHandlersOnChain.get(mIndex);
        return handler.handle(next);
    }
}
