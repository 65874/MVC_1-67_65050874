package mvc65874.model;

import java.util.Random;

public class modelBrown {
    private model model;

    public modelBrown(model model) {
        this.model = model;
    }

    public String milking(String[] cowData) {
        Random random = new Random();
        int year = Integer.parseInt(cowData[2]);
        int code = Integer.parseInt(cowData[0]);

        int bsodChance = year * 1; // This represents the percentage
        int randomChance = random.nextInt(100) + 1;

        if (randomChance <= bsodChance) {
            model.updateMilking(code);
            return "Producing almond milk.";
        }

        model.updateMilking(code);
        return "Producing chocolate milk.";
    }

}
