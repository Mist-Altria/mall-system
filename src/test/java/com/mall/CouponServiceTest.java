package com.mall;

/**
 * CouponService 的单元测试。
 *
 * <p>不使用任何测试框架（作业约束：不引入第三方依赖），用一个 main 方法
 * 依次执行断言，失败即打印原因并以非 0 退出码结束，可直接在命令行运行。</p>
 */
public class CouponServiceTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        CouponService service = new CouponService();

        // 1. 满减：达到门槛（90 元）应减 10 元
        assertEquals("满减-达到门槛", 8000, service.applyFullReduction(9000));

        // 2. 满减：未达门槛不打折
        assertEquals("满减-未达门槛", 8999, service.applyFullReduction(8999));

        // 3. 折扣：九折正常计算
        assertEquals("折扣-九折", 9000, service.applyDiscount(10000, 0.9));

        // 4. 折扣：低于 8 折时按 8 折兜底
        assertEquals("折扣-低于8折兜底", 8000, service.applyDiscount(10000, 0.5));

        // 5. 非法参数
        assertThrows("满减-负数抛异常", new Runnable() {
            public void run() { service.applyFullReduction(-1); }
        });
        assertThrows("折扣-折扣率超范围抛异常", new Runnable() {
            public void run() { service.applyDiscount(10000, 1.5); }
        });

        System.out.println("--------------");
        System.out.println("通过 " + passed + " 项，失败 " + failed + " 项");
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void assertEquals(String name, int expected, int actual) {
        if (expected == actual) {
            passed++;
            System.out.println("[PASS] " + name + " -> " + actual);
        } else {
            failed++;
            System.out.println("[FAIL] " + name + " 期望 " + expected + " 实际 " + actual);
        }
    }

    private static void assertThrows(String name, Runnable action) {
        try {
            action.run();
            failed++;
            System.out.println("[FAIL] " + name + " 期望抛异常，实际没有");
        } catch (IllegalArgumentException expected) {
            passed++;
            System.out.println("[PASS] " + name + " -> " + expected.getMessage());
        }
    }
}
