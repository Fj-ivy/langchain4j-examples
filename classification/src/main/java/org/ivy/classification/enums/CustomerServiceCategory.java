package org.ivy.classification.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerServiceCategory {
    BILLING_AND_PAYMENTS, // 账单支付
    TECHNICAL_SUPPORT, // 技术支持
    ACCOUNT_MANAGEMENT, // 账户管理
    PRODUCT_INFORMATION, // 产品信息
    ORDER_STATUS, // 订单状态
    RETURNS_AND_EXCHANGES, // 退货换货
    FEEDBACK_AND_COMPLAINTS // 反馈投诉
}
