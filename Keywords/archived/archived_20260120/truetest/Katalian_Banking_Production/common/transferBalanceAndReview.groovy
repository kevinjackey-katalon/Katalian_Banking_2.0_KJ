package archived.archived_20260120.truetest.Katalian_Banking_Production.common

import com.kms.katalon.core.testdata.TestData as TestData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Katalian_Banking_Production.custom.TrueTestScripts

public class transferBalanceAndReview {
    
    private static def execute(String input_amount, String select_fromAccount) {
        
        "Step 1: Click on button transferBalance -> Navigate to page '/transfer'"
        
        WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_dashboard/button_transferBalance'))
        
        "Step 2: Select option with input value from select fromAccount"
        
        TrueTestScripts.selectOption(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/select_fromAccount'), select_fromAccount, "label", false)
        
        "Step 3: Click on input amount"
        
        WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/input_amount'))
        
        "Step 4: Enter input value in input amount"
        
        WebUI.setText(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/input_amount'), input_amount)
        
        "Step 5: Click on button reviewTransfer"
        
        WebUI.enhancedClick(findTestObject('Archived/Archived_20260120/Katalian Banking Production/Page_transfer/button_reviewTransfer'))
    }
}

