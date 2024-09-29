package com.api.Suite.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    public ExtentReports extent;
    public ExtentTest test;
    private static final String extentReportDirectory;
    private static final String timestamp;
    private static final String fileSeparator;

    static {
        fileSeparator = File.separator;
        extentReportDirectory = System.getProperty("user.dir") + fileSeparator + "reports" + fileSeparator + "html-report";
        timestamp = (new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")).format(new Date());
    }

    @BeforeSuite
    public void initializeTest(){

        extent = new ExtentReports();// Passing General information
        extent.setSystemInfo("Application Name", "My Projects");
        extent.setSystemInfo("Build No", "101");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Test Developer", "NameOfPerson Or Project");
    }
}
