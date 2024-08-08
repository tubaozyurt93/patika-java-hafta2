[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QWW6IsQU)


# Docker Komutları ve Örnekler

# İmajlar ile Çalışma

### Mevcut İmajları Listeleme Açıklama: 

* Sistemde bulunan tüm Docker imajlarını listeler.

* ``` Kod: docker images ```

Yeni İmaj Çekme

* Açıklama: Docker Hub'dan veya başka bir registry'den yeni bir imaj indirir.

* ```Kod: docker pull ubuntu:latest```

İmajı Silme

* Açıklama: 
Sistemdeki bir Docker imajını kaldırır.

* ```Kod: docker rmi ubuntu:latest```

# Konteynerler ile Çalışma

### Çalışan Konteynerleri Listeleme
* Açıklama: Şu anda çalışan Docker konteynerlerinin listesini gösterir.
* ```Kod: docker ps```

### Tüm Konteynerleri Listeleme (Çalışan ve Durdurulmuş)
* Açıklama: Hem çalışan hem de durdurulmuş olan tüm Docker konteynerlerini listeler.
* ```Kod: docker ps -a ```
### Yeni Konteyner Başlatma
* Açıklama: Belirli bir imajdan yeni bir Docker konteyneri başlatır.
* ``` Kod: docker run -d --name mycontainer ubuntu:latest ```
### Konteyneri Durdurma
* Açıklama: Çalışan bir Docker konteynerini durdurur.
* ``` Kod: docker stop mycontainer ```
### Konteyneri Silme
* Açıklama: Durdurulmuş bir Docker konteynerini kaldırır.
* ``` Kod: docker rm mycontainer ```

# Volumes ve Ağlar ile Çalışma
### Yeni Volume (Hacim) Oluşturma
* Açıklama: Veri kalıcılığı sağlamak için yeni bir Docker hacmi oluşturur.
* ``` Kod: docker volume create myvolume ```
### Volume'ı Konteyner ile Bağlama
* Açıklama: Bir Docker hacmini konteynerle belirli bir dizinde paylaşır.
* ``` Kod: docker run -d -v myvolume:/data --name mycontainer ubuntu:latest ```
### Yeni Ağ Oluşturma
* Açıklama: Konteynerler arasında iletişim sağlamak için yeni bir Docker ağı oluşturur.
* ``` Kod: docker network create mynetwork ```
### Konteyneri Ağa Bağlama
* Açıklama: Bir Docker konteynerini belirli bir ağa bağlar.
* ``` Kod: docker run -d --network mynetwork --name mycontainer ubuntu:latest ```

# Dockerfile ile İmaj Oluşturma
### Dockerfile Oluşturma
* Açıklama: İmaj oluşturmak için gerekli talimatları içeren bir Dockerfile dosyası yazılır. 
Örnek Dockerfile içeriği:

```
FROM ubuntu:latest
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY . /app
CMD ["bash"]
```
### Dockerfile Kullanarak İmaj Oluşturma
* Açıklama: Dockerfile'da belirtilen talimatlara göre yeni bir Docker imajı oluşturur.
* ```Kod: docker build -t myimage:latest. ```

