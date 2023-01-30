public class Warrior extends Player{
    String armor;
    public Warrior(int hp, int level, String type, String weapon, String armor) {
        super(hp, level, type, weapon);
        this.armor = String.copyValueOf(armor.toCharArray());
    }

    @Override
    public String getFullInfo() {
        return hp+" "+level+" "+type+" "+weapon+" "+armor;
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public boolean doDamage() {
        return true;
    }
}
