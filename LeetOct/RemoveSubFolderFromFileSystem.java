package LeetOct;

import java.util.*;

public class RemoveSubFolderFromFileSystem {
    public static void main(String[] args) {
        String folder[] = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        System.out.println(removeSubfolders(folder));
    }

    public static List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        System.out.println(Arrays.toString(folder));
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String lastString = res.get(res.size() - 1) + '/';
            if (!folder[i].startsWith(lastString)) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}
