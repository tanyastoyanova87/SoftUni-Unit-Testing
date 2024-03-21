package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int ATTACK_POINTS = 2;
    private static final int DUMMY_EXPECTED_XP = 10;

    private Target dummy;
    private Target deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(Dummy.ALIVE_DUMMY_HEALTH, Dummy.DUMMY_XP);
        deadDummy = new Dummy(Dummy.DEAD_DUMMY_HEALTH, Dummy.DUMMY_XP);
    }

    @Test
    public void testDummyLosesHealthIfAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(Dummy.ALIVE_DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionIfAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyCanGiveXp() {
    Assert.assertEquals(DUMMY_EXPECTED_XP, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXp() {
        dummy.giveExperience();
    }
}