package com.gc.models;

import javax.persistence.*;

/**
 * Created by angelo on 8/7/17.
 */
@Entity
@Table(name = "wallet", schema = "PassITForward", catalog = "")
public class WalletEntity {
    private int walletId;
    private String walletValue;

    @Id
    @Column(name = "walletID", nullable = false)
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    @Basic
    @Column(name = "walletValue", nullable = false, length = 45)
    public String getWalletValue() {
        return walletValue;
    }

    public void setWalletValue(String walletValue) {
        this.walletValue = walletValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletEntity that = (WalletEntity) o;

        if (walletId != that.walletId) return false;
        if (walletValue != null ? !walletValue.equals(that.walletValue) : that.walletValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = walletId;
        result = 31 * result + (walletValue != null ? walletValue.hashCode() : 0);
        return result;
    }
}
