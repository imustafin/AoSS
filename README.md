# AoSS
homework on github https://github.com/imustafin/AoSS

Java Swing+JDBC warehouse application refactoring university assignment.
# Database
Database setup is the same as it was in the original version and can be
set up with the same instructions as in the original task.

This program uses MySQL on localhost port 3306 with user `remote` with password `remote_pass`.

This program assumes MySQL time zone to be UTC.


Additional database is needed for users.

## Add users db

In MySQL:
```
CREATE DATABASE users_db;
```

Then you can import sample user database with users:

| Role                     | Login           | Password        |
|--------------------------|-----------------|-----------------|
| Inventory Administration | `inventory_usr` | `inventory_usr` |
| Make Orders              | `orders_usr`    | `orders_usr`    |
| Shipping                 | `shipping_usr`  | `shipping_usr`  |

```
mysql -p users_db < user_db.sql
```

# Running

After setting up the database, to run the program:
```
java -jar AoSS.jar
```

`lib/mysql-connector-java-8.0.19.jar` should be present!

# Building
This program can be built the same way as it was given.

This program can be imported in NetBeans or can be built with ant:
```
ant -f . -Dnb.internal.action.name=rebuild clean jar
```
