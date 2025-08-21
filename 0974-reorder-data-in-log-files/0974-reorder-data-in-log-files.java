class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] aSplit = a.split(" ", 2);
            String[] bSplit = b.split(" ", 2);

            char a1 = aSplit[1].charAt(0);
            char b1 = bSplit[1].charAt(0);

            if (!Character.isDigit(a1) && !Character.isDigit(b1)) {
                if (aSplit[1].equals(bSplit[1])) {
                    return aSplit[0].compareTo(bSplit[0]);
                } else {
                    return aSplit[1].compareTo(bSplit[1]);
                }
            }

            if (Character.isDigit(a1) && Character.isDigit(b1)) {
                return 0;
            }

            if (Character.isDigit(a1) && !Character.isDigit(b1)) {
                return 1;
            }

            if (!Character.isDigit(a1) && Character.isDigit(b1)) {
                return -1;
            }

            return 0;
        });

        return logs;
    }
}