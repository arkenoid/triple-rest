method get
url http://localhost:8383/getQuestion
auth : basic (username:user,password:password)


response hader
Status Code: 200 OK

response body
    {
       "id": 1,
       "content": "Hello, pollFri Aug 08 00:32:08 WIB 2014!"
    }