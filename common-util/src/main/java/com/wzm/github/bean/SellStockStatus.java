package com.wzm.github.bean;

/**
 * SellStockStatus 可用库存枚举
 * StockOut : 缺货; SufficientStock：充足 StressStock 库存紧张
 */
public enum SellStockStatus {
    StockOut("StressStock", "缺货"),//缺货
    SufficientStock("SufficientStock", "充足"),// 充足
    StressStock("StressStock", "紧张"); // 库存紧张

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private SellStockStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}

