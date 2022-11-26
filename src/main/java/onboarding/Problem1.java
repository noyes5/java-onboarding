package onboarding;
;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int choiceAmount = 2;

        for (int i = 0; i < choiceAmount; i++) {
            validate(pobi.get(i));
            validate(crong.get(i));
        }
        return gameStart(winningNumber(pobi), winningNumber(crong));
    }

    private static int validate(int pageNumber) {
        if (pageNumber < 1 || pageNumber > 400) {
            return -1;
        }
        return pageNumber;
    }

    private static int winningNumber(List<Integer> gamer) {
        int sum = 0;
        int val = 1;

        for (int page : gamer) {
            while (page != 0) {
                sum += page % 10;
                val *= page % 10;
                page /= 10;
            }
        }
        return Math.max(sum, val);
    }

    private static int gameStart(int firstPlayer, int secondPlayer) {
        if (firstPlayer > secondPlayer) {
            return 1;
        }
        if (firstPlayer < secondPlayer) {
            return 2;
        }
        return 0;
    }
}