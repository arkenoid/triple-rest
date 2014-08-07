jalanin pake gradle bootRun

test di firefox rest client
-method=POST
-url=http://localhost:8282/register.jsp?name=testing

harus nya dapet response header:
    Status Code: 201 Created
    Content-Length: 0
    Date: Thu, 07 Aug 2014 17:23:09 GMT
    Server: Apache-Coyote/1.1

dan di console ada :
Registration [id=1, content=Hello, testing!]

