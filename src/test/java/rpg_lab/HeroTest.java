package rpg_lab;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private static final int TARGET_XP = 10;

    @Test
    public void testHeroGainsXpWhenTargetDies() {
        Target fakeTarget = Mockito.mock(Target.class);
        Weapon fakeWeapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Gosho", fakeWeapon);

        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeTarget.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(fakeTarget);
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}