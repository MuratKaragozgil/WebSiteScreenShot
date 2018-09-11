# Web Site Screen Shot
Send urls of website and gets urls of screenshot of given websites

There is one endpoint for generating web site screenshots. 

### POST /screenshot/generate-screenshot

Example: Create – POST  http://localhost:8080/screenshot/generate-screenshot

Request body:

    [
        "http://www.google.com",
        "http://www.facebook.com"
    ]
    
Response body:

    [
        "http://localhost:8080/screenshot/29202ef3-f845-4b79-88e7-4411af6a2224",
        "http://localhost:8080/screenshot/29202ef3-f845-4b79-88e7-4411af6a2225"
    ]
