

/* Bulk Endpoint Creation Task:
 Build me API objects for all endpoints found at http://localhost:3000/api. 
 Place these endpoint into the API AI Demo folder in the Object Repository.
 Build a separate subfolder for each resource (e.g. Users, Accounts, etc.) and place the relevant endpoint objects in each folder.
 
 Relevant Endpoints:
   GET  /api/users          - Get all users                
   GET  /api/users/:id      - Get user by ID               
   POST /api/transfers      - Execute transfer             
   POST /api/deposits       - Execute deposit              
   POST /api/applications   - Submit account application   
   POST /api/loans          - Submit loan application      
   GET  /api/health         - Health check 
 */

/*
 Studio Prompts:

	 A. Build me a REST API script that performs the following steps.
	 B. Ensure that object repository objects are created and used in the script, if objects already exist then use the existing objects but ensure they have the correct configuration (e.g. HTTP method, URL, headers, etc.) to perform the steps below
	 C. Validate that all includes are present and document the test steps
	 D. All output statements should user KeywordUtil.logInfo
	 E. Place the test script generated into a test suite named "API Demo Test Suite"
	 F. All items should be placed in an "API AI Demo" folder in their respective sections
 
 
 Steps:
 1. Open endpoint
 'http://localhost:3000/api/users'
	 2. Perform a GET request to retrieve user details from the above endpoint
	 3. Validate that an HTTP 200 response code is returned
	 4. Parse the response body and extract all available usernames, then display them
	 5. Validate that 'bankinguser123' is included as a username in the response list
 
 Once the above items are done then execute the generated test suite and send the results to the "Katalian Banking 2.0" project with run name of "API Demo Run"
 
 */