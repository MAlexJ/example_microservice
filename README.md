### Project setup

* Java 23
* Springboot 3.4.2
* Gradle 8.12.1

### Project configuration

###### Add properties to `.env` file:

RabbitMQ
link: https://www.cloudamqp.com (Message Queues in the Cloud)

```
RABBITMQ_HOST=cow.rmq2.cloudamqp.com
RABBITMQ_PORT=5672
RABBITMQ_USERNAME=......
RABBITMQ_PASSWORD=........
RABBITMQ_VIRTUAL_HOST=......
```

MySQL
link: https://aiven.io (MYSQL cloud database)
MySQL 8.0.30 / Free-1-5gb / 1 CPU / 1 GB RAM / 5 GB storage

```
DB_MYSQL_HOSTNAME=......aivencloud.com
DB_MYSQL_PORT=25371
DB_MYSQL_DBNAME=..
DB_MYSQL_USER=....
DB_MYSQL_PASSWORD=....
DB_MYSQL_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
```

Postgresql
link: https://aiven.io (Postgresql cloud database)
PostgreSQL 16.3 / Free-1-5gb / 1 CPU / 1 GB RAM / 5 GB storage

or

link: https://www.elephantsql.com
Max database size 20 MB

```
DB_POSTGRESQL_HOSTNAME=.....
DB_POSTGRESQL_DBNAME=....
DB_POSTGRESQL_USER=....
DB_POSTGRESQL_PASSWORD=.....
```

Mongo Atlas
link: https://account.mongodb.com

```
DB_MONGODB_URI=.....
DB_MONGODB_DATABASE=.....
```

Redis cloud service
link:  https://redis.io (documentation)
link:  https://app.redislabs.com/ (cloud service)

```
REDIS_HOST=......redis-cloud.com
REDIS_PORT=11705
REDIS_USERNAME=....
REDIS_PASSWORD=......
```

test rest api

link: http://httpbin.org

```
HTTP_BIN_URL=http://httpbin.org
HTTP_BIN_BASIC_AUTH_PATH_AUTH=basic-auth
HTTP_BIN_BASIC_AUTH_PATH_BEARER=bearer
HTTP_BIN_BASIC_AUTH_PATH_STATUS=status/{status}
HTTP_BIN_BASIC_AUTH_USER=user
HTTP_BIN_BASIC_AUTH_PASSWORD=passwd
```

Free Fake REST API for Placeholder JSON Data:

link: https://dummyjson.com

```
HTTP_DUMMY_JSON_URL=https://dummyjson.com
HTTP_DUMMY_JSON_PRODUCTS_PATH=products
```

Free fake and reliable API for testing and prototyping:

link: https://jsonplaceholder.typicode.com

```
HTTP_JSON_PLACEHOLDER_URL=https://jsonplaceholder.typicode.com
HTTP_JSON_PLACEHOLDER_URL_PATH_POSTS=posts
HTTP_JSON_PLACEHOLDER_URL_PATH_COMMENTS=comments
HTTP_JSON_PLACEHOLDER_URL_PATH_FIND_POST_BY_ID=posts/{postId}
HTTP_JSON_PLACEHOLDER_URL_PATH_POSTS_COMMENTS=posts/{id}/comments
```

### Java code style

Java code style refers to the conventions and guidelines that developers follow when writing Java code to ensure
consistency and readability.

project: google-java-format,
link: https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config

### Github action

issue:  ./gradlew: Permission denied
link: https://stackoverflow.com/questions/17668265/gradlew-permission-denied

You need to update the execution permission for gradlew

1. add action workflow

2. locally pull changes

3. run Git command:

```
git update-index --chmod=+x gradlew
git add .
git commit -m "Changing permission of gradlew"
git push
```

### Gradle

#### Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found, have upgrades, or
failed to be resolved, info: https://github.com/ben-manes/gradle-versions-plugin

command:

```
gradle dependencyUpdates
```

#### Gradle wrapper

Gradle Wrapper Reference:
https://docs.gradle.org/current/userguide/gradle_wrapper.html

How to Upgrade Gradle Wrapper:
https://dev.to/pfilaretov42/tiny-how-to-upgrade-gradle-wrapper-3obl

```
./gradlew wrapper --gradle-version latest
```