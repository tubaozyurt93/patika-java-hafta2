[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QWW6IsQU)

# Senkron ve Asenkron İletişim: Yazılımdan Örneklerle Açıklama

## Senkron İletişim 

Senkron iletişim, iki veya daha fazla işlem veya sistemin aynı anda ve eş zamanlı olarak iletişim kurduğu bir yöntemdir. Bir işlem diğer işlemden cevap almadan önce ilerleyemez. Bu durum, bir telefon görüşmesi veya canlı bir sohbet gibi, anlık bir etkileşimi gerektiren durumlarda kullanılır.

###  Yazılımdan örnekler:

* Fonksiyon çağrıları: Bir fonksiyon çağrıldığında, çağrı yapan kod satırı fonksiyonun dönüş değerini alana kadar bekler.

### Senkron iletişimin avantajları:

* Basitlik: Anlaşılması ve uygulanması kolaydır.

* Tahmin edilebilirlik: Sonuçlar genellikle hızlı bir şekilde alınır.

### Senkron iletişimin dezavantajları:

* Performans kaybı: Bir işlem diğer işlemi beklerken sistem kaynakları boşta kalabilir.

* Ölçeklenebilirlik sorunları: Birçok istek aynı anda gelirse sistem yavaşlayabilir.

* Kullanıcı deneyimi: Kullanıcılar uzun süre yanıt beklemek zorunda kalabilir.

## Asenkron İletişim

Asenkron iletişimde ise işlemler birbirini beklemeden çalışır. Bir işlem bir istek gönderir ve cevabı daha sonra alır veya hiç almayabilir. Bu yöntem, uzun süren işlemler veya eş zamanlı olarak birçok işlemin yapılması gerektiği durumlarda kullanılır.

### Yazılımdan örnekler:

* Event loop: JavaScript'teki event loop, asenkron programlamanın temelini oluşturur. Bir olay gerçekleştiğinde, ilgili işlev kuyruğa eklenir ve daha sonra işlenir.

* Promise'ler: JavaScript'te promise'ler, asenkron işlemlerin sonuçlarını yönetmek için kullanılır.

* Message queues: Mesaj kuyrukları, uygulamalar arasında asenkron iletişim sağlamak için kullanılır. Bir uygulama bir mesajı kuyruğa gönderir ve diğer uygulama bu mesajı daha sonra işler.

* Web worker'lar: Tarayıcı ortamında uzun süren işlemleri ana iş parçacığından ayırmak için kullanılır.


### Asenkron iletişimin avantajları:

* Performans: Birçok işlem aynı anda çalışabildiği için sistem daha verimli olur.

* Ölçeklenebilirlik: Yüksek yük altında daha iyi performans gösterir.

* Kullanıcı deneyimi: Kullanıcılar uygulamanın yanıt vermemesini beklemek zorunda kalmaz.

### Asenkron iletişimin dezavantajları:

* Karmaşıklık: Anlaşılması ve uygulanması senkron iletişime göre daha zordur.

* Hata ayıklama: Hata tespiti ve düzeltmesi daha zor olabilir.

