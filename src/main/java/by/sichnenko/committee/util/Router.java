package by.sichnenko.committee.util;

import by.sichnenko.committee.type.RouterType;

import static by.sichnenko.committee.constant.PageNameConstant.INDEX_PAGE;

public class Router {
    private RouterType routerType = RouterType.FORWARD;
    private String routPage = INDEX_PAGE;

    /**
     * Constructor with params.
     *
     * @param routPage page which will be shown
     */
    public Router(String routPage) {
        this.routPage = routPage;
    }

    /**
     * Constructor with params.
     *
     * @param routerType type of router
     * @see RouterType
     */
    public Router(RouterType routerType) {
        this.routerType = routerType;
    }

    /**
     * Constructor with params.
     *
     * @param routerType type of router
     * @param routPage   page which will be shown
     * @see RouterType
     */
    public Router(RouterType routerType, String routPage) {
        this.routerType = routerType;
        this.routPage = routPage;
    }

    /**
     * Getter for routerType.
     *
     * @return type of router
     * @see RouterType
     */
    public RouterType getRouterType() {
        return routerType;
    }

    /**
     * Getter for routPage.
     *
     * @return page which will be shown
     */
    public String getRouterPage() {
        return routPage;
    }

}
