// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    해시맵을 통해서 {고객, {부품: 시간} } 형식으로 저장합니다.
    해당 고객에게 부품이 없으면 처음 빌리는 거고, 있으면 반납하는 것.

    반납할때는, 빌린 시간을 불러와서 최대 빌릴 수 있는 기간이 언제였는지 계산합니다.
    해당 기간이 현재 시간보다 적으면 (초과) 페널티를 부과합니다.
    계산 후, {부품 : 시간}을 삭제합니다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Q21942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] inputs;
    static int day;
    static int hour;
    static int minute;

    public static long calc_fee(String borrowTime, String returnTime, int penalty) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime borrowedTime = LocalDateTime.parse(borrowTime, formatter);
        LocalDateTime maxReturnTime = borrowedTime.plusDays(day).plusHours(hour).plusMinutes(minute);
        LocalDateTime returnedTime = LocalDateTime.parse(returnTime, formatter);

        if (!returnedTime.isAfter(maxReturnTime)) return 0;

        Long overdueMinutes = Duration.between(maxReturnTime, returnedTime).toMinutes();
        return overdueMinutes * penalty;

    }

    public static void main(String[] args) throws IOException {
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        String duration = inputs[1];
        int F = Integer.parseInt(inputs[2]);

        String[] durationInfo1 = duration.split("/");
        String[] durationInfo2 = durationInfo1[1].split(":");
        day = Integer.parseInt(durationInfo1[0]);
        hour = Integer.parseInt(durationInfo2[0]);
        minute = Integer.parseInt(durationInfo2[1]);

        Map<String, Map<String, String>> history = new HashMap<>(); //person :
        Map<String, Long> totalPenalty = new HashMap<>();
        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            String time = inputs[0] + " " + inputs[1];
            String part = inputs[2];
            String name = inputs[3];

            history.putIfAbsent(name, new HashMap<>());
            totalPenalty.putIfAbsent(name, 0L);
            Map<String, String> personHistory = history.get(name);
            if (!personHistory.containsKey(part)) {
                personHistory.put(part, time);
            } else {
                String borrowedTime = personHistory.get(part);
                personHistory.remove(part);
                totalPenalty.put(name, totalPenalty.get(name) + calc_fee(borrowedTime, time, F));
            }
        }

        ArrayList<String[]> ans = new ArrayList<>();
        for (var entry : totalPenalty.entrySet()) {
            if (entry.getValue() <= 0) continue;
            ans.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }
        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(ans, (a,b) -> a[0].compareTo(b[0]));
        for (String[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}

/*

import sys
from datetime import datetime, timedelta
from collections import defaultdict

# sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()


def solution(n, duration, penalty, logs):
    dur_day, dur_time = duration.split("/")
    day = int(dur_day)
    hour, minute = map(int, dur_time.split(":"))

    def calc_fee(borrow_time, return_time):
        datetime_format = "%Y-%m-%d %H:%M"
        borrowed_time = datetime.strptime(borrow_time, datetime_format)
        returned_time = datetime.strptime(return_time, datetime_format)

        max_return_time = borrowed_time + timedelta(days=day, hours=hour, minutes=minute)

        if returned_time <= max_return_time: return 0

        overdue_minutes = (returned_time - max_return_time).total_seconds() // 60
        return overdue_minutes * penalty

    history = defaultdict(dict)
    total_penalty = defaultdict(int)

    for log in logs:
        date, time, part, name = log.split()
        date_time = date + " " + time

        if part not in history[name]:
            history[name][part] = date_time
        else:
            borrowed_time = history[name].pop(part)
            total_penalty[name] += calc_fee(borrowed_time, date_time)

    ans = [(name, total_penalty[name]) for name in total_penalty if total_penalty[name] > 0]
    if not ans:
        print(-1)
        exit()
    ans.sort(key=lambda x: x[0])
    for a in ans:
        print(a[0], str(int(a[1])))


if __name__ == '__main__':
    n, duration, penalty = input().strip().split()
    n = int(n)
    logs = [input().strip() for _ in range(n)]
    solution(n, duration, int(penalty), logs)

 */