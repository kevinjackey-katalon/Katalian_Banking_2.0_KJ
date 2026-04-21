package truetest.Katalian_Banking_QA.custom

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import groovy.json.JsonSlurper
import internal.GlobalVariable
import java.util.regex.Pattern
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

public class TrueTestScripts {
    
    public static void login(Map parameters = [:]) {
        try {
            // Trigger a Login test case
            // import com.kms.katalon.core.model.FailureHandling
            // import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
            // import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
            WebUI.callTestCase(findTestCase('Test Cases/01 - Demo Materials/Self Healing_Data Binding Demonstration/Login - Self Healing_Data Binding Demonstration'), [:], FailureHandling.CONTINUE_ON_FAILURE)
            // Trigger a custom Login method
            // import your.package
            // import authentication.Login
            // call your custom login method
            // Login.login()
            // Trigger a custom Login keyword
            // CustomKeywords.login()
        } catch(Exception e) {
            if (e.getCause() instanceof WebElementNotFoundException) {
                KeywordUtil.logInfo(e.getMessage())
                KeywordUtil.markWarning(e.getMessage())
            } else {
                throw e
            }
        }
    }
    
    static Integer DELAY_TIME = 3 // in seconds
    
    private static String combineUrlQueryParams(Map<String, String> queryParams) {
        String queryParameters = "";
        try {
            queryParameters = GlobalVariable.query_params;
        }
        catch (Exception e) {
            KeywordUtil.logInfo(e.getMessage());
        }
        for (Map.Entry<String, String> param: queryParams) {
            if (queryParameters.length() > 0) {
                queryParameters += "&";
            }
            queryParameters += "${param.getKey()}=${param.getValue()}";
        }
        return queryParameters;
    }
    
    private static void do_navigate(String path, String queryParameters) {
        String applicationDomain = GlobalVariable.application_domain;
        if (path == null) {
            path = "";
        }
        if (!path.startsWith("/")) {
            path = "/$path";
        }
        String url = "$applicationDomain$path";
        if (queryParameters != null && queryParameters.length() > 0) {
            url = "$url?$queryParameters";
        }
        WebUI.navigateToUrl(url);
        WebUI.delay(DELAY_TIME);
    }
    
    public static void navigate(String path, Map<String, String> searchParams) {
        String queryParameters = this.combineUrlQueryParams(searchParams);
        this.do_navigate(path, queryParameters);
    }
    
    public static void navigate(String path) {
        this.do_navigate(path, "");
    }
    
    public static void selectOption(TestObject to, String rawValue, String selectionMode, boolean shouldFireEvent = false) {
        selectionMode = selectionMode?.toLowerCase() ?: "value"
        
        def parsedValue = rawValue
        if (!parsedValue.startsWith("[")) {
            parsedValue = "[\"" + parsedValue + "\"]"
        }
        
        def jsonSlurper = new JsonSlurper()
        def options = jsonSlurper.parseText(parsedValue)
        
        if (options && options[0] instanceof Map) {
            options = options.collect {
                switch (selectionMode) {
                    case "value":
                    return it.value
                    case "label":
                    return it.label
                    case "index":
                    return it.index
                    default:
                    throw new IllegalArgumentException("Unsupported selection mode: " + selectionMode)
                }
            }
        }
        
        for (option in options) {
            switch (selectionMode) {
                case "value":
                WebUI.selectOptionByValue(to, Pattern.quote(option.toString()), true, FailureHandling.OPTIONAL)
                WebUI.verifyOptionSelectedByValue(to, Pattern.quote(option.toString()), true, 5)
                break
                case "label":
                WebUI.selectOptionByLabel(to, Pattern.quote(option.toString()), true, FailureHandling.OPTIONAL)
                WebUI.verifyOptionSelectedByLabel(to, Pattern.quote(option.toString()), true, 5)
                break
                case "index":
                def index
                try {
                    index = option instanceof Number ? option.intValue() : Integer.parseInt(option.toString())
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid index value: " + option.toString() + ". Index must be a number.", e)
                }
                WebUI.selectOptionByIndex(to, index, FailureHandling.OPTIONAL)
                WebUI.verifyOptionSelectedByIndex(to, index, 5)
                break
                default:
                throw new IllegalArgumentException("Unsupported selection mode: " + selectionMode)
            }
        }
        
        if (shouldFireEvent) {
            def webElement = WebUI.findWebElement(to);
            WebUI.executeJavaScript("let event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);", [webElement])
        }
    }
    
    public static void selectOptionByValue(TestObject to, String rawValue) {
        def parsedValue = rawValue
        if (!parsedValue.startsWith("[")) {
            parsedValue = "[\"" + parsedValue + "\"]"
        }
        def jsonSlurper = new JsonSlurper()
        def options = jsonSlurper.parseText(parsedValue)
        for (option in options) {
            WebUI.selectOptionByValue(to, Pattern.quote(option), true)
        }
    }
    
    public static void setSliderValue(TestObject to, double value) {
        WebUI.delay(1)
        WebUI.enhancedClick(to)
        def sliderElement = WebUiCommonHelper.findWebElement(to, 30)
        double sliderWidth = Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getBoundingClientRect().width", Arrays.asList(sliderElement)).toString())
        def sliderHandleElement = WebUI.executeJavaScript("return arguments[0].querySelector('[role=slider]')", Arrays.asList(sliderElement))
        double min =  Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getAttribute('aria-valuemin')", Arrays.asList(sliderHandleElement)).toString())
        double max =  Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getAttribute('aria-valuemax')", Arrays.asList(sliderHandleElement)).toString())
        double currentValue = Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getAttribute('aria-valuenow')", Arrays.asList(sliderHandleElement)).toString())
        int offsetX = Math.floor(((value - currentValue) / (max - min)) * sliderWidth)
        WebUI.dragAndDropByOffset(to, offsetX, 0)
    }
    
    public static void setTinyMCEContent(TestObject to, String content) {
        WebUI.waitForElementClickable(to, 30)
        def result = WebUI.executeJavaScript(
        """
        const mceInstance = window.tinyMCE?.activeEditor;
        if (!mceInstance) {
            return "No TinyMCE instance found";
        }
        return mceInstance.setContent(arguments[0]);
        """,
        [content]
        ).toString();
        WebUI.comment('Content of tinyMCE is set to ' + result)
    }
    
    public static void dragAndDropToTargetByDirection(TestObject sourceTo, TestObject targetTo, String direction = "CENTER", int padding = 10) {
        boolean isSwitchIntoFrame = false
        try {
            isSwitchIntoFrame = WebUiCommonHelper.switchToParentFrame(sourceTo)
            WebElement sourceEl = WebUIAbstractKeyword.findWebElement(sourceTo)
            WebElement targetEl = WebUIAbstractKeyword.findWebElement(targetTo)
            Actions builder = new Actions(DriverFactory.getWebDriver())
            
            int width = targetEl.getSize().getWidth()
            int height = targetEl.getSize().getHeight()
            int midX = (int) Math.floor(width / 2)
            int midY = (int) Math.floor(height / 2)
            
            int x = 0
            int y = 0
            
            switch (direction) {
                case "TOP":          x = 0;          y = -(midY - padding);     break
                case "BOTTOM":        x = 0;          y = (midY - padding); break
                case "LEFT":        x = -(midX - padding);    y = 0;          break
                case "RIGHT":       x = (midX - padding);  y = 0; break
                case "TOP_LEFT":     x = -(midX - padding);     y = -(midY - padding);     break
                case "TOP_RIGHT":    x = (midX - padding);  y = -(midY - padding);     break
                case "BOTTOM_LEFT":   x = -(midX - padding);     y = (midY - padding); break
                case "BOTTOM_RIGHT":  x = (midX - padding);  y = (midY - padding); break
                case "CENTER": x = 0; y = 0; break
            }
            
            builder.clickAndHold(sourceEl).moveToElement(targetEl, x, y).release().perform()
        } finally {
            if (isSwitchIntoFrame) {
                WebUiCommonHelper.switchToDefaultContent()
            }
        }
    }
    
    public static switchToNextWindow() {
        def driver = DriverFactory.getWebDriver()
        def currentHandle = driver.getWindowHandle()
        Object[] windowHandles = driver.getWindowHandles().toArray();
        int indexOfCurrent = -1
        for (int i = 0; i < windowHandles.length; i++) {
            String handle = (String) windowHandles[i]
            if (currentHandle.equals(handle)) {
                indexOfCurrent = i
                break
            }
        }
        if (indexOfCurrent >= 0  && indexOfCurrent < windowHandles.length - 1) {
            driver.switchTo().window((String) windowHandles[indexOfCurrent + 1])
        } else {
            WebUI.comment("Cannot find next window.")
        }
    }
}

