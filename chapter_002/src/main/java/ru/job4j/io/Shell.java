package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Shell {

    private List<String> pathDir = new ArrayList<>();

    public void cd(String path) {
//        if (path.endsWith("..")) {
//            if (pathDir.size() < 1) {
//                pathDir.add("/");
//            } else if (pathDir.size() == 1) {
//                pathDir.remove(0);
//                pathDir.add("/");
//            } else {
//                pathDir.remove(pathDir.size() - 1);
//            }
//                return;
//        }

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
            pathDir.set(pathDir.size() - 1, "/");
        }
    }

    public String pwd() {
        StringBuilder pathFull = new StringBuilder();
        pathDir.forEach(pathFull::append);
        return pathFull.toString();
    }
}

//            if (pathDir.size() <= 1) {
//                pathDir.add(0, "/");
//                return;
//            } else {
//                pathDir.remove(pathDir.size() - 1);
//                return;
//            }

//            pathDir.add(path.substring(path.lastIndexOf('/') + 3));
