package com.game.matchmaking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Weapons")
public class Weapons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weapon_id")
    private Integer weaponId;

    @Column(name = "weapon_name")
    private String weaponName;

    @Column(name = "weapon_type")
    private String weaponType;

    @Column(name = "damage")
    private Integer damage;

    @Column(name = "speed")
    private Integer speed;

    public Weapons() {}

    public Integer getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Integer weaponId) {
        this.weaponId = weaponId;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}

