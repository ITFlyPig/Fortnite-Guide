package com.statstracker.forfornitegame.util;

public class ConstantValue {

    public interface Key{
        /**
         * 请求pubg 的api必须使用key
         */
        String URL_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyM2VkYjdiMC04NmMwLTAxMzYtNDc4YS0xYjQ4MzIxYjIwNTUiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTM0NzgwODUzLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6Ii02ZTE3NjBhMy1jMTVmLTQ2NWEtYjljZC0yNDc2Y2FmZDBhNTEifQ.hQKiiU15IaOYDcc8parL9lE2M31VpbAXPW03T320RM0";
    }


    public interface IntentKey {
        String PLAYER_NAME = "palyer_name";
        String WEAPON_TYPE = "weapon_type";
    }

    public interface WeaponType {
        int GUN = 1;//枪
        int THROW_WEAPON = 2;//投掷武器
        int MELEE_WEAPON = 3;//近战武器
        int FORTNITE_WEAPON = 4;//FORTNITE武器
    }
}
