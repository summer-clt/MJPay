package com.mujin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @Author: wuchenglin
 * @Date： 2020/5/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayQrCodeDto {
    private String qrCode;
    private String orderNumber;
}
