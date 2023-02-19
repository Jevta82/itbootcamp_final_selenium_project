package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{
    @Test(priority = 1)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseURL+"/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL + "/login", "Not on login page.");
    }

    @Test(priority = 2)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseURL+"/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL + "/login", "Not on login page.");
    }

    @Test(priority = 3)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseURL+"/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL + "/login", "Not on login page.");

    }
    @Test(priority = 4)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseURL+"/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL + "/login", "Not on login page.");
    }
}
