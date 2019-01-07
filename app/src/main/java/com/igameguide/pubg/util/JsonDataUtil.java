package com.igameguide.pubg.util;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.igameguide.pubg.R;
import com.igameguide.pubg.base.PubgApplication;

import java.io.InputStream;

/**
 * 获取data.json里面的提供的数据
 */
public class JsonDataUtil {
    private static String umengkeyid;
    private static String bundleid;
    private static String adUnitIDScreen;
    private static String adUnitIDBanner;


    private static class Holder {
        public static JsonDataUtil jsonDataUtil = new JsonDataUtil();
    }

    public JsonDataUtil getInstance() {
        return Holder.jsonDataUtil;
    }

    public static String getUmengkeyid() {
        if (TextUtils.isEmpty(umengkeyid)) {
            init();
        }
        return umengkeyid;
    }

    public static String getBundleid() {
        if (TextUtils.isEmpty(bundleid)) {
            init();
        }
        return bundleid;
    }

    public static String getAdUnitIDScreen() {
        if (TextUtils.isEmpty(adUnitIDScreen)) {
            init();
        }
        return adUnitIDScreen;
    }

    public static String getAdUnitIDBanner() {
        if (TextUtils.isEmpty(getAdUnitIDBanner())) {
            init();
        }
        return adUnitIDBanner;
    }

    private static void init() {
        String json = getFromRaw();
        if (TextUtils.isEmpty(json)) {
            return;
        }
        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject == null) {
            return;
        }
        umengkeyid = jsonObject.getString("umengkeyid");
        bundleid = jsonObject.getString("bundleid");
        adUnitIDScreen = jsonObject.getString("ADUnitID_Banner");
        adUnitIDBanner = jsonObject.getString("ADUnitID_Screen");

    }

    /**
     * 从raw文件获取字符
     *
     * @return
     */
    public static String getFromRaw() {
        String result = "";
        try {
            InputStream in = PubgApplication.getInstance().getResources().openRawResource(R.raw.data);
            //获取文件的字节数
            int lenght = in.available();
            //创建byte数组
            byte[] buffer = new byte[lenght];
            //将文件中的数据读到byte数组中
            in.read(buffer);
            result = new String(buffer, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
