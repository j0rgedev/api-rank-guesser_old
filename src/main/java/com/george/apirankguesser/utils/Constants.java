package com.george.apirankguesser.utils;

import com.george.apirankguesser.dto.ValorantRank;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final List<ValorantRank> VALORANT_RANKS = new ArrayList<>();

    static {
        VALORANT_RANKS.add(new ValorantRank("Iron1", "Iron",1));
        VALORANT_RANKS.add(new ValorantRank("Iron2", "Iron",2));
        VALORANT_RANKS.add(new ValorantRank("Iron3", "Iron",3));
        VALORANT_RANKS.add(new ValorantRank("Bronze1", "Bronze",4));
        VALORANT_RANKS.add(new ValorantRank("Bronze2", "Bronze",5));
        VALORANT_RANKS.add(new ValorantRank("Bronze3", "Bronze",6));
        VALORANT_RANKS.add(new ValorantRank("Silver1", "Silver",7));
        VALORANT_RANKS.add(new ValorantRank("Silver2", "Silver",8));
        VALORANT_RANKS.add(new ValorantRank("Silver3", "Silver",9));
        VALORANT_RANKS.add(new ValorantRank("Gold1", "Gold",10));
        VALORANT_RANKS.add(new ValorantRank("Gold2", "Gold",11));
        VALORANT_RANKS.add(new ValorantRank("Gold3", "Gold",12));
        VALORANT_RANKS.add(new ValorantRank("Platinum1", "Platinum",13));
        VALORANT_RANKS.add(new ValorantRank("Platinum2", "Platinum",14));
        VALORANT_RANKS.add(new ValorantRank("Platinum3", "Platinum",15));
        VALORANT_RANKS.add(new ValorantRank("Diamond1", "Diamond",16));
        VALORANT_RANKS.add(new ValorantRank("Diamond2", "Diamond",17));
        VALORANT_RANKS.add(new ValorantRank("Diamond3", "Diamond",18));
        VALORANT_RANKS.add(new ValorantRank("Ascendant1", "Ascendant",19));
        VALORANT_RANKS.add(new ValorantRank("Ascendant2", "Ascendant",20));
        VALORANT_RANKS.add(new ValorantRank("Ascendant3", "Ascendant",21));
        VALORANT_RANKS.add(new ValorantRank("Immortal1", "Immortal",22));
        VALORANT_RANKS.add(new ValorantRank("Immortal2", "Immortal",23));
        VALORANT_RANKS.add(new ValorantRank("Immortal3", "Immortal",24));
        VALORANT_RANKS.add(new ValorantRank("Radiant", "Radiant",25));
    }
}
