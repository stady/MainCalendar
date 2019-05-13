package com.jjforever.wgj.maincalendar.http;

/**
 *
 * create by xyl on 2019/5/13 15:15
 */
public interface FetcherCallBack<T> {
    void fetcherSuccess(T result);
    void fetcherFail(int code,String msg);
}
