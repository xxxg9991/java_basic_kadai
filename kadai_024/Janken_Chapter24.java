package kadai_024;
import java.util.HashMap;
import java.util.Scanner;

class Jyanken_Chapter24 {
    private Scanner scanner;

    public Jyanken_Chapter24() {
        scanner = new Scanner(System.in);
    }

    public String getMyChoice() {
        System.out.println("自分のじゃんけんの手を入力しましょう:");
        System.out.println("グーはrockのrを入力しましょう");
        System.out.println("チョキはscissorsのsを入力しましょう");
        System.out.println("パーはpaperのpを入力しましょう");

        String choice = scanner.nextLine().toLowerCase();
        while (!isValidChoice(choice)) {
            System.out.println("正しい入力をしてください。もう一度入力してください:");
            choice = scanner.nextLine().toLowerCase();
        }
        return choice;
    }

    public String getRandom() {
        String[] choices = {"r", "s", "p"};
        int randomIndex = (int) (Math.random() * choices.length);
        return choices[randomIndex];
    }

    public void playGame() {
        String myChoice = getMyChoice();
        String opponentChoice = getRandom();

        HashMap<String, String> choicesMap = new HashMap<>();
        choicesMap.put("r", "グー");
        choicesMap.put("s", "チョキ");
        choicesMap.put("p", "パー");

        System.out.println("自分の手は" + choicesMap.get(myChoice) + "、対戦相手の手は" + choicesMap.get(opponentChoice));

        String result = calculateResult(myChoice, opponentChoice);
        System.out.println(result);
    }

    private boolean isValidChoice(String choice) {
        return choice.equals("r") || choice.equals("s") || choice.equals("p");
    }

    private String calculateResult(String myChoice, String opponentChoice) {
        if (myChoice.equals(opponentChoice)) {
            return "あいこです";
        } else if ((myChoice.equals("r") && opponentChoice.equals("s")) ||
                (myChoice.equals("s") && opponentChoice.equals("p")) ||
                (myChoice.equals("p") && opponentChoice.equals("r"))) {
            return "自分の勝ちです";
        } else {
            return "自分の負けです";
        }
    }
}

