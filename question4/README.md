[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QWW6IsQU)
# RabbitMQ Kurulumu
### 1.RabbitMQ Docker Konteynerini Çalıştırma:

```docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management ```

Bu komut:
```
-d: Konteyneri arka planda çalıştırır.
--name rabbitmq: Konteynere rabbitmq adını verir.
-p 5672:5672: RabbitMQ'nun varsayılan mesaj kuyruğu portunu dışarıya açar.
-p 15672:15672: RabbitMQ'nun yönetim paneli için portu dışarıya açar.
rabbitmq:management: RabbitMQ'nun yönetim paneli ile birlikte gelen imajını kullanır.
RabbitMQ Yönetim Paneline Erişim: Yönetim paneline http://localhost:15672 adresinden erişebilirsiniz. Varsayılan kullanıcı adı ve şifre guest / guest'tir.
```
# PostgreSQL Kurulumu

### 1.PostgreSQL Docker Konteynerini Çalıştırma:

```docker run -d --name postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 postgres ```

Bu komut:
```
-d: Konteyneri arka planda çalıştırır.
--name postgres: Konteynere postgres adını verir.
-e POSTGRES_PASSWORD=mysecretpassword: PostgreSQL için bir şifre belirler.
-p 5432:5432: PostgreSQL'in varsayılan portunu dışarıya açar.
postgres: PostgreSQL imajını kullanır.
```
### 2.PostgreSQL Veritabanına Erişim: 

PostgreSQL veritabanına localhost:5432 adresinden erişebilirsiniz. Bağlantı için kullanıcı adı postgres ve belirlediğiniz şifreyi kullanabilirsiniz.

# MySQL Kurulumu

### 1.MySQL Docker Konteynerini Çalıştırma:

```docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=mysecretpassword -p 3306:3306 mysql ```

Bu komut:
```
-d: Konteyneri arka planda çalıştırır.
--name mysql: Konteynere mysql adını verir.
-e MYSQL_ROOT_PASSWORD=mysecretpassword: MySQL için bir root şifre belirler.
-p 3306:3306: MySQL'in varsayılan portunu dışarıya açar.
mysql: MySQL imajını kullanır.
```
### 2.MySQL Veritabanına Erişim: 
MySQL veritabanına localhost:3306 adresinden erişebilirsiniz. Bağlantı için kullanıcı adı root ve belirlediğiniz şifreyi kullanabilirsiniz.







