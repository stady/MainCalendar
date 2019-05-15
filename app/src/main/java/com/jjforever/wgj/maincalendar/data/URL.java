package com.jjforever.wgj.maincalendar.data;

/**
 *
 * create by xyl on 2019/5/13 15:17
 */
public class URL {
    public static  String BASE_API = "https://api.shenjian.io";
    public static  String APP_ID = "a5dbd4e5ae65a84e4e665a9c65c293a7";

    //https://api.shenjian.io/constellation/today/?appid=a5dbd4e5ae65a84e4e665a9c65c293a7&constellation=%E5%B0%84%E6%89%8B%E5%BA%A7
    public static  String URL_XINGZUO = BASE_API + "/constellation/today?appid="
    +APP_ID + "&constellation=";

    //https://api.shenjian.io/?appid=8be8529fa114b7db3d628a00212793fa&city_name=%E5%8C%97%E4%BA%AC
    public static  String URL_WEATHER = BASE_API + "?appid="
            +"8be8529fa114b7db3d628a00212793fa" + "&city_name=";

    //https://api.shenjian.io/dream/query/?appid=2f1f8b4c71503ffe0c0978d27d4ec47a&keyword=%E8%9B%87
    public static  String URL_DREAM = BASE_API + "/dream/query/?appid=2f1f8b4c71503ffe0c0978d27d4ec47a&keyword=";

    // 4/16 格式 4月16日  4月6日 格式为 4/6 不要加0
    //https://api.shenjian.io/todayOnhistory/queryEvent?appid=03d989c4d42c3d8cae555659892adfdd&date=4/16
    public static  String URL_History = BASE_API + "/todayOnhistory/queryEvent?appid="
            +"03d989c4d42c3d8cae555659892adfdd" + "&date=";

    // URL_History 接口返回的eid date
    //https://api.shenjian.io/todayOnhistory/queryDetail?appid=03d989c4d42c3d8cae555659892adfdd&date=17420
    public static  String URL_History_detail = BASE_API +
            "/todayOnhistory/queryDetail?appid=03d989c4d42c3d8cae555659892adfdd&date=";
}
