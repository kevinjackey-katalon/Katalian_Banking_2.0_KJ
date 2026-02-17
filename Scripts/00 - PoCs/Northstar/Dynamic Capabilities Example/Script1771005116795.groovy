import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable

/**
 * Dynamic Desired Capabilities demo
 *
 * Pre-req:
 * - Execute this test case with an execution profile that defines:
 *   GlobalVariable.platformName, GlobalVariable.deviceName,
 *   GlobalVariable.platformVersion, GlobalVariable.udid
 *
 * Note:
 * - These properties are applied BEFORE the mobile driver session is created.
 * - Start the driver AFTER setting these capabilities (e.g., Mobile.startApplication()).
 */

// Log what we are about to apply (helps debugging when switching profiles)
KeywordUtil.logInfo("Applying mobile caps from profile: " +
		"platformName=${GlobalVariable.platformName}, " +
		"deviceName=${GlobalVariable.deviceName}, " +
		"platformVersion=${GlobalVariable.platformVersion}, " +
		"udid=${GlobalVariable.udid}")

// --- Apply desired capabilities at runtime ---
// Katalon will send these to Appium when creating the session.
RunConfiguration.setMobileDriverPreferencesProperty('platformName', GlobalVariable.platformName)
RunConfiguration.setMobileDriverPreferencesProperty('deviceName', GlobalVariable.deviceName)
RunConfiguration.setMobileDriverPreferencesProperty('platformVersion', GlobalVariable.platformVersion)
RunConfiguration.setMobileDriverPreferencesProperty('udid', GlobalVariable.udid)

// Optional: If your Appium setup expects W3C-prefixed capability names, you can also set them.
// (Leaving these enabled is usually harmless; remove if your server rejects unknown caps.)
RunConfiguration.setMobileDriverPreferencesProperty('appium:platformName', GlobalVariable.platformName)
RunConfiguration.setMobileDriverPreferencesProperty('appium:deviceName', GlobalVariable.deviceName)
RunConfiguration.setMobileDriverPreferencesProperty('appium:platformVersion', GlobalVariable.platformVersion)
RunConfiguration.setMobileDriverPreferencesProperty('appium:udid', GlobalVariable.udid)

// --- Create the driver session AFTER setting capabilities ---
// Replace '<path-to-app>' with your AUT, or use startExistingApplication for an already-installed app.
// Mobile.startApplication('<path-to-app>', false)

// Demo placeholder: if you don't start an app here, no Appium session is created.
KeywordUtil.logInfo('Capabilities set. Start the app to initiate the Appium session.')

// Mobile.closeApplication()
