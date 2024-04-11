package com.okex.open.api.bean.broker.param;

public class ModifySubAccountApikey {
    private String subAcct;
    private String apiKey;
    private String label;
    private String perm;
    private String ip;

    @Override
    public String toString() {
        return "ModifySubAccountApikey{" +
                "subAcct='" + subAcct + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", label='" + label + '\'' +
                ", perm='" + perm + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getSubAcct() {
        return subAcct;
    }

    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
