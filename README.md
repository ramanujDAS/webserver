# webserver
webserver

Simple Java Web Server
This is a simple web server implemented in Java. It supports handling GET, POST, and DELETE requests and serves files based on the URL.

Features
GET Requests: Retrieve files from the server.
POST Requests: Upload files to the server.
DELETE Requests: Delete files from the server.
File Serving: Serves static files based on the URL.
Requirements
Java Development Kit (JDK) 8 or higher
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/webserver.git
cd simple-java-webserver
Compile the server:

bash
Copy code
javac -d bin src/*.java
Usage
Run the server:

bash
Copy code
java -cp bin WebServer
The server will start running on http://localhost:8080 by default.

API Endpoints
GET Request
Retrieve a file:

http
Copy code
GET /path/to/file HTTP/1.1
Host: localhost:8080
This request will return the file located at path/to/file on the server.

POST Request
Upload a file:

http
Copy code
POST /upload HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data; boundary=boundary
Content-Length: [length]

--boundary
Content-Disposition: form-data; name="file"; filename="filename.ext"
Content-Type: application/octet-stream

[file content]
--boundary--
This request will upload the specified file to the server.

DELETE Request
Delete a file:

http
Copy code
DELETE /path/to/file HTTP/1.1
Host: localhost:8080
This request will delete the file located at path/to/file on the server.

File Structure
src/: Contains the Java source files.
bin/: Directory where the compiled classes are stored.
public/: Directory where the static files are served from.
Example
To test the server, you can use tools like curl or Postman.

GET Request:

bash
Copy code
curl http://localhost:8080/path/to/file
POST Request:

bash
Copy code
curl -F "file=@/path/to/local/file" http://localhost:8080/upload
DELETE Request:

bash
Copy code
curl -X DELETE http://localhost:8080/path/to/file
License
This project is licensed under the MIT License - see the LICENSE file for details.
