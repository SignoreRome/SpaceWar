package Engine;

import Exceptions.NotEnoughResourcesException;
import MainGame.Resources.*;

import java.util.ArrayList;
import java.util.List;

public interface Interaction {

    //Обмен любых ресурсов в золото
    default boolean swapResourcesToGold(List<? extends Resources> list1, List<GoldResource> list2, int count) throws NotEnoughResourcesException {
        if (count > list1.size()) throw new NotEnoughResourcesException("Недостаточно ресурсов, требуется: " + count);
        if (count * WaterResource.getCOST_OF_WATER_IN_GOLD() > list2.size())
            throw new NotEnoughResourcesException("Недостаточно золота, требуется: " + count * WaterResource.getCOST_OF_WATER_IN_GOLD());
        if (count * UranResource.getCOST_OF_URAN_IN_GOLD() > list2.size())
            throw new NotEnoughResourcesException("Недостаточно золота, требуется: " + count * UranResource.getCOST_OF_URAN_IN_GOLD());
        if (count * IronResource.getCOST_OF_IRON_IN_GOLD() > list2.size())
            throw new NotEnoughResourcesException("Недостаточно золота, требуется: " + count * IronResource.getCOST_OF_IRON_IN_GOLD());
        String resource = list1.get(0).getClass().getSimpleName();
        for (int i = 0; i < count; i++) {
            list1.remove(list1.size() - 1);
        }
        switch (resource) {
            case "WaterResource":
                for (int i = 0; i < (count * WaterResource.getCOST_OF_WATER_IN_GOLD()); i++) {
                    list2.add(new GoldResource());
                }
                return true;
            case "UranResource":
                for (int i = 0; i < (count * UranResource.getCOST_OF_URAN_IN_GOLD()); i++) {
                    list2.add(new GoldResource());
                }
                return true;
            case "IronResource":
                for (int i = 0; i < (count * IronResource.getCOST_OF_IRON_IN_GOLD()); i++) {
                    list2.add(new GoldResource());
                }
                return true;
            default:
                return false;
        }
    }

    //Обмен золота в железо
    default boolean swapGoldToIron(List<GoldResource> list1, List<IronResource> list2, int count) throws NotEnoughResourcesException {
        int rightAmountMoney = count * IronResource.getCOST_OF_IRON_IN_GOLD();
        if (rightAmountMoney < list1.size())
            throw new NotEnoughResourcesException("Недостаточно золота, требуется: " + rightAmountMoney);
        for (int i = 0; i < rightAmountMoney; i++) {
            list1.remove(list1.size() - 1);
        }
        for (int i = 0; i < count; i++) {
            list2.add(new IronResource());
        }
        return true;
    }


    //Обмен золота в воду
    default boolean swapGoldToWater(List<GoldResource> list1, List<WaterResource> list2, int count) throws NotEnoughResourcesException {
        int rightAmountMoney = count * WaterResource.getCOST_OF_WATER_IN_GOLD();
        if (rightAmountMoney < list1.size())
            throw new NotEnoughResourcesException("Недостаточно золота, требуется: " + rightAmountMoney);
        for (int i = 0; i < rightAmountMoney; i++) {
            list1.remove(list1.size() - 1);
        }
        for (int i = 0; i < count; i++) {
            list2.add(new WaterResource());
        }
        return true;
    }

    //Обмен золота в уран
    default boolean swapGoldToUran(List<GoldResource> list1, List<UranResource> list2, int count) throws NotEnoughResourcesException {
        int rightAmountMoney = count * UranResource.getCOST_OF_URAN_IN_GOLD();
        if (rightAmountMoney < list1.size())
            throw new NotEnoughResourcesException("Недостаточно золота, требуется: " + rightAmountMoney);
        for (int i = 0; i < rightAmountMoney; i++) {
            list1.remove(list1.size() - 1);
        }
        for (int i = 0; i < count; i++) {
            list2.add(new UranResource());
        }
        return true;
    }

    /**
     * Дальше методы для будущей реализации
     **/

    default void getGoldResource(List<GoldResource> listFrom, List<GoldResource> listTo, int count) {
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size() - 1);
            listTo.add(new GoldResource());
        }
    }

    default void getWaterResource(List<WaterResource> listFrom, List<WaterResource> listTo, int count) {
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size() - 1);
            listTo.add(new WaterResource());
        }
    }

    default void getIronResource(List<IronResource> listFrom, List<IronResource> listTo, int count) {
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size() - 1);
            listTo.add(new IronResource());
        }
    }

    default void getUranResource(List<UranResource> listFrom, List<UranResource> listTo, int count) {
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size() - 1);
            listTo.add(new UranResource());
        }
    }

    //Пробный метод, функциональность пока не проверена, добавляет копию 1 элемента ListTo в него же
    default <T> void getResource(List<T> listFrom, List<T> listTo, int count) {
        List<T> tList = new ArrayList<>(listTo);
        if (tList.get(0) instanceof GoldResource) {
            listTo.add((T) new GoldResource());
        }
        for (int i = 0; i < count; i++) {
            listFrom.remove(listFrom.size() - 1);
            listTo.add(tList.get(0));
        }
    }
}
