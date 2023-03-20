package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ReportSetup {

    private ExtentSparkReporter htmlReport;
    private ExtentReports extent;
    private ExtentTest testReport;

    private final String pathReport = System.getProperty("user.dir") + "/target/report/";

    public ReportSetup(String reportName) {
        createDirectory();
        deleteFiles();
        createReport(reportName);
    }

    public ReportSetup() {
        createDirectory();
        deleteFiles();
        createReport();
    }

    public void createDirectory(){
        File directory = new File(pathReport);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }

    public void deleteFiles(){
        File directory = new File(pathReport);
        File [] listFiles = directory.listFiles();
        for(Integer i =0; i < listFiles.length; i++){
            listFiles[i].delete();
        }
    }

    public void createReport(String reportName){
        htmlReport = new ExtentSparkReporter("target/report/"+reportName+".html");
        htmlReport.config().setTheme(Theme.DARK);
        extent = new ExtentReports();

        extent.attachReporter(htmlReport);
        testReport=extent.createTest("" + reportName+ "- report");
        attacheReport("info", "--- Start "+ reportName+" test ---");
    }

    public void createReport(){
        htmlReport = new ExtentSparkReporter("target/report/Report.html");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setReportName("Report Demo");
        htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReport);
    }


    public void attacheReport(String entryType, String mesaj)
    {
        if(entryType.equals("info")){
            testReport.log(Status.INFO, mesaj);
        }
        if(entryType.equals("pass")){
            testReport.log(Status.PASS, mesaj);
        }
    }

    public void attacheReport(String entryType, String mesaj, WebDriver driver, String reportName)
    {
        if(entryType.equals("fail")){
            System.out.println("test");
        }
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getTestReport() {
        return testReport;
    }
}
