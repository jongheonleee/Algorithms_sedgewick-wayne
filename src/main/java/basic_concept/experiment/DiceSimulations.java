package basic_concept.experiment;

// 두 개의 주사위를 던질 때 나올 수 있는 윗면 숫자의 합을 정확한 확률 분포로 계산해냄
public class DiceSimulations {

    public static void main(String[] args) {
        double[] result = simulate();
        show(result);

        // 출력결과 아래와 같음
        // result = [0.0, 0.0, 0.027777777777777776, 0.05555555555555555, 0.08333333333333333, 0.1111111111111111, 0.1388888888888889, 0.16666666666666666, 0.1388888888888889, 0.1111111111111111, 0.08333333333333333, 0.05555555555555555, 0.027777777777777776, ]
        // 그래프 DiceSimulationsResult 자료 참고
    }

    private static double[] simulate() {
        final int SIDES = 6;
        // 전체 점수 표
        double[] dist = new double[2*SIDES + 1];

        for (int i=1; i<= SIDES; i++) {
            for (int j=1; j<= SIDES; j++) {
                // 시뮬레이션 돌리고 해당 결과 기록
                dist[i+j] += 1.0;
            }
        }

        // dist[k]의 값은 주사위 윗면 숫자의 합이 k가 될 확률
        for (int k=2; k <= 2*SIDES; k++) {
            dist[k] /= 36.0;
        }

        return dist;
    }

    private static void show(double[] dist) {
        StringBuilder sb = new StringBuilder();
        sb.append("result = [");

        for (double num: dist) {
            sb.append(num);
            sb.append(", ");
        }

        sb.append("]");
        System.out.println(sb.toString());
    }
}
