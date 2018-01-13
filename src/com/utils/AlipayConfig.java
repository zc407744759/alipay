package com.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091300497891";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCQQ/AzT6PF719gT7pDsIQUysAeaY2rjxjkC/HAO9u5i/CkL/Vyvz34+aWqUl7Ud5oGjYw7LfjiIhAXXMJBVYrkdN8J8TGik+IneE55BaH+xZ9f6V8wYuyDaKADBMaf3twqKclCDw7HLXpLnSpzUAS/YO0sQAgaCbFgUSt4oUTxpiU3yrzzT4W71Zh7zgDVWG9HewbbEVyQ3tWAphuxqy0u9foa2oEBc9Q8xrgDZ4GnHTbcd0WJqhlRdRYwbKO2t1E0i0sOp/g0mYBImBgFOj7vWV15S8JydkgfGRWKroqF105xMvLIIvRYLdAYUyi1CRs1EV+i3Y5g5setwkvDO44VAgMBAAECggEASoNsu3P1CTU8NAi6EmBHuF2IoayvSd9dYdxxf3LraIjJQGStCBmTLtfzI2fsJx2nZp8RwTdbh6FEYmy8wPYoCRv8X6w+kNSFSRGwpn2sUGVOjkGBswJFWxJdI3ICDW0UloqCsyYH4gSxWADTfj/kU90CY4qnJJvBDBigtWvGqnD5iaAer/bHAi28lPcignz/Q7PSCr4oG4utJprNx2U47IVcsLQIk8LWfhdIq22UIokjvArXUfwss6Uu0PECFUAOVFrlf718O88Oh0quqOpIeZhKb0Rz/7sJyppBOSsaAWdefjiwOJlVIIFNqVRdGgHGBnZpDPGZ5283i+01/yI3OQKBgQDLmyxBvD/zR9K6VzgLtzQGL6dgeI9Z7HeVlyjBuXBW5a1OEK32HWiEO7RZHUVFWksnnBYhdMyV39tXEg2JC6UQRe9obiptEEgEwxAhobf0YeFcRwieI9jIoAj4l1alqCk/h/CvLCeZ36rHHzwZznzK4Im2icKjZLnCyldLRQC/swKBgQC1Y50KwYYxx01PWjU/qMlqxEe10t/EZx2/06YRCGBYlGkL80x2gMtzVJjFR0iFiYJ/Qyxfaa2XKzjk5r207oub8H2HhVkD+FqKSBEbMTWYGi0OrTIxDnmb1Eerqh45/R2UaZM6U93Yc+Uy2dNK3t9xjyscZ7FODLMZhq1vFqnXFwKBgAt0XGYKWDKwnLtdAsst8GBUt/7maXIuqn+g9GsJqrdIzpowuAi7mNCvpzLIQchoDwhYcKpLLuNTp7xbSKWoIQ4sUQ63++0M2HBkJPkvZvD5vLr7SBHVhHGtBzQtF3PUZRWs6S6Btmyit7HiIPh2tHCZd0XstCWLGiRKS+TxKdyfAoGAOQsEnhdSHmFw/J1/1W89OGhVrOaOHHPZNTRYK08ZDYJOrsVqrHHAiZp3GMNcGTKvaVo0oCTZxIqBL+soibfjC71LnMzgu5Dk2EvlpUmKczT4Kn9pI2hL8ieGCoRLUS06mivBczxgret0jtNV0VvZpRrDEgHCDquLv2FNNXxJGS0CgYAv3yQHpgjpgDtpf+c0sPwF1j/wcPIws6qNKj2Y/5Qr8keIAcOX16rwqjgBkNJMVOwsdZ7jAucniWExryc02PJBF1ZBrZ7ULKititRbmR0Y/Oq0FGuRms4TBVqXL+sHM07wtodlK/R7Z1djKWOBuQIn2Qpe+eTPDHx8lDzSIiAI6w==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwJiYbCWloo6AJlBQZcN3SC12R7reBVAI3EvlQOerO5MMpxPpMRIpFywTsJ/34umBUmfvih6/qegquYIjs6J6YoE5gHeffMt05K4tkQ/KKrXZbyG7woy1TwYA2DLTu4y3ZLxUIf92SDEct+9OiIOVWLXvzBpx23QnBw+WMyY7uNU678prPCwMq5eJd+5UJ9OnpXxi6aqq6H+et6geRk7kpNVyEOufFanxCHdJsC1diRuO8+de/8VPyvx609piEjYR4NUTDxK27ScdEMtNwPI96Ai8DqVp2D+O342Ad47DVysz3YK8sixmUck3HU+Av3AHbL25FfdsfoyT8q33ZWybmQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
//	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay/resultSerlet";
//	public static String return_url = "http://localhost:8080/alipay/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
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

