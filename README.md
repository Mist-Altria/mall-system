# mall-system

电商促销系统（软件工程实战大作业）——基于 **GitFlow** 与 **GitHub** 的团队协作演练。

## 分支模型

| 分支 | 用途 | 保护策略 |
| --- | --- | --- |
| `main` | 生产主干，随时可发布 | 禁止直接 Push，仅允许通过 PR 合并 |
| `develop` | 日常集成的开发主干 | 禁止直接 Push，仅允许通过 PR 合并 |
| `feature/*` | 单人特性开发 | 由开发者自建，合并后删除 |
| `release/*` | 发版前打包与回归 | 合并回 `main` 与 `develop` 后删除 |

## 角色

- **PM-Bob**：仓库搭建、分支保护、Code Review、发版
- **Dev-Alice**：特性开发、冲突解决、提交 PR

## 模块

- `CouponService` —— 优惠券（满减）计算
- `CartService` —— 购物车小计

## 版本

当前版本见 `version.txt`。
