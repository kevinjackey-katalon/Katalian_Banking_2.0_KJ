<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createLoan</name>
   <tag></tag>
   <elementGuidId>47d71d69-97f4-4aeb-85a7-6c427ab3a2a6</elementGuidId>
   <selectorMethod>XPATH</selectorMethod>
   <smartLocatorEnabled>true</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;loanType\&quot;: \&quot;Personal\&quot;,\n  \&quot;loanData\&quot;: {\n    \&quot;zip\&quot;: \&quot;10001\&quot;,\n    \&quot;lastName\&quot;: \&quot;Doe\&quot;,\n    \&quot;address\&quot;: \&quot;123 Main St\&quot;,\n    \&quot;annualIncome\&quot;: 85000,\n    \&quot;city\&quot;: \&quot;New York\&quot;,\n    \&quot;purpose\&quot;: \&quot;Home improvement\&quot;,\n    \&quot;jobTitle\&quot;: \&quot;Software Engineer\&quot;,\n    \&quot;loanAmount\&quot;: 10000,\n    \&quot;firstName\&quot;: \&quot;John\&quot;,\n    \&quot;loanTerm\&quot;: 36,\n    \&quot;dob\&quot;: \&quot;May 14, 1990, 8:00:00 PM\&quot;,\n    \&quot;employer\&quot;: \&quot;Tech Corp\&quot;,\n    \&quot;state\&quot;: \&quot;New York\&quot;\n  }\n}&quot;,
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
      <webElementGuid>8b56ff1e-2f94-4060-bcad-80d4b6f290fb</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.0.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path>/loans</path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:3000/api/loans</restUrl>
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
