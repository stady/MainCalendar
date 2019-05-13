package com.jjforever.wgj.maincalendar.http;

import com.alibaba.fastjson.JSON;
import com.jjforever.wgj.maincalendar.bean.Dream;
import com.jjforever.wgj.maincalendar.bean.NWeatherBody;
import com.jjforever.wgj.maincalendar.bean.Star;
import com.jjforever.wgj.maincalendar.bean.TodayHistory;
import com.jjforever.wgj.maincalendar.bean.TodayHistoryDetail;
import com.jjforever.wgj.maincalendar.data.URL;

import org.json.JSONObject;

import java.util.List;

/**
 * 网络请求
 * create by xyl on 2019/5/13 16:04
 */
public class BUSHTTP {


    /**
     * 获取天气信息
     * @param cityName 城市名字
     * @param callBack
     */
    public static void fetchWeather(String cityName,final FetcherCallBack<NWeatherBody> callBack){
        String url = URL.URL_WEATHER + cityName;
        HttpUtil.httpGet(url, new FetcherCallBack<String>() {
            @Override
            public void fetcherSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.optInt("error_code");
                    String msg = jsonObject.optString("reason");
                    String body = jsonObject.optString("data");
                    if (code == 0){
                        if (callBack != null) {
                            NWeatherBody data = JSON.parseObject(body,NWeatherBody.class);
                            callBack.fetcherSuccess(data);
                        }
                    }else{
                        if (callBack != null) {
                            callBack.fetcherFail(code, msg);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.fetcherFail(-2, "数据解析错误");
                    }
                }
            }

            @Override
            public void fetcherFail(int code, String msg) {
                if (callBack != null) {
                    callBack.fetcherFail(code, msg);
                }
            }
        });
    }



    /**
     * 获取历史上的今天信息
     * @param date 日期
     * @param callBack
     */
    public static void fetchHistoryList(String date,final FetcherCallBack<List<TodayHistory>> callBack){
        String url = URL.URL_History + date;
        HttpUtil.httpGet(url, new FetcherCallBack<String>() {
            @Override
            public void fetcherSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.optInt("error_code");
                    String msg = jsonObject.optString("reason");
                    String body = jsonObject.optString("data");
                    if (code == 0){
                        if (callBack != null) {
                            List<TodayHistory> data = JSON.parseArray(body,TodayHistory.class);
                            callBack.fetcherSuccess(data);
                        }
                    }else{
                        if (callBack != null) {
                            callBack.fetcherFail(code, msg);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.fetcherFail(-2, "数据解析错误");
                    }
                }
            }

            @Override
            public void fetcherFail(int code, String msg) {
                if (callBack != null) {
                    callBack.fetcherFail(code, msg);
                }
            }
        });
    }


    /**
     * 获取历史上的今天详情
     * @param date eid
     * @param callBack
     */
    public static void fetchHistoryDetail(String date,final FetcherCallBack<TodayHistoryDetail> callBack){
        String url = URL.URL_History_detail + date;
        HttpUtil.httpGet(url, new FetcherCallBack<String>() {
            @Override
            public void fetcherSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.optInt("error_code");
                    String msg = jsonObject.optString("reason");
                    String body = jsonObject.optString("data");
                    if (code == 0){
                        if (callBack != null) {
                            TodayHistoryDetail data = JSON.parseObject(body,TodayHistoryDetail.class);
                            callBack.fetcherSuccess(data);
                        }
                    }else{
                        if (callBack != null) {
                            callBack.fetcherFail(code, msg);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.fetcherFail(-2, "数据解析错误");
                    }
                }
            }

            @Override
            public void fetcherFail(int code, String msg) {
                if (callBack != null) {
                    callBack.fetcherFail(code, msg);
                }
            }
        });
    }


    /**
     * 周公解梦
     * @param keywords 关键词
     * @param callBack
     */
    public static void fetchDream(String keywords,final FetcherCallBack<List<Dream>> callBack){
        String url = URL.URL_DREAM + keywords;
        HttpUtil.httpGet(url, new FetcherCallBack<String>() {
            @Override
            public void fetcherSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.optInt("error_code");
                    String msg = jsonObject.optString("reason");
                    String body = jsonObject.optString("data");
                    if (code == 0){
                        if (callBack != null) {
                            List<Dream> data = JSON.parseArray(body,Dream.class);
                            callBack.fetcherSuccess(data);
                        }
                    }else{
                        if (callBack != null) {
                            callBack.fetcherFail(code, msg);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.fetcherFail(-2, "数据解析错误");
                    }
                }
            }

            @Override
            public void fetcherFail(int code, String msg) {
                if (callBack != null) {
                    callBack.fetcherFail(code, msg);
                }
            }
        });
    }


    /**
     * 星座
     * @param constellation 星座
     * @param callBack
     */
    public static void fetchStar(String constellation,final FetcherCallBack<Star> callBack){
        String url = URL.URL_XINGZUO + constellation;
        HttpUtil.httpGet(url, new FetcherCallBack<String>() {
            @Override
            public void fetcherSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.optInt("error_code");
                    String msg = jsonObject.optString("reason");
                    String body = jsonObject.optString("data");
                    if (code == 0){
                        if (callBack != null) {
                            Star data = JSON.parseObject(body,Star.class);
                            callBack.fetcherSuccess(data);
                        }
                    }else{
                        if (callBack != null) {
                            callBack.fetcherFail(code, msg);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.fetcherFail(-2, "数据解析错误");
                    }
                }
            }

            @Override
            public void fetcherFail(int code, String msg) {
                if (callBack != null) {
                    callBack.fetcherFail(code, msg);
                }
            }
        });
    }
}
