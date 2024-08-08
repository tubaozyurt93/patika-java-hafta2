[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QWW6IsQU)

Docker ve sanal makineler (Virtual Machines, VM) her ikisi de yazılımın izole bir ortamda çalışmasını sağlamak için kullanılır, ancak farklı yaklaşımlar sunar:
# Docker - Container (Kapsayıcı): 

Docker, uygulamaları ve bağımlılıklarını bir konteynerde paketleyip çalıştırır. Konteynerler, aynı işletim sistemi çekirdeğini paylaşır, bu da onları hafif ve hızlı yapar.

* İzolasyon: Docker konteynerleri, host işletim sisteminden izole edilir, ancak aynı çekirdek üzerinde çalışırlar. Bu, hızlı başlatma süreleri ve düşük kaynak kullanımı sağlar.

* Taşınabilirlik: Docker konteynerleri, geliştirme ve üretim ortamlarında tutarlılığı sağlar. Aynı Docker imajı, farklı sistemlerde aynı şekilde çalışır.

* Kullanım Alanları: Mikro hizmet mimarileri, uygulama geliştirme ve dağıtımı, CI/CD süreçleri gibi senaryolarda yaygın olarak kullanılır.

# Virtual Machine (Sanal Makine)
 

Sanal makineler, fiziksel bir bilgisayarın sanal bir kopyasını oluşturur. Her VM, tam bir işletim sistemi ve uygulama yığını ile birlikte çalışır.

* İzolasyon: Sanal makineler, tam bir işletim sistemi çekirdeğine sahiptir ve bu nedenle daha güçlü izolasyon sağlar. Ancak, daha fazla kaynak tüketirler çünkü her VM kendi işletim sistemi ve çekirdeğiyle birlikte gelir.

* Taşınabilirlik: Sanal makineler, genellikle daha büyük disk görüntüleri içerir ve taşınabilirlik açısından daha sınırlı olabilirler.

* Kullanım Alanları: Tam izolasyon gerektiren uygulamalar, eski işletim sistemlerini çalıştırmak, farklı işletim sistemlerini test etmek gibi durumlarda kullanılır.


