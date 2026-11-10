package com.mall;

/**
 * 优惠券计算服务。
 *
 * <p>负责满减券与折扣券的判定与金额计算，是促销系统的核心计费入口。</p>
 */
public class CouponService {

    /** 满减门槛：订单金额达到该值（单位：分）才可以使用满减券 */
    private static final int FULL_REDUCTION_THRESHOLD = 8000;

    /** 满减面额（单位：分） */
    private static final int FULL_REDUCTION_AMOUNT = 1000;

    /** 折扣券最大折扣率（8 折） */
    private static final double MAX_DISCOUNT_RATE = 0.8;

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

    /**
     * 计算折扣券后的应付金额（不足 8 折时按传入折扣率计算，最低 8 折）。
     *
     * @param orderAmount 订单原始金额（单位：分）
     * @param discountRate 折扣率，例如 0.9 表示九折
     * @return 打折后的金额（单位：分）
     */
    public int applyDiscount(int orderAmount, double discountRate) {
        if (orderAmount < 0) {
            throw new IllegalArgumentException("订单金额不能为负数");
        }
        if (discountRate <= 0 || discountRate > 1) {
            throw new IllegalArgumentException("折扣率必须在 (0, 1] 之间");
        }
        double rate = Math.max(discountRate, MAX_DISCOUNT_RATE);
        return (int) Math.round(orderAmount * rate);
    }
}
