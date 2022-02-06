# About Training Manager
Application named "Training Manager" will help you to store your training data and shows a pretty preview, statistics, ratings, progress through the period.
Also, can help with personal data like weight and height etc. As an alternative to Google Sheets and/or Google Calendar.

## Description
Application consists of two modules: `training-manager-api`
(backend and admin panel of the application) and `training-manager-ui`
(UI of the application).

## Start locally
```
mvn <env variables: -DvariableName='value'> clean install
java <env variables: -DvariableName='value'> -jar <jar location>
```
## Environment variables:

#### Java env:
- POSTGRES_DB_URL (_default_: 'jdbc:postgresql://localhost:5432/skynet_training_manager') - _URL for postgres_
- POSTGRES_DB_USERNAME (_default_: 'postgres') - _database username_
- POSTGRES_DB_PASSWORD (_default_: 'postgres') - _database password_
- ADMIN_USERNAME (_default_: 'admin') - _system admin username_
- ADMIN_PASSWORD (_default_: 'admin') - _system admin password_

[//]: # (## Spring profiles)
[//]: # (- default - *profile, used in production*)
[//]: # (- local - *run application for local development*)
