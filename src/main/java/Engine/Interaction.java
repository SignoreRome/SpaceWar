package Engine;

import MainGame.Resources.*;

import java.util.List;

public interface Interaction {
    //Обмен любых ресурсов в золото
    default void swapResourcesToGold(List<?> list1, List<GoldResource> list2, int count){
        for (int i = 0; i < count; i++) {
            list1.remove(list1.size()-1);
            list2.add(new GoldResource());
        }
    }
    //Обмен золота в железо
    default void swapGoldToIron(List<GoldResource> list1, List<IronResource> list2, int count){
        for (int i = 0; i < count; i++) {
            list1.remove(list1.size()-1);
            list2.add(new IronResource());
        }
    }
    //Обмен золота в воду
    default void swapGoldToWater(List<GoldResource> list1, List<WaterResource> list2, int count){
        for (int i = 0; i < count; i++) {
            list1.remove(list1.size()-1);
            list2.add(new WaterResource());
        }
    }
    //Обмен золорта в уран
    default void swapGoldToUran(List<GoldResource> list1, List<UranResource> list2, int count){
        for (int i = 0; i < count; i++) {
            list1.remove(list1.size()-1);
            list2.add(new UranResource());
        }
    }
    default void getGoldResource(List<GoldResource> listFrom, List<GoldResource> listTo, int count){
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size()-1);
            listTo.add(new GoldResource());
        }
    }
    default void getWaterResource(List<WaterResource> listFrom, List<WaterResource> listTo, int count){
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size()-1);
            listTo.add(new WaterResource());
        }
    }
    default void getIronResource(List<IronResource> listFrom, List<IronResource> listTo, int count){
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size()-1);
            listTo.add(new IronResource());
        }
    }
    default void getUranResource(List<UranResource> listFrom, List<UranResource> listTo, int count){
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size()-1);
            listTo.add(new UranResource());
        }
    }
}
