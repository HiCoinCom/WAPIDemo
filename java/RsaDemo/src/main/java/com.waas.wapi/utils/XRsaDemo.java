package com.chainup.baas.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import java.util.Map;

public class XRsaDemo {

    public static void main(String[] args) {
        //String myPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs4AivV7eO95S3iL1OSl-NchS3LWtVrCxWBYer9s6TFc88CLNYmuVdb7FhA9nc2eBDWeSMosWHPVNpA0KKnMscajRJt6vKiBKmhZv81T4h9aXAtScw3EH1sYE_ia0N4LlOmPmgoSIJ4gQJQljHd2_45j32xZX-Hw-y9YrjsXU4fi6uNWqFZexfhwaYmLCkGm4-yb2Mf4bqooB2BwNxfsrt_jQokPqZfqOz7ktfY1zbThQ8VJPIbO3uYgjH3_pl1c_48dGAHBs4weC3taX3OpMBu7NYdiIkqOo6x9Q8Vs7Q-_dK0g6DqAy8nwOvgcf-KfH56e030LBDADGXxssYwwpPQIDAQAB";
        String myPrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCzgCK9Xt473lLeIvU5KX41yFLcta1WsLFYFh6v2zpMVzzwIs1ia5V1vsWED2dzZ4ENZ5IyixYc9U2kDQoqcyxxqNEm3q8qIEqaFm_zVPiH1pcC1JzDcQfWxgT-JrQ3guU6Y-aChIgniBAlCWMd3b_jmPfbFlf4fD7L1iuOxdTh-Lq41aoVl7F-HBpiYsKQabj7JvYx_huqigHYHA3F-yu3-NCiQ-pl-o7PuS19jXNtOFDxUk8hs7e5iCMff-mXVz_jx0YAcGzjB4Le1pfc6kwG7s1h2IiSo6jrH1DxWztD790rSDoOoDLyfA6-Bx_4p8fnp7TfQsEMAMZfGyxjDCk9AgMBAAECggEBAK93Un5LfnKHofoDsjNunDF24YlfD1Lu5m11Mgo2A4ccwDT90EelYzT2h53QcRAe3ch8ti0ySSuFn5_-HzHf5FI29D1K8W_8oPB_fnAfX9NpsbTSoWtr0n3glIDc1M5u5iVuAqcTZwU9vIp34qwPWMTjg2ZnMRd2XOxlL68hNDivhxhz3tv-8fK5k6noO3KzKU17sa9673tbcq73OEPF3Okv7Ypa6qohi5MqLMMhi6AErP_Q_K81KE58lDMVQkxBFSaSzgfMjbjvn1fYpLfpBmMRl3-eFJUvG7IzPTR6j4iofNG74WfxLlKx91CYwmgIr-0b36S3eOc1yz8J1FsNiAECgYEA6jvKqQgISKXkSjE0Fk5GDDI08wvd0Wg_e2FZFg_ZQ8RyZ9MfV9za3ATUweJUdDLgIi0poECR0m7e_SCznjLrb0ZjpzkpRscTWalDlIW_lVkXTDJO-yBoEmWCe_GgpyqRIuFoMiUwCN-rPtbOsGFnPqys_2M65eZ5SEFW2epUf2kCgYEAxC5LOwsjr3y-Tye8djBOhzAeQmamsBV-AGmNGsS3pD8sjWdG4tG01qRQ2y9_RIdCIvvrUYgwoocf7k7voTA8XmT3Ou6Oal74J-aU0SYCUBPJt1WvUmuRlBZN35TcUhquPgUb7SvbfOtNUc-gtCCK3KTPb-txXCzCXjFf_i8u9LUCgYEAsqKo-2Jp1uXVhhOiUsSdPV3o7dcF81da2sCyTVYG71zZl372r25650Mz8y2mFPxb3RSuY037KA5wN4ICGkthLHr1Myov5Y-bnUyugo3CP6czUmQnwfPECwupiNcNG5AmIgDgEyYzTQEvu3vdI70VHUJZqWfHGmA77LQQBZ9lk8kCgYAnj65cGcL4gI9gJwM6UkODv5Bak5jJqYvfSWnLHCBsXtD9MvZ4hxGQt1IW4V0o1J3hsCukJXKpU9Z8mC56st95qaKxn6nYiY5BfZ5FDwUoYNUsw3q3hDm3Q0gw7jP_2qGIoD8hdNauOkU9WkFuEaHvHM04JKKXk-8eT5asC5fMgQKBgQCCcn-7MWFumJfmCZOxBg0_pSPsbAlmSFxdOO1VQ9Q4Iny47AQRvYxbe-zdvpBzPbkoTlLraJ_hjg9dE2ZbxdiWVAkcTcHmzlCs4BKBQi8hu-z3cns5-TI-93wjrBjqAWL04nFA3wz043cXiOqhaykm3FZV1Dk4i-SZOZns6Zuukw";

        String myPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1BHeeGDQmdXVRlQ4STEGch9smcJEuQnb8BM15r5y572FQyO2HaWAMJ00r1Uph7ouQHulJD1n8X1eRNWb4NRTvoZuFzywoaqBY67tLjKm88I2c4L/1e6NRY3CDeULySAh0z5L8EObLSigsZ9AiQjQ/HhyambZu54JK8EaZBl1CvHzM2JxOfm8QHXmn57F/j50q7tBz6QZmfaihc9MPfgu+W34DGUM/72KyQaQ58etO6z+POurvt2ACPm/49pBS88fc1zpHpnFbfwkDtN0wt1t3J4Aj+V3LRfyaHUBrqOXXo+jZtkhUgIImKxlfRQEp794V/3wcTrdbh5Xt/VO7dZNaQIDAQAB";

        XRsa x = new XRsa(myPublicKey, myPrivateKey);

        Map<String, Object> map = Maps.newHashMap();
        map.put("name", "张三");
        map.put("age", 27);


        //String json = JSONObject.toJSONString(map);
        String json = "{\"symbol\":\"GEC\",\"addresses\":\"Ao896992d40bc75691f3b7552d345610a5c803db9d\"}";

        // 调用接口请求数据
        // 公钥加密json字符串
        String data = x.publicEncrypt(json);
        System.out.println("公钥加密：" + data);
        // 私钥加密得到sign
        String sign = x.sign(json);
        System.out.println("sign:" + sign);

        Map<String, String> params = Maps.newHashMap();
        params.put("sign", sign);
        params.put("data", data);
        params.put("app_id", "c669632241114ae29ab2383f309e3d07");
        //String url = "http://192.168.60.96:9655/api/v1/deposit/notify";
        String url = "http://baas.hiwallet.pro/api/v1/address/register";
        String result = HttpUtils.sendPost(url, JSONObject.toJSONString(params));
        System.out.println("请求结果：" + result);




    }
}
