package com.zhoulujue.chain.businesslogic;

import com.zhoulujue.chain.IChainHandler;
import com.zhoulujue.chain.ModelOnChain;
import com.zhoulujue.chain.PublishChain;

import java.util.ArrayList;
import java.util.List;

public class ChainManager {
    private static volatile ChainManager mInstance;
    private List<IChainHandler> mHandlers;

    public ChainManager() {
        this.mHandlers = new ArrayList<>();
        addChainHandler(new ImagePublisher());
        addChainHandler(new TitleValidator());
        addChainHandler(new VideoPublisher());
    }

    public static ChainManager getInstance() {
        if (mInstance == null) {
            synchronized (ChainManager.class) {
                if (mInstance == null) {
                    mInstance = new ChainManager();
                }
            }
        }
        return mInstance;
    }

    public void addChainHandler(IChainHandler handler) {
        if (handler != null) {
            this.mHandlers.add(handler);
        }
    }

    public void process(ModelOnChain model) {
        handleWithHandlerChain(model);
    }

    private ModelOnChain handleWithHandlerChain(ModelOnChain model) {
        if (model == null) {
            return null;
        }
        PublishChain root = new PublishChain(this.mHandlers, model, 0);
        return root.proceed(model);
    }
}
