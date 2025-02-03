/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            // 처음으로 badVersion을 찾으면 뒤에는 다 badVersion임. 처음 BadVersion 찾는게 목표임
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return n;
    }

}