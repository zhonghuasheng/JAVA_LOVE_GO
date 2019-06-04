package com.zhonghuasheng.spring4.autowiringusingxml.autowirebyname;

public class Application {

    private ApplicationUser applicationUser;

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    @Override
    public String toString() {
        return "Application [applicationUser=" + applicationUser + "]";
    }
}
