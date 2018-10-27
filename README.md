# kotlinapi
API com Spring Boot e Kotlin

# Run in Terminal
gradle bootRun

** IMPORTANT: You should install mongoDB on your pc


POST EXAMPLE:

```
http://localhost:8080/contacts

{
	"name":"luiz",
	"email":"luiz@gmail.com",
	"phoneNumber":"(13)3333-3333"
}
```

PUT EXAMPLE:

```
http://localhost:8080/contacts/{id}

{
	"name":"Luiz Henrique",
	"email":"luiz@gmail.com",
	"phoneNumber":"(13)3333-3333"
}
```

GET ONE CONTACT EXAMPLE:

```
http://localhost:8080/contacts/{id}
```

GET ALL CONTACTS EXAMPLE:

```
http://localhost:8080/contacts?page=0
*Maximum itens per page is 20.
```

DELETE BY ID EXAMPLE:
```
http://localhost:8080/contacts/{id}
```