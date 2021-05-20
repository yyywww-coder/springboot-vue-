package com.woniu.utils;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName: AlipayConfig <br/>
 * Description:沙箱支付工具类 <br/>
 * date: 2021/5/7 17:14<br/>
 *
 * @author hasee<br />
 */
@Component
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117650303";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCiWgBjmq+RRfxZrL2828iY9PAeW8VPH+PLjhSru7T1MByMU8kfWnnEy40naqCOXfXR+e3vHFvnaSTW7rvwwP/8c3KNoeBJ7jyRR0Bu5wSjMYSb7NrO8elseF/Q0MmDYBZhiRqVIy5K7Qk6nG76O4365aqSlpn7VCqFikc07Ortj7GHVX3C/BOfyc97P9bA2egj1uzZ5xqrAunkc1awTBQncOThnn18kjvLgfkxd8GwXjf5G28mi7f08lHMv0hti0Q9tESJzxxihBbHcLAuxEcuv5UADXPPJVbRQ+Wf8yzX3U1AvVhKE5MR9q0OQF3HRUkMMySTlzMyNL3YhC7Wxs95AgMBAAECggEAEi98rauNEPvC6ZSU6EvCK4f8QZpL/rH2xT1UCWyMN469E+bqt21eCHI4jHrAI1JZD70sLsWBcelwK/cv7CbiRbf00/KW+hEKjcdqa0HLXjBUx1Z/qACnAfR13yEUAXhI6YH/DUeUjuYAS6VsNPFo1PrW4XanJuTlonG7yizjn9pzd/XmDpv980fBjEkoQLb6ssCPT5dfmXayXgPsuvG239p7V0qbmRxke1udx2buJK8rrBqxRB0W6ZMnAC/rYLWOXP+qw+rFe86fHtbNlYb34aqegWsQQ72DalhUawiveuYFbdxCEvxX7NJ0tbPmLSnPEWsBNbfGjfQDU9Y1AO6F1QKBgQDtUn/HrCclTT5olRtcMko7Y9HrCvoWPO+Gzq7eO2klBfaTqEpGVgB9CfY+VbdyUQ6i7YhjsYtJX4UJ2kSqX2NnOdesJOTnyePHDMut9w6K8LOKrYqEIRQN8SuquLUmTtyp5Gr1Kkqsouz0mvkbhAtBX4fPyGsKnnqhFkoMOjYbEwKBgQCvIQOsPMV/awAga4F3G+RUxpn7Epb62H8mPgkBDqjF2004Xh8Syc7199bOURKpAie12cxlttQtfPqZiYzNHIaKPjPa11AxpY9vhFDPteULETfehV7sg20QYvsD3JFRfa+v9CsNm6NGkmKyaWxMO+donMy3oeJA/1L78uQBX4UQwwKBgE47d+v2kCD3ya7oGFDYMyhIy5ZT1AUoqT0jPPn9U7fks1gRjgqJpzeQ5R+/We3RUqXa768NhAD3//8zeJdBQp9wrewNbXgLUY74ZNxAKQccOdNpSdQso1PFQMPSh8TNEmje53NSMbOfMcWgoKW1bZBrUXXpd3/UplAb7OUC+3sJAoGBAKIqggolpAQfAtkCc7nlnANcfA1f42qYuvSgkRnnhyTfs5u0nDV7pidhvgkCTbMuibL84SZ2q/cLOcqe8kCkX3j3rHDC3EF8u1taPLJ6DoO3B/MHsSR1drKr1SB4SCAbsGnQQWWybvjUaIwozt2wwtG+EFsiji39v8wJ2FPlLYSdAoGBANrP2XWkFTq+wBy+i9PO0iw23FgWEEGRS5nKmfmKt/r9rmomALNSn1C+J1/S4pOiGBVwAUdo2+lY+Rp4Szu26pzFpRz6AAugBkkrVSDAat1f1zfehwIbtN30by9ZTEsCJbV6ieifahH2+6pzVLz9PSuSkrky0+p2lpCEUd0zR9YD";

//    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg8PgZGuvxOGMZjcRnkDyts9aR2evDxtNK1SWoRJAeanv2U4of6oYJytLSL9Ib7y8aOooQ07V+KHEY0HTRQtdTLL2Puq3LO65uHUQrXz0woBdGxC/IwmIRTFf3rQb35d5Lm2qG5v6ZZmXAAtwHpWC7JvwtYtPcSVP/K7kPpyOrtjniMBSvUGbzp2RHM1ekJi8KKjOhKv3Mn07WdpnV+TtV1CzN2RK0WkkBHtP22OKlzGXhZyuZkupARkZYOnHpuCWhv5d5t53yvgkAn7SbBJAXwtrF/9N6ryZRbCWHho1s/7lOaJguC6M29KzDM/V2kLLN0HzKogp767G4lQq7d1FPQIDAQAB";
//
//    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://ngrok.sscai.club/alipay_trade_wap_pay_java_utf_8_war_exploded/notify_url.jsp";
//
//    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://ngrok.sscai.club/alipay_trade_wap_pay_java_utf_8_war_exploded/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关(异步调用本项目的地址)
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
