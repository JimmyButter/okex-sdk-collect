package com.okex.open.api.bean.blockTrading.param;

import java.util.List;

public class CancelBatchQuotes {
    private List<String> quoteIds;
    private List<String> clQuoteIds;

    public List<String> getQuoteIds() {
        return quoteIds;
    }

    public void setQuoteIds(List<String> quoteIds) {
        this.quoteIds = quoteIds;
    }

    public List<String> getClQuoteIds() {
        return clQuoteIds;
    }

    public void setClQuoteIds(List<String> clQuoteIds) {
        this.clQuoteIds = clQuoteIds;
    }
}
