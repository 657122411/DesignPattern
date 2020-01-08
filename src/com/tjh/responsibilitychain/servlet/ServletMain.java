package com.tjh.responsibilitychain.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * servlet中的request response过责任链
 * request过1 2 response过2 1 使用同一个责任链
 */
public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        request.str = "request";
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter()).add(new SensitiveFilter());
        chain.doFilter(request, response, chain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}


interface Filter {
    boolean doFilter(Request req, Response res, FilterChain chain);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request req, Response res, FilterChain chain) {
        req.str = req.str.replaceAll("<", "[").replaceAll(">", "]") + "--HTMLFilter()";
        chain.doFilter(req, res, chain);
        res.str += "--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request req, Response res, FilterChain chain) {
        req.str = req.str.replaceAll("996", "955") + "--SensitiveFilter()";
        chain.doFilter(req, res, chain);
        res.str += "--SensitiveFilter()";
        return true;
    }
}

//=========================
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request req, Response res, FilterChain chain) {
        if (index == filters.size()) {
            return false;
        }
        Filter f = filters.get(index);
        index++;
        return f.doFilter(req, res, chain);
    }
}