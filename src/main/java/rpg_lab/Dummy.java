package rpg_lab;

public class Dummy implements Target {
    protected static final int ALIVE_DUMMY_HEALTH = 10;
    protected static final int DEAD_DUMMY_HEALTH = 0;
    protected static final int DUMMY_XP = 10;

    private int health;
    private int experience;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }
}
