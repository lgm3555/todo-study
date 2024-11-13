package level1;

public class PlayVideo {
    public static void main(String[] args) {
        solution("34:33", "13:00", "00:55", "02:55", new String[] {"next", "prev"});
    }

    /**
     * 동영상 재생기 (https://school.programmers.co.kr/learn/courses/30/lessons/340213)
     *
     * @param video_len
     * @param pos
     * @param op_start
     * @param op_end
     * @param commands
     * @return
     */
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] videoLen = video_len.split(":");
        String[] opStartLen = op_start.split(":");
        String[] opEndLen = op_end.split(":");
        String[] posLen = pos.split(":");
        int videoT = (Integer.parseInt(videoLen[0]) * 60) + (Integer.parseInt(videoLen[1]));
        int opStartT = (Integer.parseInt(opStartLen[0]) * 60) + (Integer.parseInt(opStartLen[1]));
        int opEndT = (Integer.parseInt(opEndLen[0]) * 60) + (Integer.parseInt(opEndLen[1]));
        int posT = (Integer.parseInt(posLen[0]) * 60) + (Integer.parseInt(posLen[1]));

        posT = checkPos(opStartT, opEndT, posT);

        for (String command : commands) {
            if ("next".equals(command)) {
                if (posT + 10 > videoT) {
                    posT = videoT;
                } else {
                    posT = posT + 10;
                }
            } else if ("prev".equals(command)) {
                if (posT - 10 < 0) {
                    posT = 0;
                } else {
                    posT = posT - 10;
                }
            }

            posT = checkPos(opStartT, opEndT, posT);
        }

        //System.out.println(posT);

        int a = posT / 60;
        int b = posT % 60;

        return String.format("%02d:%02d", a, b);
    }

    private static int checkPos(int opStartT, int opEndT, int posT) {
        if (opStartT <= posT && posT <= opEndT) {
            posT = opEndT;
        }

        return posT;
    }
}
