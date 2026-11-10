package com.mall;

/**
 * 优惠券计算服务。
 *
 * <p>负责满减券的判定与金额计算，是促销系统的核心计费入口。</p>
 */
public class CouponService {

    /** 满减门槛：订单金额达到该值（单位：分）才可以使用满减券 */
    private static final int FULL_REDUCTION_THRESHOLD = 10000;

    /** 满减面额（单位：分） */
    private static final int FULL_REDUCTION_AMOUNT = 1000;

    /**
     * 计算满减后的应付金额。
     *
     * @param orderAmount 订单原始金额（单位：分）
     * @return 满减后的金额（单位：分）
     */
    public int applyFullReduction(int orderAmount) {
        if (orderAmount < 0) {
            throw new IllegalArgumentException("订单金额不能为负数");
        }
        if (orderAmount >= FULL_REDUCTION_THRESHOLD) {
            return orderAmount - FULL_REDUCTION_AMOUNT;
        }
        return orderAmount;
    }
}
