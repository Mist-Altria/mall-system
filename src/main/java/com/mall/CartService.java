package com.mall;

/**
 * 购物车服务：负责小计与商品数量校验。
 */
public class CartService {

    /** 单个商品允许的最大购买数量 */
    private static final int MAX_QUANTITY = 99;

    /**
     * 计算单行小计。
     *
     * @param unitPrice 单价（单位：分）
     * @param quantity  数量
     * @return 小计金额（单位：分）
     */
    public int lineTotal(int unitPrice, int quantity) {
        if (quantity <= 0 || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("购买数量必须在 1 ~ 99 之间");
        }
        return unitPrice * quantity;
    }
}
