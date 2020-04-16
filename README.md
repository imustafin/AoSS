# AoSS
homework


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