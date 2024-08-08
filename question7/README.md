[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QWW6IsQU)

API Gateway, Service Discovery ve Load Balancer, dağıtık sistemlerde ve mikroservis mimarilerinde önemli roller oynayan kavramlardır. İşte her birini detaylı bir şekilde açıklamak:

# API Gateway

### Tanım

API Gateway, bir mikroservis mimarisinde tüm API çağrılarını merkezi olarak yöneten ve kontrol eden bir bileşendir. Kullanıcılar veya uygulamalar API Gateway üzerinden mikroservislere erişir.

### İşlevler
* Yönlendirme: API Gateway, gelen talepleri uygun mikroservislere yönlendirir.
* Kimlik Doğrulama ve Yetkilendirme: API Gateway, kullanıcının kimliğini doğrular ve gerekli yetkilendirme işlemlerini gerçekleştirir.
* Kotalama ve Limitler: API çağrılarına sınırlar koyarak aşırı yüklenmeleri önler.
* Veri Dönüştürme: Geriye dönen verileri veya istekleri dönüştürerek farklı formatlarda sunabilir.
* Güvenlik: HTTPS/SSL şifreleme sağlar ve saldırılara karşı koruma sunar.
* Hata Yönetimi: Hataları merkezi olarak yönetir ve uygun hata yanıtları döner.

### Örnek :

Kullanıcılar, bir uygulamanın çeşitli işlevlerine (kullanıcı yönetimi, ürün bilgisi, siparişler vb.) erişmek için tek bir API Gateway URL'sini kullanabilirler. API Gateway, bu talepleri ilgili mikroservislere yönlendirir.
Service Discovery
### Tanım
Service Discovery, dağıtık sistemlerde veya mikroservis mimarilerinde, mikroservislerin birbirlerini dinamik olarak bulmasını sağlayan bir mekanizmadır.
### İşlevler
* Hizmet Kaydı: Mikroservisler, kendilerini ve erişim bilgilerini bir hizmet kaydı sistemine (service registry) kaydederler.
* Hizmet Bulma: Mikroservisler, diğer mikroservislerin mevcut olduğu adresleri ve portları bulmak için hizmet kaydı sistemini kullanır.
* Dinamik Konfigürasyon: Mikroservislerin konfigürasyonları değiştiğinde, bu değişikliklerin otomatik olarak güncellenmesini sağlar.
### Örnek
Bir mikroservis, başka bir mikroservisin konumunu bilmek zorundadır. Service Discovery, bu mikroservislerin adreslerini ve portlarını merkezi bir kayıt üzerinde bulmalarına yardımcı olur.
Load Balancer
Tanım
Load Balancer (yük dengeleyici), gelen ağ trafiğini birden fazla sunucu veya mikroservis arasında dengeli bir şekilde dağıtarak performansı artıran ve yüksek kullanılabilirliği sağlayan bir bileşendir.
### İşlevler
* Yük Dağılımı: Gelen talepleri, arka plandaki sunucular veya hizmetler arasında eşit olarak dağıtır.
* Yüksek Kullanılabilirlik: Bir sunucu veya hizmet başarısız olduğunda, diğer sunuculara yönlendirerek sürekliliği sağlar.
* Performans Optimizasyonu: Trafiği dengeli bir şekilde dağıtarak her sunucunun aşırı yüklenmesini önler.
* Sağlık Kontrolü: Arka plandaki sunucuların sağlık durumunu izler ve başarısız olanları otomatik olarak devre dışı bırakır.
### Örnek
Bir web uygulaması, çok sayıda kullanıcının isteklerini karşılamak için birden fazla sunucuya sahip olabilir. Load Balancer, bu istekleri bu sunucular arasında dengeli bir şekilde dağıtarak performansı ve kullanılabilirliği artırır.
### Karşılaştırma
* API Gateway: API çağrılarını merkezi olarak yönetir ve yönlendirir. Ekstra işlevler (kimlik doğrulama, güvenlik) sağlar.
* Service Discovery: Mikroservislerin birbirlerini dinamik olarak bulmalarını sağlar. Hizmetlerin adreslerini yönetir.
* Load Balancer: Trafiği arka plandaki sunucular arasında dengeler, yüksek kullanılabilirlik ve performans sağlar.
Bu bileşenler, modern dağıtık sistemlerde ve mikroservis mimarilerinde önemli bir rol oynar ve genellikle birlikte kullanılırlar.
### Örnek Senaryo:
Bir e-ticaret uygulamasında, ürün bilgileri, kullanıcı bilgileri ve sipariş bilgileri gibi farklı veriler farklı mikroservislerde saklanır. Bir kullanıcı bir ürün detay sayfasına girdiğinde, API Gateway bu isteği ürün bilgileri hizmetine yönlendirir. Service Discovery, ürün bilgileri hizmetinin hangi sunucularda çalıştığını belirler ve Load Balancer bu sunucular arasında yükü dengeleyerek isteği bir sunucuya yönlendirir.

