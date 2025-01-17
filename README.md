
### Compile for deployment
To compile the team must have Apache Maven and Java 21 (or the version used) installed.

```bash
mvn clean package -DskipTests
```
### 
```bash
docker run --rm -d --name postgres-container -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=restaurantdb -p 5432:5432 postgres:latest
```