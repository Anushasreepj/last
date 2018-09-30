package lifegame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        log.info("matrix 초기 배치가 담긴 파일명을 입력하세요(예: cross.txt) : ");
        String fileName = scanner.nextLine();

        log.info("세대를 입력하세요 : ");
        int num = scanner.nextInt();

        LifeWorld world = new LifeWorld(fileName, num);
        world.getResult().forEach(log::info);
    }
}
