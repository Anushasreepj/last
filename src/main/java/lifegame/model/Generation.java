package lifegame.model;

import lifegame.error.IllegalGenerationException;

public class Generation {
    private final int num;

    private Generation(int num) {
        if (num < 0) {
            throw new IllegalGenerationException("음수로 초기화 불가능 합니다.");
        }

        this.num = num;
    }

    public static Generation of(int num) {
        return new Generation(num);
    }

    public int getNum() {
        return num;
    }

    public boolean checkLastGeneration(int num) {
        return this.num - 1 == num;
    }
}
