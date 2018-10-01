package lifegame.model;

import lifegame.error.IllegalGenerationException;

public class Generation {
    private static final int ZERO = 0;
    private final int num;

    private Generation(int num) {
        if (num <= ZERO) {
            throw new IllegalGenerationException("0 이하 초기화 불가능 합니다.");
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
