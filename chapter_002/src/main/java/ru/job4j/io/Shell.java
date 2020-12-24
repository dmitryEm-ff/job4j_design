package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Shell {

    private List<String> pathDir = new ArrayList<>();

    public void cd(String path) {
        if (path == "/") {
            pathDir.removeAll(pathDir);
            pathDir.add("/");
            return;
        }
        if  (!path.startsWith("/")) {
            pathDir.add("/" + path);
        } else {
            String[] splittedStr = path.split("(?=/)");
            Collections.addAll(pathDir, splittedStr);
        }
        if (pathDir.get(pathDir.size() - 1).equals("/..")) {
            pathDir.remove(pathDir.size() - 1);
            pathDir.remove(pathDir.size() - 1);
            if (pathDir.size() == 0) {
                pathDir.add("/");
            }
        }
    }

    public String pwd() {
        StringBuilder pathFull = new StringBuilder();
        pathDir.forEach(pathFull::append);
        return pathFull.toString();
    }
}