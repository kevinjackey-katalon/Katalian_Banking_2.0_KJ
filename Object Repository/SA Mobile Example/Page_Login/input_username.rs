<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>Username/Secure ID input field for Katalian Banking Android login.</description>
   <name>input_username</name>
   <tag></tag>
   <elementGuidId>d93ac5f8-b970-4a2f-aaef-cc24d46fca83</elementGuidId>
   <origin>STUDIOASSIST</origin>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <locatorCollection>
      <entry>
         <key>XPATH</key>
         <value>(//android.widget.EditText[@text='Username' or @text='Secure ID' or @text='SecureID' or @content-desc='Username' or @content-desc='Secure ID' or @resource-id='username' or @resource-id='secureId' or contains(@resource-id,'username') or contains(@resource-id,'secureId') or contains(@resource-id,'secure-id') or contains(@resource-id,'email') or @hint='Username' or @hint='Secure ID'] | //android.widget.EditText)[1]</value>
      </entry>
   </locatorCollection>
   <locatorStrategy>XPATH</locatorStrategy>
   <platform>ANDROID</platform>
</MobileElementEntity>
