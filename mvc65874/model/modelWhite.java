package mvc65874.model;

import java.util.Random;

public class modelWhite {
    private boolean hasEatenLemon = false;
    private boolean isBSOD = false;
    private model model;

    public modelWhite(model model) {
        this.model = model;
    }

    public String milking(String[] cowData) {
        Random random = new Random();
        int month = Integer.parseInt(cowData[3]);
        int code = Integer.parseInt(cowData[0]);

        if (isBSOD) {
            return "This cow is in BSOD state (Blue) and cannot produce milk until reset.";
        }

        if (hasEatenLemon) {
            model.updateMilking(code);
            return "The cow has eaten a lemon and is immune to BSOD. Producing Sour milk.";
        }

        int bsodChance = (int) (month * 0.5 * 10); // This represents the percentage
        int randomChance = random.nextInt(1000) + 5;

        if (randomChance <= bsodChance) {
            isBSOD = true;
            return "BSOD triggered! The cow is now Blue and cannot produce milk.";
        }
        model.updateMilking(code);
        return "Producing regular milk.";
    }

    public void addlemon() {
        hasEatenLemon = true;
    }

}
