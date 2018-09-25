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

GET ONE CONTACT EXAMPLE:

```
http://localhost:8080/contacts/{id}
```

GET ALL CONTACTS EXAMPLE:

```
http://localhost:8080/contacts
```

DELETE BY ID EXAMPLE:
```
http://localhost:8080/contacts/{id}
```