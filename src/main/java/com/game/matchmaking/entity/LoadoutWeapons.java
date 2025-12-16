package com.game.matchmaking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Loadout_Weapons")
public class LoadoutWeapons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loadout_weapon_id")
    private Integer loadoutWeaponId;

    @Column(name = "loadout_id")
    private Integer loadoutId;

    @Column(name = "weapon_id")
    private Integer weaponId;


    @Column(name = "slot")
    private String slot;

    public LoadoutWeapons() {}

    public Integer getLoadoutWeaponId() {
        return loadoutWeaponId;
    }

    public void setLoadoutWeaponId(Integer loadoutWeaponId) {
        this.loadoutWeaponId = loadoutWeaponId;
    }

    public Integer getLoadoutId() {
        return loadoutId;
    }

    public void setLoadoutId(Integer loadoutId) {
        this.loadoutId = loadoutId;
    }

    public Integer getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Integer weaponId) {
        this.weaponId = weaponId;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
