[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QWW6IsQU)

# RabbitMQ ve Kafka Arasındaki Farklar

RabbitMQ ve Kafka, modern yazılım mimarilerinde sıkça kullanılan mesaj kuyruğu (message queue) sistemleridir. Her ikisi de uygulamalar arasında asenkron iletişimi sağlama amacını taşır ancak farklı özelliklere ve kullanım senaryolarına sahiptirler.

# Temel Farklar

## Veri Akışı Modeli:


* RabbitMQ:

Genel amaçlı bir mesaj aracısıdır. Mesajlar, belirli kuyruklara gönderilir ve tüketiciler bu kuyruklardan mesajları alır. Daha karmaşık yönlendirme ve routing mekanizmaları sunar.

* Kafka: 

Dağıtılmış bir etkinlik akışı platformudur. Mesajlar, konulara (topics) yayınlanır ve tüketiciler bu konuları abone olarak mesajları alır. Büyük veri hacimlerini gerçek zamanlı olarak işleme konusunda daha optimize edilmiştir.

Mesaj Saklama:

* RabbitMQ: 

Mesajları genellikle bellekte veya diskte saklar. Mesajların kalıcılığı, kuyruk konfigürasyonuna bağlıdır.

* Kafka: 

Mesajları disk üzerindeki parçalara (partitions) dağıtır. Bu sayede yüksek düzeyde dayanıklılık ve ölçeklenebilirlik sağlar. Mesajlar, belirli bir süre boyunca tutulur ve daha sonra silinir.

## Kullanım Senaryoları:

* RabbitMQ:

Karmaşık mesaj yönlendirme ve routing gerektiren uygulamalar
Küçük ölçekli veya orta ölçekli sistemler
İşlem başına bir mesaj gönderilmesi gereken senaryolar

* Kafka:

Büyük veri hacimlerini işleme
Gerçek zamanlı veri işleme
Log toplama ve analiz
Stream işleme
Büyük ölçekli, dağıtık sistemler

## Performans:

* RabbitMQ: 

Genellikle düşük gecikme süresi ve yüksek performans sunar.

* Kafka: 

Büyük veri hacimlerini işleme konusunda daha yüksek performans gösterir.

## Ölçeklenebilirlik:

* RabbitMQ: 

Yatay olarak ölçeklenebilir ancak Kafka kadar ölçeklenebilir değildir.

* Kafka: 

Dağıtılmış bir mimariye sahip olduğu için kolayca ölçeklenebilir.

