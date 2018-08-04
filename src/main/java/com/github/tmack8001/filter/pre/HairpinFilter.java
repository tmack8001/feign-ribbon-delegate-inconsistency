package com.github.tmack8001.filter.pre;

import com.github.tmack8001.client.BarServiceClient;
import com.github.tmack8001.client.FooServiceClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class HairpinFilter extends ZuulFilter {

    private BarServiceClient barClient;
    private FooServiceClient fooClient;

    @Autowired
    public HairpinFilter(BarServiceClient barClient, FooServiceClient fooClient) {
        this.barClient = barClient;
        this.fooClient = fooClient;

    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        String proxyKey = (String) RequestContext.getCurrentContext().get(FilterConstants.PROXY_KEY);
        switch (proxyKey) {
            case "foo-route":
                barClient.get(proxyKey, getClass().getSimpleName());
                break;
            case "bar-route":
                fooClient.get(proxyKey, getClass().getSimpleName());
                break;
            default:
                break;
        }

        return null;
    }
}
