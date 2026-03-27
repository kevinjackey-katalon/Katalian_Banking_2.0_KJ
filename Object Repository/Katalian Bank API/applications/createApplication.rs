<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createApplication</name>
   <tag></tag>
   <elementGuidId>61c7ad81-c35f-44a0-ab3a-eba87ef4a3fb</elementGuidId>
   <selectorMethod>XPATH</selectorMethod>
   <smartLocatorEnabled>true</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;accountType\&quot;: \&quot;Checking\&quot;,\n  \&quot;applicationData\&quot;: {\n    \&quot;zip\&quot;: \&quot;10001\&quot;,\n    \&quot;firstName\&quot;: \&quot;John\&quot;,\n    \&quot;lastName\&quot;: \&quot;Doe\&quot;,\n    \&quot;address\&quot;: \&quot;123 Main St\&quot;,\n    \&quot;initialDeposit\&quot;: 1000.0,\n    \&quot;city\&quot;: \&quot;New York\&quot;,\n    \&quot;dob\&quot;: \&quot;May 14, 1990, 8:00:00 PM\&quot;,\n    \&quot;depositFromAccountId\&quot;: \&quot;acc1-1\&quot;,\n    \&quot;middleName\&quot;: \&quot;Michael\&quot;,\n    \&quot;state\&quot;: \&quot;New York\&quot;\n  }\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>string</value>
      <webElementGuid>74e1af04-60b8-466d-a2aa-26919645de4f</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.0.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path>/applications</path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:3000/api/applications</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
