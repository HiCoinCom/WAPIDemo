package com.chainup.baas.rsaDemo;

import com.alibaba.fastjson.JSONObject;
import com.chainup.baas.utils.HttpUtils;
import com.chainup.baas.utils.XRsa;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyq
 */
@RestController
@Slf4j
public class RsaDemoController {

    @RequestMapping("/ping")
    public String ping() {
        return "hello";
    }

    @RequestMapping("/createKey")
    public Object createKey() {
        Map<String, String> rsa = XRsa.createKeys(2048);
        log.info("create key:{}", JSONObject.toJSONString(rsa));
        return rsa;
    }


    @PostMapping(value = "/requestDemo", produces = "application/json;charset=utf-8")
    public Object requestDemo(@RequestBody Map<String, String> params,
                              HttpServletRequest request) {
        log.info("/requestDemo request params:{}", JSONObject.toJSONString(params));
        String oppositePublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhRLc7D_2wimHuD2qUcvugoklO6v-AHtWg_RLABSpp_tijGaQJLPpJlmXg3Qqy2Gk__CgX4U2PvmCittodZh9vjuhQ5Tz1uBpiDg0NfuPnO2kqD7uT8aTccjROt2XhZwZNfjXevL8MwIoUBY0juYwULCpzWJTeF4wWLH69Kpbk3a1MG4ltWE0-LOzKrlTsLkVg6-num1gTN2b29LSdxuXjV1Cqoi7jA9Qzq2Hy_3ahAmfTYalB7S6wW_T8SYjBPOjz4s27lkYVuNnsYChjuzqdw2cOCZ--P1tgfgWTeL8SuyyTtxc9sVsSGyuYHHGqxVWeDjGoxTSuVS8EOrw3n8qeQIDAQAB";
        String myPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCRP5eXt9J26RFT-J_4smRcziAOo2LYfWh0bMw4FR6VpdOU320xo0mxDowmwMhng3U02aQ4MYTpJVvaXUm6RcnYM5N7hPKrmD3IxQw-bKd8hPbcQtFzf2xOBqK-5DC6zjiDEr2ATFbMq474m01zNRNgzmYFGoyvj6UvGnt2JSKMIVFJqWztpDMg5JzsEGe-E_2ucXEyMy6d-6ndOJOXklQIsi6hJuLdreDnx_r1fZ3D5qWhgITlGnfCoxZA3J8RLA4n5uf1NaR3ykJkIMHQEuoIbaF9Y5_dr10AbehM8X1zjhB0_sAPUNpsgME2dg_JYDEG62bqS-5_K2joOuwlk8rLAgMBAAECggEAORrNWMLWphV_0InBKx_HwYzwoZCu_fpgJNXZfHshKSinBLLK1WcjQ886XsoQgFH4tKyUmdsuLBOaB0ICCJADiVLNuxRL7BbQw6xk4e4J8zS7cWF7w3Lne820EmTYm7kUEsQ9aMGapqEUdr1oN9E4Kyk6husnQKazBM_ellaHPJwJEeSo8_LSWdrqYpLgJWU5um2Nc4tYU7LfXtbX5M_MiAEx5wz9Knyb8hpQJ00zBAhE2n1NCCg3H2UAhHVF03oQN5gyeXUjvkiUEakdo1X29cV0IjU87aDx5Up7yVQ6FvDKdt6MOpUXXUQ7amFmSD0gqqsz3aovwkrn6JsdbVy8kQKBgQDy3L503ODCy7xIiaDfm4rSXULq8NEQfAWjvQkOuSeQiY86qIuBYr6xKaGoPfS6ONtkbkfLBhv1hZBlZZRrNSdBIrIbMEYJOukV5qQo4ZKRMa8XouYYobMjE5BfzXnY_oy_rwmXr8TN7tZ7xF56dPeD5zpW7z4USbwqA4FlGUto_wKBgQCZGw0oqg08vYxHdBauQ9OEEKrR1Zgg9r_OCEdMKPTvLOR_uPNoZox7cdyeVJpK9dGZhRG-Xgm0DzWLs_By4h7LnOYClXKf8_gaAfS0oKZv5FoXPXR0qoKFLMl-DCzA-vzPiOIwkZv3UxXTt4218R5eec8AwDH73Z4KTKQBukryNQKBgQC58EfhMTrj6Rg-cSC6Elw2szCIr9dgx5OJyTEmFJw2DRubzW8BoJhfC4C5TrYP3XgbbFOLHSJK1_e1qg_4BLoJJIc4Sb1VU8Ug_3Sv2ARfJarobc-9DBAayt--eZLQkBMyrtCpUelbwYB1QeMT3nmig2YnKQRehBWMFSL8RGF4AQKBgF4-VZJDYtSRxMiy_8cTPx7a95skhHk-CgDz_Zc22tZi5uBr44DPJwhRpUDcyQD9YaDDVZG95vEsL4SoJYlCATzKfpb2kVE-ZujzbULGZM0ZXg9SJ94smx0I3Zq2OdIsbPP-yWSmLMBIJ3ZkVVm6azwydKZ8qAfmegLS_F2H49xFAoGBAJ-l7hAjSy2tN3XJNtQJH0vUyae-y6omSEXP22rwspcqchh8-7navsP6DR7C0npgLJn5PqHKmpeZEvvAHtjcGQcqIQxLBP2AxLdlUEBSlYoKEFy6sjwrDkkln8n6H0WecVPX2deRvquBqot9Iv_HQwlWTppYgcaqbV2l-N1fqc6Z";

        String data = params.get("data");
        String sign = params.get("sign");

        // 使用私钥匙解data
        RSAPrivateKey rsaPrivateKey = XRsa.getRSAPrivateKey(myPrivateKey);
        String json = XRsa.privateDecrypt(data, rsaPrivateKey);
        log.info("解data结果:{}", json);

        // 使用json验证签名
        RSAPublicKey rsaPublicKey = XRsa.getRSAPublicKey(oppositePublicKey);
        boolean verify = XRsa.verify(json, sign, rsaPublicKey);

        HashMap<String, Object> resultData = Maps.newHashMap();
        resultData.put("symbol", "BTC");
        resultData.put("balance", 1233434);
        String resultJson = JSONObject.toJSONString(resultData);


        HashMap<String, Object> map = Maps.newHashMap();
        if (verify) {
            map.put("code", 0);
            map.put("msg", "验证签名成功");
            map.put("data", XRsa.publicEncrypt(resultJson, rsaPublicKey));
            map.put("sign", XRsa.sign(resultJson, rsaPrivateKey));
        } else {
            map.put("code", 1);
            map.put("msg", "验证签名失败");
        }

        return map;
    }

    @PostMapping(value = "/requestBaas", produces = "application/json;charset=utf-8")
    @CrossOrigin(origins = "*")
    public Object requestBaas(@RequestBody Map<String, String> params) {
        log.info("/requestBaas request begin, params:{}", JSONObject.toJSONString(params));
        String appId = params.get("appId");
        String baasUrl = params.get("baasUrl");
        String oppositePublicKey = params.get("oppositePublicKey");
        String myPrivateKey = params.get("myPrivateKey");
        String jsonData = params.get("jsonData");

        HashMap<String, Object> map = Maps.newHashMap();
        RSAPublicKey rsaPublicKey = XRsa.getRSAPublicKey(oppositePublicKey);
        // 使用对方公钥加密得到data
        String data = XRsa.publicEncrypt(jsonData, rsaPublicKey);

        // 使用自己的私钥得到sign
        RSAPrivateKey rsaPrivateKey = XRsa.getRSAPrivateKey(myPrivateKey);
        String sign = XRsa.sign(jsonData, rsaPrivateKey);


        // 请求baas
        Map<String, Object> reqParams = Maps.newHashMap();
        reqParams.put("sign", sign);
        reqParams.put("data", data);
        reqParams.put("app_id", appId);
        reqParams.put("time", System.currentTimeMillis());
        String result = HttpUtils.sendPost(baasUrl, JSONObject.toJSONString(reqParams));
        log.info("request baas, url:{}, result:{}", baasUrl, result);

        if (StringUtils.isBlank(result)) {
            map.put("code", "-1");
            map.put("msg", "请求：" + baasUrl + ", 无返回数据！");
            return map;
        }



        JSONObject jsonObject = JSONObject.parseObject(result);
        String code = jsonObject.getString("code");
        map.put("code", "0");
        map.put("requestData", data);
        map.put("requestSign", sign);
        map.put("baasResult", result);
        if (!"0".equals(code)) {
            map.put("code", code);
            map.put("msg", jsonObject.getString("msg"));
        } else {
            String baasData = jsonObject.getString("data");
            if (StringUtils.isNotBlank(baasData)) {
                // 使用自己的私钥解密data
                baasData = XRsa.privateDecrypt(baasData, rsaPrivateKey);
                map.put("baasData", baasData);
            } else {
                return map;
            }
            String baasSign = jsonObject.getString("sign");
            // 验证baas返回的sign(使用对方公钥)
            if (StringUtils.isNotBlank(baasSign)) {
                map.put("baasSign", baasSign);
                boolean verify = XRsa.verify(baasData, sign, rsaPublicKey);
                if (verify) {
                    map.put("code", "-1");
                    map.put("msg", "验证baas签名sign失败");
                } else {
                    map.put("code", "0");
                    map.put("msg", "成功");
                }
            } else {
                map.put("code", "-1");
                map.put("msg", "baas未返回sign");
            }
        }
        return map;
    }



}
