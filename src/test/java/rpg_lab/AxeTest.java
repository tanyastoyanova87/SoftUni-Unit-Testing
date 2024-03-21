package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private final static int WEAPON_ATTACK = 10;
    private final static int WEAPON_DURABILITY = 10;
    private final static int BROKEN_WEAPON_DURABILITY = 0;
    private final static int DURABILITY_LOSS = 1;
    private Target dummy;
    private Weapon axe;
    private Weapon brokenAxe;

    @Before
    public void setUp() {
        dummy = new Dummy(Dummy.ALIVE_DUMMY_HEALTH, Dummy.DUMMY_XP);
        axe = new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
        brokenAxe = new Axe(WEAPON_ATTACK, BROKEN_WEAPON_DURABILITY);
    }

    @Test
    public void testWeaponLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(WEAPON_DURABILITY - DURABILITY_LOSS, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithABrokenWeaponThrowsException() {
        brokenAxe.attack(dummy);
    }
}