package org.orak.thirthwebapplication.entity;

import jakarta.persistence.*;

@Entity // Bu anotasyon, Basket sınıfının bir JPA varlığı (entity) olduğunu belirtir.
public class Basket {
    @Id  // Bu anotasyon, basketId alanının bu varlığın birincil anahtarı (primary key) olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Bu anotasyon, basketId alanının otomatik olarak üretileceğini belirtir.
    private int basketId;

    @OneToOne(cascade = CascadeType.ALL)
    // Bu anotasyon, Basket varlığı ile User varlığı arasında birebir (one-to-one) bir ilişki olduğunu belirtir. CascadeType.ALL, bu ilişki üzerindeki tüm işlemlerin (persist, merge, remove, refresh, detach) ilişkilendirilmiş varlığa da uygulanacağını belirtir.
    // Bu anatasyon ; sepet(basket) tablosunun aşağıdaki User ın olduğunu belirtiyor. Yani bu sepetin sahibi user. 1-1
    @JoinColumn(name = "user_id")
    // Bu anotasyon, Basket tablosunda "user_id" adlı bir sütunun User tablosundaki birincil anahtar sütununa yabancı anahtar (foreign key) olarak bağlanacağını belirtir.  // User daki entity ismini buraya eşledik 1-1 ilişki olsun tabloda
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
