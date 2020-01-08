package com.tjh.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链 设计模式：demo消息过滤
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)0;<script>,欢迎访问www.tjh.com,大家都是996");

        //1 替换<script> 996敏感词
        /*String r = msg.getMsg();
        r = r.replace("<", "[");
        r = r.replace(">", "]");
        r = r.replace("996", "955");
        msg.setMsg(r);*/

        //2 引入Filter
        /*new HTMLFilter().doFilter(msg);
        new SensitiveFilter().doFilter(msg);*/

        //3 将Filter串起来 ===> 责任链
        /*List<Filter> filters = new ArrayList<>();
        filters.add(new HTMLFilter());
        filters.add(new SensitiveFilter());
        for (Filter filter : filters) {
            filter.doFilter(msg);
        }*/

        //4 简单封装一下
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain fc = new FilterChain();
        fc.add(new FaceFilter()).add(new URLFilter());

        filterChain.add(fc);

        filterChain.doFilter(msg);

        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("<", "[");
        r = r.replace(">", "]");
        m.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("996", "955");
        m.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace(":)", "==");
        m.setMsg(r);
        return true;
    }
}

class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("www.tjh.com", "baidu");
        m.setMsg(r);
        return true;
    }
}

//=========================
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}