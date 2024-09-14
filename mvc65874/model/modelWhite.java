package mvc65874.model;

import java.util.Random;

public class modelWhite {
    private boolean hasEatenLemon = false;
    private boolean isBSOD = false;
    private model model;

    public modelWhite(model model) {
        this.model = model;
    }

    public String mileking(String[] cowData) {
        Random random = new Random();
        int month = Integer.parseInt(cowData[3]);

        if (isBSOD) {
            model.updateMilking(Integer.parseInt(cowData[4]));
            return "This cow is in BSOD state (Blue) and cannot produce milk until reset.";
        }

        if (hasEatenLemon) {
            return "The cow has eaten a lemon and is immune to BSOD. Producing regular milk.";
        }

        int bsodChance = (int) (month * 0.5 * 10); // This represents the percentage
        int randomChance = random.nextInt(1000) + 5;

        if (randomChance <= bsodChance) {
            isBSOD = true;
            return "BSOD triggered! The cow is now Blue and cannot produce milk.";
        }

        model.updateMilking(Integer.parseInt(cowData[4]));
        return "Producing regular milk.";
    }

}
