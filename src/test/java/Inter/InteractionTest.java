package Inter;

import Engine.Interaction;
import Exceptions.NotEnoughResourcesException;
import MainGame.Resources.GoldResource;
import MainGame.Resources.IronResource;
import MainGame.Resources.UranResource;
import MainGame.Resources.WaterResource;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class InteractionTest implements Interaction {


    private static InteractionTest interactionTest;
    private static List<WaterResource> waterResources;
    private static List<IronResource> ironResources;
    private static List<UranResource> uranResources;
    private static List<GoldResource> goldResources;
    private static List<GoldResource> goldResourcesSecond;

    @BeforeClass
    public static void createTestObjects() {
        interactionTest = new InteractionTest();
        waterResources = new ArrayList<>();
        ironResources = new ArrayList<>();
        uranResources = new ArrayList<>();
        goldResources = new ArrayList<>();
        goldResourcesSecond = new ArrayList<>();
    }

    @Test(expected = NotEnoughResourcesException.class)
    public void methodShouldReturnFalseIfFirstListIsEmpty() throws NotEnoughResourcesException {
        interactionTest.swapResourcesToGold(waterResources, goldResources, 1);
    }

    @Test(expected = NotEnoughResourcesException.class)
    public void methodShouldReturnFalseIfFirstListIsNotAvailableResource() throws NotEnoughResourcesException {
        goldResourcesSecond.add(new GoldResource());
        Assert.assertEquals(false, interactionTest.swapResourcesToGold(goldResourcesSecond, goldResources, 1));
    }

    @Test(expected = NotEnoughResourcesException.class)
    public void methodShouldReturnTrueAndCreateListWithGold50IfWaterResource() throws NotEnoughResourcesException {
        Assert.assertEquals(true, interactionTest.swapResourcesToGold(waterResources, goldResources, 1));
        waterResources.add(new WaterResource());
        Assert.assertEquals(true, interactionTest.swapResourcesToGold(waterResources, goldResources, 1));
        Assert.assertEquals(50, goldResources.size());
        goldResources.clear();
    }


    @Test(expected = NotEnoughResourcesException.class)
    public void methodShouldReturnTrueAndCreateListWithGold100IfIronResource() throws NotEnoughResourcesException {
        Assert.assertEquals(true, interactionTest.swapResourcesToGold(ironResources, goldResources, 1));
        ironResources.add(new IronResource());
        Assert.assertEquals(true, interactionTest.swapResourcesToGold(ironResources, goldResources, 1));
        Assert.assertEquals(100, goldResources.size());
        goldResources.clear();
    }

    @Test(expected = NotEnoughResourcesException.class)
    public void methodShouldReturnTrueAndCreateListWithGold200IfUranResource() throws NotEnoughResourcesException {
        Assert.assertEquals(true, interactionTest.swapResourcesToGold(uranResources, goldResources, 1));
        uranResources.add(new UranResource());
        Assert.assertEquals(true, interactionTest.swapResourcesToGold(uranResources, goldResources, 1));
        Assert.assertEquals(200, goldResources.size());
        goldResources.clear();
    }


}
