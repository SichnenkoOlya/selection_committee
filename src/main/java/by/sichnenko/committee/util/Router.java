package by.sichnenko.committee.util;

import by.sichnenko.committee.type.RouterType;

public class Router {
    private RouterType routerType = RouterType.FORWARD;

    private String routPage;

    public Router(String routPage) {
        this.routPage = routPage;
    }

    public Router(RouterType routerType, String routPage) {
        this.routerType = routerType;
        this.routPage = routPage;
    }

    public RouterType getRouterType() {
        return routerType;
    }

    public void setRouterType(RouterType routerType) {
        if (routerType == null) {
            this.routerType = RouterType.FORWARD;
        }
        this.routerType = routerType;
    }

    public String getRouterPage() {
        return routPage;
    }

    public void setRouterPage(String routPage) {
        this.routPage = routPage;
    }
}
